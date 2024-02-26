package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Participants {
    static ArrayList<String> listParticipants;
    private String nameFile = "AdventCalendarParticipants.txt";
    Scanner namePlayer = new Scanner(System.in);
    public void addParticipants(){
        System.out.println("Enter the name to add to the game: ");
        String test = namePlayer.nextLine().trim();
        String participant = test.substring(0, 1).toUpperCase().concat(test.substring(1).toLowerCase());

        listParticipants = ParticipantList.loadParticipants(nameFile);
        if (listParticipants.contains(participant)){
            System.out.println("The person with the name " + participant + " is already on the list :()");
        }else{
        listParticipants.add(participant);
        System.out.println("Participant " + participant + " successfully entered ☺");
        }
        ParticipantList.saveList(listParticipants , nameFile);
    }
    public void removeParticipants(){
        System.out.println("Enter the name to remove from the game: ");
        String test = namePlayer.nextLine().trim();
        String participant = test.substring(0, 1).toUpperCase().concat(test.substring(1).toLowerCase());

        listParticipants = ParticipantList.loadParticipants(nameFile);
        listParticipants.remove(participant);
        System.out.println();
        ParticipantList.saveList(listParticipants , nameFile);
    }
    public void listParticipants(){
        listParticipants = ParticipantList.loadParticipants(nameFile);
        for (String allParticipants : listParticipants){
            System.out.println(allParticipants);
        }
        ParticipantList.saveList(listParticipants , nameFile);
    }
    public void toPlay(){
        listParticipants = ParticipantList.loadParticipants(nameFile);
        Random random = new Random();
        int randomNumber = random.nextInt(listParticipants.size());
        String winningParticipant = listParticipants.get(randomNumber);

        System.out.println(" ☺☺☺ I want your luck " + winningParticipant + " you have won, congratulation ☺☺☺ ");
        listParticipants.remove(winningParticipant);
        ParticipantList.saveList(listParticipants , nameFile);
    }
}