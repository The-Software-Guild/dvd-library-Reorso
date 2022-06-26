package org.reorso.dvdlib.dto;


/**
 *  DVD class to store DVD information.
 *  The title will be used as a unique identifier.
 *  This class is a data transfer object.
 * @author Reorso
 */
public class DVD {

    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String director;
    private String studio;
    private String userRating;
    private String userNotes;


    /**
     * Constructor for DVD class.
     */
    public DVD() {

    }
    /**
     * Constructor for DVD class.
     * @param title
     */
    public DVD(String title) {
        this.title = title;
    }

    /**
     * Overloaded constructor for DVD class.
     * @param title
     * @param releaseDate
     * @param mpaaRating
     * @param director
     * @param studio
     * @param userRating
     * @param userNotes
     */
    public DVD(String title, String releaseDate, String director, String studio, String mpaaRating, String userRating, String userNotes) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.mpaaRating = mpaaRating;
        this.director = director;
        this.studio = studio;
        this.userRating = userRating;
        this.userNotes = userNotes;
    }
    /**
     * Returns the title of the DVD in a String.
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the DVD.
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the release date of the DVD in a String.
     * @return the releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the release date of the DVD.
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Returns the MPAA rating of the DVD in a String.
     * @return the mpaaRating
     */
    public String getMpaaRating() {
        return mpaaRating;
    }

    /**
     * Sets the MPAA rating of the DVD.
     * @param mpaaRating the mpaaRating to set
     */
    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    /**
     * Returns the director of the DVD in a String.
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the director of the DVD.
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Returns the studio of the DVD in a String.
     * @return the studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     * Sets the studio of the DVD.
     * @param studio the studio to set
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * Returns the user rating of the DVD in a String.
     * @return the userRating
     */
    public String getUserRating() {
        return userRating;
    }

    /**
     * Sets the user rating of the DVD.
     * @param userRating the userRating to set
     */
    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    /**
     * Returns the user notes of the DVD in a String.
     * @return the userNotes
     */
    public String getNote() {
        return userNotes;
    }

    /**
     * Sets the user notes of the DVD.
     * @param userNotes the userNotes to set
     */
    public void setNote(String userNotes) {
        this.userNotes = userNotes;
    }

}

