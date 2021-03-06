package BankingManagement.pojos;

public class Account {
	
	private static int count = 0;

	private String name;
	
	private String password;
	
	private int id;
	
	/*
	 * Java object for holding account information
	 */
	public Account(String name, String password) {
		super();
		Account.count++;
		this.id = Account.count;
		this.name = name;
		this.password = password;
	}
	
	public Account(String name, String password, int id) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.id = id;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Account other = (Account) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", password=" + password + ", id=" + id + "]";
	}
	
	

}
