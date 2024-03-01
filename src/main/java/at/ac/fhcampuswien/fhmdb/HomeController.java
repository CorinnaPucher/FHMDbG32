package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // add genre filter items
        genreComboBox.getItems().addAll(Genre.values());
        genreComboBox.setPromptText("Filter by Genre");

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        // Sort button:
        sortBtn.setOnAction(actionEvent -> {
            if(sortBtn.getText().equals("Sort (asc)")) {
                // sort observableMovies ascending
                Collections.sort(observableMovies);
                sortBtn.setText("Sort (desc)");
            } else {
                // sort observableMovies descending
                Collections.reverse(observableMovies);
                sortBtn.setText("Sort (asc)");
            }
        });

        // Filter button:
        searchBtn.setOnAction(actionEvent -> {
            String searchValue = searchField.getText().toLowerCase();
            observableMovies.clear();
            for (int i = 0; i < allMovies.size(); i++) {
                Movie m = allMovies.get(i);
                Genre topG = (Genre)genreComboBox.getValue();
                boolean genreEqual;
                boolean titleEqual = m.getTitle().toLowerCase().contains(searchValue);
                boolean descriptionEqual = m.getDescription().toLowerCase().contains(searchValue);
                if(topG == null){
                    genreEqual = true;
                }
                else genreEqual = m.getGenres().contains(topG.toString());

                if ((titleEqual || descriptionEqual) && genreEqual) {
                    observableMovies.add(m);
                }
            }
        });
    }
}