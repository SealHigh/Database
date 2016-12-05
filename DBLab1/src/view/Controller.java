
package view;

import model.Album;
import model.AlbumCollection;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import model.Artist;
import model.SearchOptions;


public class Controller {
    
    private AlbumCollection ac;
    private View view;
    
    public Controller (AlbumCollection ac, View view) {
        this.ac = ac;
        this.view = view;
    }

    public void handleDeleteAlbumEvent(Album selectedAlbum) {
        ac.deleteRecord(selectedAlbum);
        view.updateTextArea(ac.getAllRecords());
    }

    public void handleGetAllAlbumsEvent() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "handleGetAllAlbumsEvent körs");
                alert.setTitle("");
                alert.setHeaderText(null);      
        view.updateTextArea(ac.getAllRecords());
        
    }

    public void handleQueryEvent(SearchOptions searchOption, String userInput) {
        view.updateTextArea(ac.searchRecord(SearchOptions.TITLE, userInput)); //Searchoption.TITLE is hardcoded temporary since i coded using Enum so gotta change one
        Alert alert = new Alert(Alert.AlertType.WARNING, searchOption.toString());
        alert.showAndWait();
    }
    
    public void handleAddAlbumEvent(String title, String artists, String releaseDate, 
            String nrOfSongs, String length, String genres) throws  NumberFormatException{
        //ac.addAlbum(new Album(Name)); //INte klar - fortsätt!!

        //This is temporary for a quick test
        ArrayList<String> genre = new ArrayList<>();
        ArrayList<Artist> artist = new ArrayList<>();
        genre.add(genres);
        Artist a1 = new Artist(artists, "British");
        artist.add(a1);
        /////////////////////////////////////////////

        ac.insertRecord(new Album(genre,title,artist,releaseDate,length,Integer.parseInt(nrOfSongs))); //This adds it directly to the database
        view.updateTextArea(ac.getAllRecords());

    }
    
    public boolean handleLogInEvent(String userName, String password) {
        return ac.userLogIn(userName,password);
    }
    
    public void handleLogOutEvent() {
        ac.setLoggedInUser(null);
    }

    
    public String validateQueryDialogInput() {
        
        return "";
    }
}
