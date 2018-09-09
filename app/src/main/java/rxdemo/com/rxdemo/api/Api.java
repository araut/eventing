package rxdemo.com.rxdemo.api;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rxdemo.com.rxdemo.model.ModelItem;

public class Api {

    public RetrofitService service;

    @Inject
    public Api(Retrofit retrofit) {
        service = retrofit.create(RetrofitService.class);
    }

    // TODO: 8/30/18 Not utilizing offset and limit.
    public Flowable<List<ModelItem>> getItems(String lat, String lng, int offset, int limit) {
        return service.getItemsList(lat, lng);
    }

    // TODO: 9/8/18
//    public Single<Object> getItemDetails(String id) {
//        return service.getItemDetails(id);
//    }


    private interface RetrofitService {

        // TODO: 9/8/18
        @GET("")
        Flowable<List<ModelItem>> getItemsList(@Query("lat") String lat, @Query("lng") String lng);

        // TODO: 9/8/18
//        Single<ModelItem> getItemDetails(@Path("id") String id);
    }
}
