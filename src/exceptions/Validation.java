package exceptions;

public class Validation {

    public boolean responseToContinue(String response){
        if(response.equals("Exit")){
            return false;
        }else{
            return true;
        }
    }
}
