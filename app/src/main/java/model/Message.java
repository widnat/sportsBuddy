package model;

public class Message {

    private int messageID;
    private int senderID;
    private int conversationID;
    private String message;
    private String timestamp;

    public Message(int messageID, int senderID, int conversationID, String message, String timestamp) {
        this.messageID = messageID;
        this.senderID = senderID;
        this.conversationID = conversationID;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getConversationID() {
        return conversationID;
    }

    public void setConversationID(int conversationID) {
        this.conversationID = conversationID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
