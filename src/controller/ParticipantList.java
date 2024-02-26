package controller;
import java.io.*;
import java.util.ArrayList;

public class ParticipantList {

    protected static void saveList(ArrayList<String> savePartition, String fileName) {
        try(PrintWriter file = new PrintWriter(new FileWriter(fileName))){
            for (String list : savePartition){
                file.println(list);
            }
        }
        catch (IOException ioException){
            ioException.printStackTrace();
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
            ioException.printStackTrace();
        }
    return listParticipants;
    }
}

