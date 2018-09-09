package rxdemo.com.rxdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ModelItem implements Parcelable {

    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

//    @SerializedName("url")
//    String url;

    @SerializedName("cover_img_url")
    String coverImageUrl;

    protected ModelItem(Parcel in) {
        id = in.readString();
        name = in.readString();
        coverImageUrl = in.readString();
    }

    public static final Creator<ModelItem> CREATOR = new Creator<ModelItem>() {
        @Override
        public ModelItem createFromParcel(Parcel in) {
            return new ModelItem(in);
        }

        @Override
        public ModelItem[] newArray(int size) {
            return new ModelItem[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return coverImageUrl;
    }

    public void setUrl(String url) {
        this.coverImageUrl = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(coverImageUrl);
    }
}
