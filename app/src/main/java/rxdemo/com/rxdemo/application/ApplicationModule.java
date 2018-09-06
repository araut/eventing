package rxdemo.com.rxdemo.application;

import dagger.Module;
import dagger.Provides;

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
}
