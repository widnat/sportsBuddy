package data;

import java.util.ArrayList;

import model.Conversation;
import model.Location;
import model.Message;
import model.User;

public class DummyData {

    private ArrayList<Conversation> conversations;
    private ArrayList<Location> locations;
    private ArrayList<Message> messages;
    private ArrayList<User> users;

    private static DummyData singleton = null;

    private DummyData() {
        conversations = new ArrayList<>();
        locations = new ArrayList<>();
        messages = new ArrayList<>();
        users = new ArrayList<>();
        addMe();
    }

    public static DummyData getInstance() {
        if (singleton == null) {
            singleton = new DummyData();
        }

        return singleton;
    }

    public ArrayList<Conversation> getConversations() {
        return conversations;
    }

    private void addConversation(Conversation conversation) {
        this.conversations.add(conversation);
    }


    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void addLocation(Location location) {
        this.locations.add(location);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    private void addMe() {
        User me = new User("widnat", "nate", "widmer", 1);
        addUser(me);
    }
}
