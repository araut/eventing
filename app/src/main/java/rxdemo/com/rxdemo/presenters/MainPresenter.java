package rxdemo.com.rxdemo.presenters;

import android.support.annotation.NonNull;

import org.reactivestreams.Publisher;

import java.util.Collections;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;
import rxdemo.com.rxdemo.api.ApiDataSource;
import rxdemo.com.rxdemo.main.MainContract;
import rxdemo.com.rxdemo.model.ModelItem;
import rxdemo.com.rxdemo.rxhelpers.RxSchedulerProvider;

public class MainPresenter implements MainContract.Presenter {

    public PublishProcessor<Integer> paginator = PublishProcessor.create();
    private ApiDataSource apiSource;
    private RxSchedulerProvider rxSchedulerProvider;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MainContract.View view;


    public MainPresenter(RxSchedulerProvider rxSchedulerProvider,
                         ApiDataSource apiSource) {
        this.apiSource = apiSource;
        this.rxSchedulerProvider = rxSchedulerProvider;
    }

    @Override
    public void subscribeForData() {

        Disposable disposable = paginator
                .onBackpressureDrop()
                .concatMap((Function<Integer, Publisher<List<ModelItem>>>) page -> {
                    //loading = true;
                    // TODO: 8/29/18 Pagination. Passing 0 as offset.
                    return getList(0);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(items -> {
                    Collections.sort(items, (r1, r2) -> {
                        // TODO: 9/6/18
                        return r1.getName().compareTo(r2.getName());
                    });
                    view.showList(items);
                });

        ((CompositeDisposable) getDisposoble()).add(disposable);

        paginator.onNext(0);

    }


    @Override
    public void setView(@NonNull MainContract.View view) {
        this.view = view;
    }

    @Override
    public Flowable<List<ModelItem>> getList(int page) {
        return apiSource.getItems(page, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Disposable getDisposoble() {
        return compositeDisposable;
    }


    @Override
    public void cleanUp() {
        compositeDisposable.clear();
    }
}
