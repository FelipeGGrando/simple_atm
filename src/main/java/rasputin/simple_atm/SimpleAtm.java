package rasputin.simple_atm;

import java.util.ArrayList;
import java.util.List;

public class SimpleAtm {
	
	private List<Account> accounts = new ArrayList<Account>();
	
	public boolean addAccount(Account account){
		if(this.accounts.contains(account))
			return false;
		
		return this.accounts.add(account);
	}

	public List<Account> getAccounts() {
		return  this.accounts;
	}

	public void deposit(int amount, String accountNumber) throws Exception {
		Account account = null;
		
		account = findAccountByNumber(accountNumber);
		account.depositAmount(amount);
	}

	public void withdraw(int ammount, String accountNumber) throws Exception {
		Account account = findAccountByNumber(accountNumber);
		account.withdrawAmount(ammount);
	}


	public void transfer(int ammount, String originAccountNumber, String targetAccountNumber) throws Exception {
		Account originAccount = findAccountByNumber(originAccountNumber);
		Account targetAccount = findAccountByNumber(targetAccountNumber);
		
		if(originAccount.getAmount() >= ammount){
			originAccount.withdrawAmount(ammount);
			targetAccount.depositAmount(ammount);
		}else{
			throw new Exception("Saldo insuficiente. Seu saldo é de " 
					+ originAccount.getAmount() 
					+ " e você tentou trasnferir "
					+ ammount);
		}
	}
	
	
	private Account findAccountByNumber(String accountNumber) throws Exception {
		Account accountFounded = null;
		
		for(Account account : accounts)
			if(accountNumber.equals(account.getNumber()))
				accountFounded = account;
		
		if(accountFounded == null)
			throw new Exception("Conta não encontrada");
		
		return accountFounded;
	}

}
