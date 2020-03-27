package viewmodel;

import javafx.beans.property.StringProperty;
import model.UserModel;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MessageViewModelTest extends EasyMockSupport {
    private MessageViewModel viewModel;
    @Rule
    public EasyMockRule rule = new EasyMockRule(this);
    @Mock
    StringProperty property;

    @Before
    public void setUp() {
        UserModel model = new UserModel();
        model.addUser("user1");
        model.addUser("user2");
        viewModel = new MessageViewModel(model, property);
    }

    @Test
    public void updateDisplaysNumberOfUsers() {
        property.set("Number of users: 2");
        replayAll();
        viewModel.update();
        verifyAll();
    }
}
