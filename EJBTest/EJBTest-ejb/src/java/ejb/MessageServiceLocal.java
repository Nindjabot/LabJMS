package ejb;

import javax.ejb.Local;

@Local
public interface MessageServiceLocal {
    String getMessage(String name);
}
