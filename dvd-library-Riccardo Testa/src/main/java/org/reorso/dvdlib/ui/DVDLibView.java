package org.reorso.dvdlib.ui;

import org.reorso.dvdlib.dto.DVD;

import java.util.List;

public class DVDLibView {


    private UserIO io;

    public DVDLibView(UserIO io) {
        this.io = io;
    }
    public int printMenuAndGetSelection() {
        io.cls();
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. Add a New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public DVD getNewDVDInfo() {
        String title = getNewTitle();
        String releaseDate = getNewReleaseDate();
        String director = getNewDirector();
        String studio = getNewStudio();
        String mpaaRating = getNewMPAA();
        String userRating = getNewUserRating();
        String note = getNewNote();

        DVD currentDVD = new DVD( title, releaseDate, director, studio, mpaaRating,  userRating, note);

        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }


    public void displayDVDList(List<DVD> dvdList) {
        io.print("Title: Release Date | Director | Studio | MPAA Rating | User Rating | Note");
        for (DVD currentDvd : dvdList) {
            String dvdInfo = String.format("%s : %s | %s | %s | %s | %s | %s",
                    currentDvd.getTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getDirector(),
                    currentDvd.getStudio(),
                    currentDvd.getMpaaRating(),
                    currentDvd.getUserRating(),
                    currentDvd.getNote());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    public String getDVDTitleChoice() {
        return io.readString("Please enter the DVD Title ");
    }

    public void displayDVD(DVD dvd, boolean stop) {
        if (dvd != null) {
            io.print("Title: " + dvd.getTitle());
            io.print("Release Date: " +dvd.getReleaseDate());
            io.print("Director: " +dvd.getDirector());
            io.print("Studio: " +dvd.getStudio());
            io.print("MPAA rating: " +dvd.getMpaaRating());
            io.print("User Rating: " +dvd.getUserRating());
            io.print("User Note: " +dvd.getNote());
            io.print(" ");
        } else {
            io.print("No such DVD.");
        }
        if(stop)
            io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD dvdRecord) {
        if(dvdRecord != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");
    }

    public int printEditMenuAndGetSelection() {

        io.print("Edit Options Menu");
        io.print("1. Edit title");
        io.print("2. Edit release date");
        io.print("3. Edit director");
        io.print("4. Edit studio");
        io.print("5. Edit mmpaa rating");
        io.print("6. Edit user rating");
        io.print("7. Edit note");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public String getNewTitle() {
        String title = io.readString("Please enter the dvd title: ");
        return title;
    }

    public String getNewReleaseDate() {
        String releaseDate = io.readString("Please enter the release date: ");
        return releaseDate;
    }

    public String getNewDirector() {
        String director = io.readString("Please enter the name of the director: ");
        return director;
    }

    public String getNewStudio() {
        String studio = io.readString("Please enter the name of the studio: ");
        return studio;
    }

    public String getNewMPAA() {
        String mpaaRating = io.readString("Please enter the dvd mpaa rating: ");
        return mpaaRating;
    }

    public String getNewUserRating() {
        String userRating = io.readString("Please enter the user rating: ");
        return userRating;
    }

    public String getNewNote() {
        String note = io.readString("Please enter a user note: ");
        return note;
    }

    public void displayEditSuccessBanner() {
        io.print("DVD successfully edited. Please hit enter to continue");
    }
}
