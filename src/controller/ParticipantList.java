package controller;

import java.io.*;
import java.util.ArrayList;

public class ParticipantList {


    protected static void saveList(ArrayList<String> savePartition, String fileName) {
        try(PrintWriter  file = new PrintWriter(new FileWriter(fileName))){
            for (String list : savePartition){
                file.println(list);
            }
        }
        catch (IOException ioException){
            System.err.println("fOh! An error has occurred " + ioException);
        }
    }

    protected static ArrayList<String> loadParticipants(String fileName) {
       ArrayList<String> listParticipants = new ArrayList<>();
        String loadLine;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)))
        {
            while((loadLine = bufferedReader.readLine()) != null ) {
                listParticipants.add(loadLine);
            }
        } catch (IOException ioException) {
            System.err.println("Oh! An error has occurred " + ioException);
        }
    return listParticipants;
    }
}

