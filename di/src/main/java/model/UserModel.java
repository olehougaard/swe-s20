package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class UserModel {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private ArrayList<String> users = new ArrayList<>();

    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void addUser(String username) {
        users.add(username);
    }

    public int getUserCount() {
        return users.size();
    }
}
