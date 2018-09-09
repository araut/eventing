package rxdemo.com.rxdemo.application;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import rxdemo.com.rxdemo.api.Api;
import rxdemo.com.rxdemo.main.MainActivity;
import rxdemo.com.rxdemo.presenters.MainPresenter;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(RxDemoApplication app);

    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);

    void inject(Api api);
}
