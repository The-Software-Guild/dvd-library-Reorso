package org.reorso.dvdlib.dao;

import org.reorso.dvdlib.dto.DVD;

import java.util.List;



public interface DVDLibDao {
        /**
         * Adds the given DVD to the library and associates it with the given
         * DVD title. If there is already a DVD associated with the given
         * title it will return that DVD object, otherwise it will
         * return null.
         *
         * @param title with which dvd is to be associated
         * @param dvd dvd to be added to the library
         * @return the DVD object previously associated with the given
         * title if it exists, null otherwise
         * @throws DVDLibDaoException
         */
        DVD addDVD(String title, DVD dvd)
                throws DVDLibDaoException;

        /**
         * Returns a List of all DVDs in the library.
         *
         * @return DVD List containing all dvds in the library.
         * @throws DVDLibDaoException
         */
        List<DVD> getAllDVDs()
                throws DVDLibDaoException;

        /**
         * Returns the dvd object associated with the given title
         * Returns null if no such dvd exists
         *
         * @param dvdTitle of the dvd to retrieve
         * @return the dvd object associated with the given title,
         * null if no such dvd exists
         * @throws DVDLibDaoException
         */
        DVD getDVD(String dvdTitle)
                throws DVDLibDaoException;

        /**
         * Removes from the library the DVD associated with the given title.
         * Returns the dvd object that is being removed or null if
         * there is no dvd associated with the given title
         *
         * @param dvdTitle title of dvd to be removed
         * @return DVD object that was removed or null if no DVD
         * was associated with the given title
         * @throws DVDLibDaoException
         */
        DVD removeDVD(String dvdTitle)
                throws DVDLibDaoException;

        /**
         * Updates the given DVD in the library.
         */
        public void updateLib() throws DVDLibDaoException;
}

