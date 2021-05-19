package model;

import java.util.ArrayList;

public class Conversation {

    private int conversationID;
    private ArrayList<Integer> participantIDs;

    public Conversation(int conversationID, ArrayList<Integer> participantIDs) {
        this.conversationID = conversationID;
        this.participantIDs = participantIDs;
    }

    public int getConversationID() {
        return conversationID;
    }

    public void setConversationID(int conversationID) {
        this.conversationID = conversationID;
    }

    public ArrayList<Integer> getParticipantIDs() {
        return participantIDs;
    }

    public void addParticipant(int participantID) {
        this.participantIDs.add(participantID);
    }

    public void removeParticipant(int participantID) {
        if (this.participantIDs.contains(participantID)) {
            this.participantIDs.add(participantID);
        }
    }
}
