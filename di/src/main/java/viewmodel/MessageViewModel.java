package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import model.UserModel;

public class MessageViewModel implements PropertyChangeListener {
    private UserModel model;
    private StringProperty message;

    public MessageViewModel(UserModel model) {
        this(model, new SimpleStringProperty());
    }

    public MessageViewModel(UserModel model, StringProperty message) {
        this.model = model;
        model.addListener(this);
        this.message = message;
    }

    public void update() {
        message.set("Number of users: " + model.getUserCount());
    }

    public StringProperty getMessageProperty() {
        return message;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(this::update);
    }
}
