package rxdemo.com.rxdemo.main;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import rxdemo.com.rxdemo.base.BaseContract;

public class MainContract {

    public interface View extends BaseContract.BaseView {
        void showList(@NonNull List<Object> list);
        void refreshList(@NonNull List<Object> list);
    }

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void setView(@NonNull MainContract.View view);
        Flowable<List<Object>> getList(int page);
        Disposable getDisposoble();
        void subscribeForData();
    }

}