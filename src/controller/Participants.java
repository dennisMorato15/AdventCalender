package controller;

import exceptions.Validation;
import interfaces.IParticipant;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Participants implements IParticipant {
    Validation validation = new Validation();
    private ArrayList<String> listParticipants;
    private String nameFile = "AdventCalendarParticipants.txt";
    Scanner namePlayer = new Scanner(System.in);
    @Override
    public void addParticipants(){
        StringBuilder participant = new StringBuilder();
        System.out.println("Enter the name to add to the game: ");
        System.err.println("Remember that to exit the program you must enter the word 'Exit'");
        do {
            String test = namePlayer.nextLine().trim();
            participant = new StringBuilder(test.substring(0, 1).toUpperCase().concat(test.substring(1).toLowerCase()));
            listParticipants = ParticipantList.loadParticipants(nameFile);

            if(!participant.toString().equals("Exit")){
                if (listParticipants.contains(participant.toString())) {
                    System.out.println("The person with the name " + participant + " is already on the list :()");
                    System.err.println("Try another name ");
                } else {
                    listParticipants.add(participant.toString());
                    System.out.println("Participant " + participant + " successfully entered ☺");
                    System.out.println("Next Participant -> ");
                }
            }
            ParticipantList.saveList(listParticipants, nameFile);

        }while (validation.responseToContinue(participant.toString()));
    }

    @Override
    public void removeParticipants(){
        System.out.println("Enter the name to remove from the game: ");
        String test = namePlayer.nextLine().trim();
        String participant = test.substring(0, 1).toUpperCase().concat(test.substring(1).toLowerCase());

        listParticipants = ParticipantList.loadParticipants(nameFile);
        listParticipants.remove(participant);
        System.out.println();
        ParticipantList.saveList(listParticipants , nameFile);
    }

    @Override
    public void listParticipants(){
        listParticipants = ParticipantList.loadParticipants(nameFile);
        for (String allParticipants : listParticipants){
            System.out.println(allParticipants);
        }
        ParticipantList.saveList(listParticipants , nameFile);
    }

    @Override
    public void toPlay(){
        listParticipants = ParticipantList.loadParticipants(nameFile);
        Random random = new Random();
        int randomNumber = random.nextInt(listParticipants.size());
        String winningParticipant = listParticipants.get(randomNumber);

        System.out.println(" ☺☺☺ I want your luck " + winningParticipant + " you have won, congratulation ☺☺☺ ");
        listParticipants.remove(winningParticipant);
        ParticipantList.saveList(listParticipants , nameFile);
    }

    @Override
    public void exitProgram(){
        System.out.println("Until next time, bye");
        System.exit(0);
    }
}