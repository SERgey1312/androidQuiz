package serega.apps.magicquiz;

import android.os.Parcel;
import android.os.Parcelable;

public class Record implements Parcelable {
    private int id;
    private String username;
    private String category;
    private String complexity;
    private int countTrueAnswers;

    public Record(){}

    public Record(String username, String category, String complexity, int countTrueAnswers){
        this.username = username;
        this.category = category;
        this.complexity = complexity;
        this.countTrueAnswers = countTrueAnswers;
    }

    protected Record(Parcel in) {
        id = in.readInt();
        username = in.readString();
        category = in.readString();
        complexity = in.readString();
        countTrueAnswers = in.readInt();
    }

    public static final Creator<Record> CREATOR = new Creator<Record>() {
        @Override
        public Record createFromParcel(Parcel in) {
            return new Record(in);
        }

        @Override
        public Record[] newArray(int size) {
            return new Record[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(username);
        dest.writeString(category);
        dest.writeString(complexity);
        dest.writeInt(countTrueAnswers);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public int getCountTrueAnswers() {
        return countTrueAnswers;
    }

    public void setCountTrueAnswers(int countTrueAnswers) {
        this.countTrueAnswers = countTrueAnswers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
