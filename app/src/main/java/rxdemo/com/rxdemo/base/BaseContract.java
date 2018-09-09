package rxdemo.com.rxdemo.base;

import android.support.annotation.NonNull;

public interface BaseContract {

    interface BaseView {
        void showError(@NonNull String error);
    }

    interface BasePresenter<T> {
        void cleanUp();
    }

}
