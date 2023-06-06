package model.utils.enums;

public enum UserDataAttributes implements AbstractDataAttributes {
    ID(0), FIRST_NAME(1), LAST_NAME(2), BUSINESS_NAME(3), EMAIL_ADDRESS(4);

    private int index;

    private UserDataAttributes(int index) {
	this.index = index;
    }

    public int getIndex() {
	return index;
    }
}
