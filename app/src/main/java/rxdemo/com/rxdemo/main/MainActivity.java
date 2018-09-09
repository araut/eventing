package rxdemo.com.rxdemo.main;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rxdemo.com.rxdemo.R;
import rxdemo.com.rxdemo.application.RxDemoApplication;
import rxdemo.com.rxdemo.model.ModelItem;

public class MainActivity extends AppCompatActivity implements MainContract.View {


    MainAdapter adapter;

    @Inject
    MainContract.Presenter presenter;
    @BindView(R.id.main_recyclerview)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxDemoApplication.getAppComponent().inject(this);
        ButterKnife.bind(this);
        setupRecyclerView();
        presenter.setView(MainActivity.this);
        presenter.subscribeForData();
    }

    private void setupRecyclerView() {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter = new MainAdapter(Item -> goToDetailsActivity(Item));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        presenter.cleanUp();
        super.onPause();
    }


    private void goToDetailsActivity(ModelItem modelItem) {
        // TODO: 9/6/18
        Toast.makeText(this, "Go To DetailView", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showList(@NonNull List<ModelItem> modelItemList) {
        adapter.setItemList(modelItemList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void refreshList(@NonNull List<ModelItem> modelItemList) {
        // TODO: 8/29/18
    }

    @Override
    public void showError(@NonNull String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

}
