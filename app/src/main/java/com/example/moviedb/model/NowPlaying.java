package com.example.moviedb.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class NowPlaying implements Parcelable {

    private int page;
    private List<Results> results;
    private Dates dates;
    private int total_pages;
    private int total_results;

    protected NowPlaying(Parcel in) {
        page = in.readInt();
        total_pages = in.readInt();
        total_results = in.readInt();
    }

    public static final Creator<NowPlaying> CREATOR = new Creator<NowPlaying>() {
        @Override
        public NowPlaying createFromParcel(Parcel in) {
            return new NowPlaying(in);
        }

        @Override
        public NowPlaying[] newArray(int size) {
            return new NowPlaying[size];
        }
    };

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeInt(total_pages);
        dest.writeInt(total_results);
    }

    public static class Dates {
        private String maximum;
        private String minimum;

        public String getMaximum() {
            return maximum;
        }

        public void setMaximum(String maximum) {
            this.maximum = maximum;
        }

        public String getMinimum() {
            return minimum;
        }

        public void setMinimum(String minimum) {
            this.minimum = minimum;
        }
    }

    public static class Results implements Parcelable {
        private String poster_path;
        private boolean adult;
        private String overview;
        private String release_date;
        private List<Integer> genre_ids;
        private int id;
        private String original_title;
        private String original_language;
        private String title;
        private String backdrop_path;
        private double popularity;
        private int vote_count;
        private boolean video;
        private double vote_average;

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public double getVote_average() { return vote_average; }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        @Override
        public int describeContents() { return 0; }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(poster_path);
            parcel.writeByte((byte) (adult ? 1 : 0));
            parcel.writeString(overview);
            parcel.writeString(release_date);
            parcel.writeInt(id);
            parcel.writeString(original_title);
            parcel.writeString(original_language);
            parcel.writeString(title);
            parcel.writeString(backdrop_path);
            parcel.writeDouble(popularity);
            parcel.writeInt(vote_count);
            parcel.writeByte((byte) (video ? 1 : 0));
            parcel.writeDouble(vote_average);

        }
    }
}