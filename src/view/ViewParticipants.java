package view;

import controller.Participant;
import exceptions.Validation;

import java.util.Scanner;

public class ViewParticipants {
    Participant calendar = new Participant();
    Validation validation = new Validation();
    Scanner scannerPlay = new Scanner(System.in);
    public void playAdventCalendar() {
        StringBuilder play;
        do {

            System.out.println("What do you want to do? " +
                    "\n 1: Add" +
                    "\n 2: Delete " +
                    "\n 3: List " +
                    "\n 4: Play " +
                    "\n 5: Exit"
            );
            play = new StringBuilder(validation.transformLetter(scannerPlay.nextLine().trim()));

            switch (play.toString()) {
                case "Add" -> {
                    calendar.add();
                }
                case "Delete" -> {
                    calendar.remove();
                }
                case "List" -> {
                    calendar.list();
                }
                case "Play" -> {
                    calendar.play();
                }
                case "Exit" -> calendar.exit();
                default -> {
                    System.out.println("The data entered is not valid :( ");
                }
            }
        }while (validation.responseToContinue(play.toString()));
    }
}
