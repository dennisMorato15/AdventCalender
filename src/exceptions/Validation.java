package exceptions;

import view.ViewParticipants;

public class Validation {
    public boolean responseToContinue(String response){
            return !response.equals("Exit");
    }
    public String transformLetter(String word) {
        word = word.substring(0, 1).toUpperCase().concat(word.substring(1).toLowerCase());
        return word;
    }
    public boolean validateName(String name){
        String validate  = "^[a-zA-Z\\s]+$";
        return !name.matches(validate);
    }
}
