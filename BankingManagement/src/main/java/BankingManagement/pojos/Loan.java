package BankingManagement.pojos;

public class Loan {
	
	private int principalAmount;

	private float APR;
	
	private int minCreditScore;

	public Loan(int principalAmount, float aPR, int minCreditScore) {
		super();
		this.principalAmount = principalAmount;
		APR = aPR;
		this.minCreditScore = minCreditScore;
	}

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(int principalAmount) {
		this.principalAmount = principalAmount;
	}

	public float getAPR() {
		return APR;
	}

	public int getMinCreditScore() {
		return minCreditScore;
	}

	@Override
	public String toString() {
		return "Loan [principalAmount=" + principalAmount + ", APR=" + APR + ", minCreditScore=" + minCreditScore + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(APR);
		result = prime * result + minCreditScore;
		result = prime * result + principalAmount;
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
		Loan other = (Loan) obj;
		if (Float.floatToIntBits(APR) != Float.floatToIntBits(other.APR))
			return false;
		if (minCreditScore != other.minCreditScore)
			return false;
		if (principalAmount != other.principalAmount)
			return false;
		return true;
	}
	
	

}
