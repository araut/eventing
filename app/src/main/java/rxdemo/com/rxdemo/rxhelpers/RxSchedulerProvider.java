package rxdemo.com.rxdemo.rxhelpers;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;

public interface RxSchedulerProvider {
    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
