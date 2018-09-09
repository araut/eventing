package rxdemo.com.rxdemo.application;

import dagger.Module;
import dagger.Provides;
import rxdemo.com.rxdemo.api.Api;
import rxdemo.com.rxdemo.api.ApiDataSource;
import rxdemo.com.rxdemo.api.ApiManager;
import rxdemo.com.rxdemo.main.MainContract;
import rxdemo.com.rxdemo.presenters.MainPresenter;
import rxdemo.com.rxdemo.rxhelpers.RxSchedulerProvider;
import rxdemo.com.rxdemo.rxhelpers.ThreadedRxSchedulerProvider;

@Module
class ApplicationModule {

    private RxDemoApplication rxDemoApplication;

    public ApplicationModule(RxDemoApplication rxDemoApplication) {
        this.rxDemoApplication = rxDemoApplication;
    }

    @Provides
    public RxDemoApplication providesApplication() {
        return rxDemoApplication;
    }

    @Provides
    ApiDataSource providesApiSource(Api api) {
        return new ApiManager(api);
    }

    @Provides
    RxSchedulerProvider providesRxSchedulerProvider() {
        return new ThreadedRxSchedulerProvider();
    }

    @Provides
    MainContract.Presenter providesMainPresenter(RxSchedulerProvider rxSchedulerProvider,
                                                 ApiDataSource apiSource) {
        return new MainPresenter(rxSchedulerProvider, apiSource);
    }
}
