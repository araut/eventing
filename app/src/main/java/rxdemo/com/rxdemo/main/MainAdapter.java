package rxdemo.com.rxdemo.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rxdemo.com.rxdemo.R;
import rxdemo.com.rxdemo.model.ModelItem;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private final OnItemClickListener listener;
    private List<ModelItem> list;

    public MainAdapter(OnItemClickListener listener) {
        this.listener = listener;
        list = new ArrayList<>();
    }

//    void addItems(List<ModelItem> items) {
//        Timber.d("Size is " + list.size());
//        list.addAll(items);
//    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void setItemList(List<ModelItem> list) {
        this.list = list;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new CustomViewHolder(row);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {


        holder.bindData(list.get(position));
        holder.click(list.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener {
        void onClick(ModelItem Item);
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageview)
        ImageView imageView;
        @BindView(R.id.title_textview)
        TextView titleTextView;
        @BindView(R.id.name_textview)
        TextView nameTextView;

        CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindData(@NonNull ModelItem item) {
            Picasso.get()
                    .load(item.getUrl())
                    .into(imageView);
            titleTextView.setText(item.getName());
            nameTextView.setText(item.getId());
        }

        // TODO: 9/8/18
//        private String parseTagsToReadableString(String[] tags) {
//            if (tags.length == 1) {
//                return tags[0];
//            } else if (tags.length > 1) {
//                StringBuilder stringBuilder = new StringBuilder();
//                for (int i = 0; i < tags.length; i++) {
//                    stringBuilder.append(tags[i]);
//                    if (i < tags.length - 1) {
//                        stringBuilder.append(", ");
//                    }
//                }
//                return stringBuilder.toString();
//            } else {
//                return "";
//            }
//        }

        public void click(final ModelItem data, final OnItemClickListener listener) {
            itemView.setOnClickListener(v -> listener.onClick(data));
        }
    }
}
