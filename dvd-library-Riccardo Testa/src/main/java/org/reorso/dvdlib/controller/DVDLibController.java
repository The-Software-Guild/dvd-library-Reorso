package org.reorso.dvdlib.controller;
import org.reorso.dvdlib.dao.DVDLibDao;
import org.reorso.dvdlib.dao.DVDLibDaoException;
import org.reorso.dvdlib.dto.DVD;
import org.reorso.dvdlib.ui.DVDLibView;
import org.reorso.dvdlib.ui.UserIO;
import org.reorso.dvdlib.ui.UserIOConsoleImpl;

import java.util.List;

public class DVDLibController {

    //private ClassRosterView view = new ClassRosterView();
    private UserIO io = new UserIOConsoleImpl();
    //private ClassRosterDao dao = new ClassRosterDaoFileImpl();


    private DVDLibView view;
    private DVDLibDao dao;


    public DVDLibController(DVDLibDao dao, DVDLibView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();
                io.cls();
                switch (menuSelection) {
                    case 1:
                        listDVD();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;
                    case 5:
                        editDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
        }
        catch (DVDLibDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
        exitMessage();
    }

    private void editDVD() throws DVDLibDaoException {
        view.displayEditDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(dvdTitle);
        if (dvd != null) {
            view.displayDVD(dvd ,false);
            int editSelection = view.printEditMenuAndGetSelection();
            switch (editSelection) {
                case 1:
                    String newTitle = view.getNewTitle();
                    DVD newDVD = dao.removeDVD(dvdTitle);
                    newDVD.setTitle(newTitle);
                    dao.addDVD(newTitle,newDVD);
                    break;
                case 2:
                    String newReleaseDate = view.getNewReleaseDate();
                    dvd.setReleaseDate(newReleaseDate);
                    break;
                case 3:
                    String newDirector = view.getNewDirector();
                    dvd.setDirector(newDirector);
                    break;
                case 4:
                    String newStudio = view.getNewStudio();
                    dvd.setStudio(newStudio);
                    break;
                case 5:
                    String newMpaaRating = view.getNewMPAA();
                    dvd.setMpaaRating(newMpaaRating);
                    break;
                case 6:
                    String newUserRating = view.getNewUserRating();
                    dvd.setUserRating(newUserRating);
                    break;
                case 7:
                    String newNote = view.getNewNote();
                    dvd.setNote(newNote);
                    break;
                default:
                    unknownCommand();
            }
            dao.updateLib();
            view.displayEditSuccessBanner();
        }
        else {
            view.displayErrorMessage("Error: DVD not found.");
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws DVDLibDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void listDVD() throws DVDLibDaoException {
        view.displayDisplayAllBanner();
        List<DVD> DVDList = dao.getAllDVDs();
        view.displayDVDList(DVDList);
    }

    private void viewDVD() throws DVDLibDaoException {
        view.displayDisplayDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(dvdTitle);
        view.displayDVD(dvd, true);
    }

    private void removeDVD() throws DVDLibDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitleChoice();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemoveResult(removedDVD);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
