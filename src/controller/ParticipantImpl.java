package controller;

import exceptions.Validation;
import interfaces.IParticipant;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ParticipantImpl implements IParticipant {
    Validation validation = new Validation();
    private ArrayList<String> listParticipants;
    StringBuilder participant;
    private String nameFile = "AdventCalendarParticipants.txt";
    Scanner namePlayer = new Scanner(System.in);
    @Override
    public void addParticipants(){
        System.out.println("Enter the name to add to the game: ");
        System.err.println("Remember that to exit the program you must enter the word 'Exit'");

        do {
            participant = new StringBuilder(validation.transformLetter(namePlayer.nextLine().trim()));
            listParticipants = ParticipantList.loadParticipants(nameFile);
            if (validation.validateName(participant.toString())){
                System.out.println("The person's name must not contain special characters or numbers");
                System.out.println("Entered a valid name -> ");
                continue;
            }
            if(!participant.toString().equals("Exit")){
                if (listParticipants.contains(participant.toString())) {
                    System.out.println("The person with the name " + participant + " is already on the list :()");
                    System.out.println("Try another name -> ");
                } else {
                    listParticipants.add(participant.toString());
                    System.out.println("Participant " + participant + " successfully entered ☺");
                    System.out.println("Next Participant -> ");
                }
            }else {
                exitProgram();
            }

            ParticipantList.saveList(listParticipants, nameFile);
        }while (validation.responseToContinue(participant.toString()));
    }

    @Override
    public void removeParticipants(){
        System.out.println("Enter the name to remove from the game: ");
        System.err.println("Remember that to exit the program you must enter the word 'Exit'");

       do {
           if (validation.validateName(participant.toString())) {
               System.out.println("The person's name must not contain special characters or numbers");
               System.out.println("Entered a valid name -> ");
               continue;
           }
           participant = new StringBuilder(validation.transformLetter(namePlayer.nextLine().trim()));
           listParticipants = ParticipantList.loadParticipants(nameFile);

           if (!participant.toString().equals("Exit")){
               if (!listParticipants.contains(participant.toString())){
                   System.out.println("The person with the name " + participant + " does not exist in the list");
                   System.out.println("Try again -> ");
               }else {
                   listParticipants.remove(participant.toString());
                   System.out.println("oh! you have removed the participant " + participant + "from the game :(" );
               }
           }else {
               exitProgram();
           }

           ParticipantList.saveList(listParticipants , nameFile);
       }while (validation.responseToContinue(participant.toString()));

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