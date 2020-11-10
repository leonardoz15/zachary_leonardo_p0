/**
 * 
 */
package BankingManagement.pojos;

/**
 * @author Zachary Leonardo
 *
 */
public class Banking {
	
	private Account account;
	
	private double currentBalance;
	
	private int creditScore;
	
	/**
	 *  Java object for holding banking information tied to an account
	 */
	public Banking() {
		// TODO Auto-generated constructor stub
	}
	
	public Banking(Account account) {
		super();
		this.account = account;
		this.currentBalance = 0;
		this.creditScore = 0;
	}

	public Banking(Account account, double currentBalance) {
		super();
		this.account = account;
		this.currentBalance = currentBalance;
		this.creditScore = 0;
	}
	
	public Banking(Account account, double currentBalance, int creditScore) {
		super();
		this.account = account;
		this.currentBalance = currentBalance;
		this.creditScore = creditScore;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the currentBalance
	 */
	public double getCurrentBalance() {
		return currentBalance;
	}

	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	/**
	 * @return the creditScore
	 */
	public int getCreditScore() {
		return creditScore;
	}

	/**
	 * @param creditScore the creditScore to set
	 */
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		long temp;
		temp = Double.doubleToLongBits(currentBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banking other = (Banking) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (Double.doubleToLongBits(currentBalance) != Double.doubleToLongBits(other.currentBalance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Banking [account=" + account.toString() + ", currentBalance=" + currentBalance + "]";
	}
	
	
	
}
