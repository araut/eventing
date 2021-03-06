package rxdemo.com.rxdemo.rxhelpers;


import android.support.annotation.NonNull;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class ImmediateRxSchedulerProvider implements RxSchedulerProvider {


    @NonNull
    @Override
    public Scheduler computation() {
        return Schedulers.trampoline();
    }

    @NonNull
    @Override
    public Scheduler io() {
        return Schedulers.trampoline();
    }

    @NonNull
    @Override
    public Scheduler ui() {
        return Schedulers.trampoline();
    }
}
