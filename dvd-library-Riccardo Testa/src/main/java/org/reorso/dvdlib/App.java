package org.reorso.dvdlib;
import org.reorso.dvdlib.controller.DVDLibController;
import org.reorso.dvdlib.dao.DVDLibDao;
import org.reorso.dvdlib.dao.DVDLibDaoFileImpl;
import org.reorso.dvdlib.ui.DVDLibView;
import org.reorso.dvdlib.ui.UserIO;
import org.reorso.dvdlib.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibView myView = new DVDLibView(myIo);
        DVDLibDao myDao = new DVDLibDaoFileImpl();
        DVDLibController controller =
                new DVDLibController(myDao, myView);
        controller.run();
    }

}
