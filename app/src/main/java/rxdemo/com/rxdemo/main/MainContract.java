package rxdemo.com.rxdemo.main;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import rxdemo.com.rxdemo.base.BaseContract;
import rxdemo.com.rxdemo.model.ModelItem;

public class MainContract {

    public interface View extends BaseContract.BaseView {
        void showList(@NonNull List<ModelItem> list);
        void refreshList(@NonNull List<ModelItem> list);
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void setView(@NonNull MainContract.View view);
        Flowable<List<ModelItem>> getList(int page);
        Disposable getDisposoble();
        void subscribeForData();
    }

}