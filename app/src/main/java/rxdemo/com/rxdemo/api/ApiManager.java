package rxdemo.com.rxdemo.api;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import rxdemo.com.rxdemo.model.ModelItem;

public class ApiManager implements ApiDataSource {

    @Inject
    Api api;

    // TODO: 9/8/18  
    private String lat = "";
    private String lng = "";


    @Inject
    public ApiManager(Api api) {
        this.api = api;
    }

    @Override
    public Flowable<List<ModelItem>> getItems(int offset, int limit) {
        return api.getItems(lat, lng, offset, limit);
    }

//    @Override
//    public Single<ModelItem> getItemDetails(String id) {
//        return null;
//    }
}
