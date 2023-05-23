package core.utils.enums;

public enum DataAttributes {
	ID(0), FIRST_NAME(1), LAST_NAME(2), BUSINESS_NAME(3), EMAIL_ADDRESS(4);

	private int index;

	private DataAttributes(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
}
