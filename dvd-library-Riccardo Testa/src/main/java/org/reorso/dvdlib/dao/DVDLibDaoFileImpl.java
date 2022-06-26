package org.reorso.dvdlib.dao;

import org.reorso.dvdlib.dto.DVD;

import java.io.*;
import java.util.*;

public class DVDLibDaoFileImpl implements DVDLibDao {


    private Map<String, DVD> dvds = new HashMap<>();
    public static final String LIB_FILE = "lib.txt";
    public static final String DELIMITER = "::";


    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibDaoException {
            loadLibrary();
            DVD newDVD = dvds.put(title, dvd);
            writeLibrary();
            return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs()  throws DVDLibDaoException {
        loadLibrary();
        return new ArrayList(dvds.values());
    }

    @Override
    public DVD getDVD(String dvdTitle)  throws DVDLibDaoException {
        loadLibrary();
        return dvds.get(dvdTitle);
    }

    @Override
    public DVD removeDVD(String dvdTitle)  throws DVDLibDaoException {
        loadLibrary();
        DVD removedDVD = dvds.remove(dvdTitle);
        writeLibrary();
        return removedDVD;
    }

    @Override
    public void updateLib() throws DVDLibDaoException {
        writeLibrary();
    }
    private DVD unmarshallDVD(String dvdAsText){

        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String dvdTitle = dvdTokens[0];

        DVD dvdFromFile = new DVD(dvdTitle);

        // Index 1 - ReleaseDate
        dvdFromFile.setReleaseDate(dvdTokens[1]);

        // Index 2 - Director
        dvdFromFile.setDirector(dvdTokens[2]);

        // Index 3 - Studio
        dvdFromFile.setStudio(dvdTokens[3]);

        // Index 4 - mpaaRating
        dvdFromFile.setMpaaRating(dvdTokens[4]);

        // Index 5 - userRating
        dvdFromFile.setUserRating(dvdTokens[5]);

        // Index 6 - Note
        dvdFromFile.setNote(dvdTokens[6]);

        // We have now created a DVD! Return it!
        return dvdFromFile;
    }

    private void loadLibrary() throws DVDLibDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIB_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibDaoException(
                    "-_- Could not load library data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDVD holds the most recent dvd unmarshalled
        DVD currentDVD;
        // Go through LIB_FILE line by line, decoding each line into a
        // DVD object by calling the unmarshallDVD method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a DVD
            currentDVD = unmarshallDVD(currentLine);

            // We are going to use the title as the map key for our DVD object.
            // Put currentDVD into the map using title as the key
            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        scanner.close();
    }

    private String marshallDVD(DVD aDVD){
        // We need to turn a DVD object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer.

        // Start with the title, since that's supposed to be first.
        String dvdAsText = aDVD.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:

        // release date
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;

        // director
        dvdAsText += aDVD.getDirector() + DELIMITER;

        // studio
        dvdAsText += aDVD.getStudio() + DELIMITER;

        // rating
        dvdAsText += aDVD.getMpaaRating() + DELIMITER;

        // user rating
        dvdAsText += aDVD.getUserRating() + DELIMITER;

        // note
        dvdAsText += aDVD.getNote();

        // We have now created a DVD! Return it!

        return dvdAsText;
    }



    /**
     * Writes all DVDs in the library out to a LIB_FILE.  See loadLibrary
     * for file format.
     *
     * @throws DVDLibDaoException if an error occurs writing to the file
     */
    private void writeLibrary() throws DVDLibDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIB_FILE));
        } catch (IOException e) {
            throw new DVDLibDaoException(
                    "Could not save DVD data.", e);
        }

        // Write out the DVD objects to the lib file.
        // NOTE TO THE APPRENTICES: We could just grab the dvd map,
        // get the Collection of DVDs and iterate over them but we've
        // already created a method that gets a List of DVDs so
        // we'll reuse it.
        String dvdAsText;
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            // turn a DVD into a String
            dvdAsText = marshallDVD(currentDVD);
            // write the DVD object to the file
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
