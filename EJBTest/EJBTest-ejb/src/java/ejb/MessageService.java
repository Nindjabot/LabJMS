package ejb;

import javax.ejb.Stateless;

@Stateless
public class MessageService implements MessageServiceLocal {

    @Override
    public String getMessage(String name) {
        return "Hello, " + name + "!";
    }
}
