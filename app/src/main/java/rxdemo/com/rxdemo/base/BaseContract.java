package rxdemo.com.rxdemo.base;

import android.support.annotation.NonNull;

public interface BaseContract {

    public interface BaseView {
        void showError(@NonNull String error);
    }

    public interface BasePresenter<T> {
        void cleanUp();
    }

}
