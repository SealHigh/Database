package model;

//import org.jetbrains.annotations.Contract;

/**
 * Created by Martin on 2016-12-04.
 */
public enum SearchOptions {
    TITLE("title"), ARTIST("artist"), GENRE("genre"), Rating("rating");
    private final String searchQuery;

    SearchOptions(String s) {
        searchQuery = s;
    }

    @Override
    public String toString(){
        return this.searchQuery;
    }
}
