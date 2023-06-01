package core.dataProviders;

import model.utils.enums.UserDataAttributes;

public interface UserDataMethods {

    String searchForIndex(String id);

    String searchForFirstName(String id);

    String searchForLastName(String id);

    String searchForEmailAddress(String id);

    String searchForBusinessName(String id);

    String searchForAttribute(UserDataAttributes Attribute, String value);

}
