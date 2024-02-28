package view;

import controller.Participants;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewParticipants {
    Participants calendar = new Participants();
    Scanner scannerPlay = new Scanner(System.in);
    public void playAdventCalendar() {
        System.out.println("What do you want to do? " +
                    "\n 1: Add " +
                    "\n 2: Delete " +
                    "\n 3: List " +
                    "\n 4: Play " +
                    "\n 5: Exit"
            );
        String test = scannerPlay.nextLine().trim();
        String play = test.substring(0, 1).toUpperCase() + test.substring(1).toLowerCase();

            switch (play) {
                case "Add" -> {
                    calendar.addParticipants();
                }
                case "Delete" ->{
                    calendar.removeParticipants();
                }
                case "List" -> {
                    calendar.listParticipants();
                }
                case "Play" -> {
                    calendar.toPlay();
                }
                case "Exit" -> calendar.exitProgram();
                default -> {
                    System.out.println("The data entered is not valid :( ");
                }
            }
    }
}
