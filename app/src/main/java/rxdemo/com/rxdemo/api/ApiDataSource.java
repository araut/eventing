package rxdemo.com.rxdemo.api;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import rxdemo.com.rxdemo.model.ModelItem;

public interface ApiDataSource {

    Flowable<List<ModelItem>> getItems(int offset, int limit);
//    Single<ModelItem> getItemDetails(String id);
}