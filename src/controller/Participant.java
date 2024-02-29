package controller;

public class Participant extends ParticipantList{

    ParticipantImpl participant = new ParticipantImpl();
    public void add(){
        participant.addParticipants();
    }
    public void remove(){
        participant.removeParticipants();
    }

    public void list(){
        participant.listParticipants();
    }
    public void play(){
        participant.toPlay();
    }

    public void exit(){
        participant.exitProgram();
    }
}
