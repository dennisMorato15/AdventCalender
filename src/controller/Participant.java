package controller;

public class Participant extends ParticipantList{

    ParticipantImpl participant = new ParticipantImpl();
    public void addParticipants(){
        participant.add();
    }
    public void removeParticipants(){
        participant.remove();
    }

    public void listParticipants(){
        participant.list();
    }
    public void toPlay(){
        participant.play();
    }

    public void exitProgram(){
        participant.exit();
    }
}
