package rxdemo.com.rxdemo.application;

import android.app.Application;

public class RxDemoApplication extends Application {

    private static RxDemoApplication rxDemoApplication;
    private ApplicationComponent applicationComponent;

    public static ApplicationComponent getAppComponent() {
        return getInstance().applicationComponent;
    }

    public static RxDemoApplication getInstance() {
        return rxDemoApplication;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        rxDemoApplication = this;
        applicationComponent = buildAppComponenent();
    }

    protected ApplicationComponent buildAppComponenent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
