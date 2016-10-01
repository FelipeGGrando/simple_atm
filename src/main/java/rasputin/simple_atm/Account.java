package rasputin.simple_atm;

public interface Account {

	String getNumber();
	void depositAmount(int amount);
	void withdrawAmount(int ammount) throws Exception;
	int getAmount();
}
