package sg.edu.rp.c346.id22024852.ps_l08_c346;

import androidx.annotation.NonNull;

public class Song {
private int _id;
private String title;
private String singers;
private int year;
private int stars;

public Song (String title, String singers, int year, int stars){
   this.title = title;
   this.singers = singers;
   this.year = year;
   this.stars = stars;
}

public int get_id() {
    return _id;
}

public String getTitle(){
    return title;
}

public int getYear(){
    return year;
}

public int getStar(){
    return stars;
}

    @NonNull
    @Override
    public String toString() {
        return _id + "\n" + title + "\n" + singers + "\n" + year + "\n" + stars + " stars";
    }
}

