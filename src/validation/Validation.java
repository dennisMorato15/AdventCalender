package validation;

import java.util.ArrayList;

public class Validation {
    public boolean responseToContinue(String response){
            return !response.equals("Back");
    }
    public String transformLetter(String word) {
        word = word.substring(0, 1).toUpperCase().concat(word.substring(1).toLowerCase());
        return word;
    }
    public boolean validateName(String name){
        String validate  = "^[a-zA-Z\\s]+$";
        return !name.matches(validate);
    }

    public boolean validationExitParticipant(ArrayList<String> participants , String name){
        return participants.contains(name);
    }
}
