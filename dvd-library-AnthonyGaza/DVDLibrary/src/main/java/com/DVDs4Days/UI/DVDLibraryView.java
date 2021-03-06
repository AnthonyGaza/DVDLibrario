package com.DVDs4Days.UI;

import com.DVDs4Days.DTO.DVD;

import java.util.List;

public class DVDLibraryView {
    private UserIO io = new UserIOImplementation();

    public int displayChoicesGetChoice(){
        System.out.println("-=-=-=-= Main Menu =-=-=-=-");
        System.out.println("[1] List all DVDs \n[2] Add DVD \n[3] Remove DVD \n[4] Edit DVD details  \n[5] Show DVD info / Search by title\n[6] EXIT");

        return io.readInt("Please select an option [1-6]",1,6);

    }

    public DVD getNewDVDInfo (){
        System.out.println("============= ADDING DVD =============");
        String title = io.readString("Please enter the title:");
        int releaseDate = io.readInt("Please enter the year of release:",1900,2022);
        String BBFCRating = io.readString("Please enter the BBFC rating");//CHANGED TO BBFC RATING
        String director = io.readString("Please enter the director:");
        String studio = io.readString("Please enter the studio:");
        int userRating = io.readInt("Please enter your rating out of 10:",0,10);

        DVD dvd = new DVD(title);
        dvd.setReleaseDate(releaseDate);
        dvd.setBBFCRating(BBFCRating);
        dvd.setDirector(director);
        dvd.setStudio(studio);
        dvd.setUserRating(userRating);

        return dvd;
    }
    public void displayCreationSuccess(){
        System.out.println("========DVD successfully created========");
    }

    public void displayAllDVDs(List<DVD> DVDList){
        System.out.println("============= SHOWING ALL DVDs =============");
        for (DVD DVD : DVDList){
            String DVDInfo = String.format("Title : %s ||| release : %d ||| rating : %s ||| director : %s " +
                    "||| studio : %s ||| User Rating : %d", DVD.getTitle(),DVD.getReleaseDate(),DVD.getBBFCRating().toUpperCase(),
                    DVD.getDirector(),DVD.getStudio(),DVD.getUserRating());
            System.out.println(DVDInfo);
        }

        io.readString("Press enter to continue");

    }

    public void displayDVDInfo(DVD dvd){
        if (dvd != null){
            System.out.println(dvd);
        } else {
            System.out.println("no such DVD");
        }
    }

    public void exitMessage(){
        System.out.println("Exiting.\n");
    }

    public void showFieldsMenu(){
        System.out.println("[1] Title\n[2] Release Year\n[3] BBFC rating\n[4] Director\n[5] Studio\n"
        +"[6] User rating");
    }



}
