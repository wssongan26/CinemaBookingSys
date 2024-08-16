/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment;

/**
 *
 * @author btglo
 */
import java.util.ArrayList;
import java.util.List;

public class MovieDetails {
    private String title;
    private String description;
    private String duration;
    private String genre;
    private String language;
    private String subtitle;
    private String classification;

    // Constructor
    public MovieDetails(String title, String description, String duration, String genre,
                        String language, String subtitle, String classification) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.genre = genre;
        this.language = language;
        this.subtitle = subtitle;
        this.classification = classification;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getClassification() {
        return classification;
    }

    // Main method to create movie details
    public static List<MovieDetails> createMovieDetailsList() {
        List<MovieDetails> movieDetailsList = new ArrayList<>();

        movieDetailsList.add(new MovieDetails(
                "One Piece: Stampede",
                "The movie takes place during the Pirates Festival, \"made by pirates, for pirates\", where pirates all over the world, including some of its most infamous ones, join in for a big treasure hunt to find a lost treasure, this time the treasure belonged to none other than Gold Roger!",
                "1hr 41min",
                "animation, fantasy, action, adventure",
                "Japanese",
                "English/Chinese",
                "P13"
        ));

        movieDetailsList.add(new MovieDetails(
                "Saw II",
                "Detective Eric Matthews, along with fellow police officers and a SWAT Team, locate Jigsaw's lair and go to arrest him, but discover that his arrest is only a part of Jigsaw's plan. Matthews soon learns that eight people are trapped in an old house and are playing one of Jigsaw's games. One of them is his own son, Daniel Matthews. Eric learns that if he wants to see his son again, he must play one of Jigsaw's games as well.",
                "1hr 35min",
                "horror, mystery",
                "English",
                "Malay",
                "R"
        ));

        movieDetailsList.add(new MovieDetails(
            "Love The Way You Are",
            "Opposites clash when spunky girl next door Lin Lin meets eccentric nerd Yuke. Despite being neighbors and schoolmates since childhood, Lin Lin and Yuke barely know each other. When the pair are both admitted into the same university, Lin Lin discovers that Yuke harbors a secret crush for campus beauty, Ruting. Ever the busybody, Lin Lin decides to matchmake Yuke and Ruting, only to find herself gradually falling for Yuke.",
            "1hr 32min",
            "romance, comedy",
            "Chinese",
            "English/Malay",
            "P13"
        ));

        movieDetailsList.add(new MovieDetails(
                "Land of the Dead",
                "Now that zombies have taken over the world, the living have built a walled-in city to keep the dead out. But all's not well where it's most safe, as a revolution plans to overthrow the city leadership, and the zombies are turning into more advanced creatures.",
                "1hr 33min",
                "horror, sci-fi",
                "Chinese",
                "Malay",
                "R"
        ));

        movieDetailsList.add(new MovieDetails(
                "Despicable Me 2",
                "Now that Gru has forsaken a life of crime to raise Margo, Agnes and Edith, he's trying to figure out how to provide for his new family. As he struggles with his responsibilities as a father, the Anti-Villain League, an organization dedicated to fighting evil, comes calling. The AVL sends Gru on a mission to capture the perpetrator of a spectacular heist, for who would be better than the world's greatest ex-villain to capture the individual who seeks to usurp his power.",
                "1hr 33min",
                "animation, adventure, comedy",
                "English",
                "-",
                "PG"
        ));


        return movieDetailsList;
    }
    
    
}