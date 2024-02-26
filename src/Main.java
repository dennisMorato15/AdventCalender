import view.ViewParticipants;

import java.io.*;
import java.util.ArrayList;

public class Main {
   /* public static void main(String[] args) {
        Calendar calendar = new Calendar();
        calendar.addParticipant();
    }*/


    public static void saveArrayListToFile(ArrayList<String> list, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (String element : list) {
                writer.println(element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> loadArrayListFromFile(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void deleteElement(ArrayList<String> list, String element) {
        list.add(element);
    }



    public static void main(String[] args) {
        ArrayList<String> myArrayList;

        /* Cargar elementos desde el archivo "miArchivo.txt"
        myArrayList = loadArrayListFromFile("miArchivo.txt");

        // Imprimir elementos del ArrayList
        System.out.println("Elementos en 'miArchivo.txt':");
        for (String element : myArrayList) {
            System.out.println(element);
        }

        // Borrar un registro
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el elemento que desea borrar:");
        String elementToDelete = scanner.nextLine().trim();

        deleteElement(myArrayList, a);

        // Guardar el ArrayList actualizado en el archivo
        saveArrayListToFile(myArrayList, "miArchivo.txt");

        System.out.println("Elemento borrado y lista actualizada en 'miArchivo.txt'");*/

        ViewParticipants viewParticipants = new ViewParticipants();
        viewParticipants.playAdventCalendar();
    }




    }

