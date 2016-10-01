package rasputin.simple_atm;

import java.util.UUID;

public class StandardAccount implements Account{

	private String number;
	private String userName;
	private int amount;

	public  StandardAccount(String userName) {
		this.number = UUID.randomUUID().toString();
		this.userName = userName;
	}

	public String getNumber() {
		return number;
	}

	public String getUserName() {
		return userName;
	}

	public void depositAmount(int i) {
		this.amount += i;
	}

	public int getAmount() {
		return amount;
	}

	public void withdrawAmount(int ammount) throws Exception {
		if (this.getAmount() >= ammount) {
			this.amount -= ammount;
		} else {
			throw new Exception(
					"Saldo insuficiente. Seu saldo é de " + this.getAmount()
					+ " e você tentou sacar " + ammount);
		}

	}

}
