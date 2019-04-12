package ba.unsa.etf.rma.VJ_17897;

import android.os.Parcel;
import android.os.Parcelable;

public class Muzicar implements Parcelable {
    private String ime;
    private String zanr;
    private String www;

    public Muzicar(String ime, String zanr, String stranica) {
        this.ime = ime;
        this.zanr = zanr;
        this.www = stranica;
    }

    @Override
    public String toString()
    {
        return ime + "\n" + zanr;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    protected Muzicar(Parcel in){
        ime = in.readString();
        zanr = in.readString();
        www = in.readString();
    }

    public static final Creator<Muzicar> CREATOR = new Creator<Muzicar>() {
        @Override
        public Muzicar createFromParcel(Parcel source) {
            return new Muzicar(source);
        }

        @Override
        public Muzicar[] newArray(int size) {
            return new Muzicar[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ime);
        dest.writeString(zanr);
        dest.writeString(www);
    }
}
