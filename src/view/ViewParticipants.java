package view;

import controller.Participant;
import validation.Validation;

import java.util.Scanner;

public class ViewParticipants {
    Participant participant = new Participant();
    Validation validation = new Validation();
    Scanner scannerPlay = new Scanner(System.in);
    public void playAdventCalendar() {
        StringBuilder play = new StringBuilder(" ");
        do {
            try {
                System.out.println("What do you want to do? " +
                        "\n 1: Add" +
                        "\n 2: Delete " +
                        "\n 3: List " +
                        "\n 4: Play " +
                        "\n 5: Exit"
                );
                play = new StringBuilder(validation.transformLetter(scannerPlay.nextLine().trim()));

                switch (play.toString()) {
                    case "1" -> {
                        participant.addParticipants();
                    }
                    case "2" -> {
                        participant.removeParticipants();
                    }
                    case "3" -> {
                        participant.listParticipants();
                    }
                    case "4" -> {
                        participant.toPlay();
                    }
                    case "5" -> participant.exitProgram();
                    default -> {
                        System.out.println("The data entered is not valid :( ");
                    }
                }
            }catch (StringIndexOutOfBoundsException e){
                System.err.println("Oh! An error has occurred: " + e);
            }
        } while (validation.responseToContinue(play.toString()));
    }
}
