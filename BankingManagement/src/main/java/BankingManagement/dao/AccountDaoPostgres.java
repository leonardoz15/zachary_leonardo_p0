/**
 * 
 */
package BankingManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

import BankingManagement.pojos.Account;
import BankingManagement.util.ConnectionUtil;
import org.apache.log4j.Logger;

/**
 * @author Zachary Leonardo
 *
 */
public class AccountDaoPostgres implements AccountDao {
	
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	private static Logger log = Logger.getRootLogger();

	/**
	 * @param connUtil the connUtil to set
	 */
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public void createAccount(Account account) {
		
		String sql = "insert into account (username,password) values (? , ?)";
		
		try(Connection conn = connUtil.createConnection()){
			
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getName());
			pstmt.setString(2, account.getPassword());
			
			Savepoint s1 = conn.setSavepoint();
			int rowsEffected = pstmt.executeUpdate();
			
			if (rowsEffected != 1) {
				log.warn("More than one account created, rolling back");
				conn.rollback(s1);
			} else {
				conn.commit();
			}
			
			conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Account readAccount(int accountId) {
		
		String sql = "select * from account where account_id = ?";
		
		try (Connection conn = connUtil.createConnection()){
						
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountId);
			
			ResultSet rs = pstmt.executeQuery();
			Account account = new Account();
			while(rs.next()) {
				account.setId(rs.getInt(1));
				account.setName(rs.getString(2));
				account.setPassword(rs.getString(3));
			}
			return account;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<Account> readAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account updateAccount(int accountId, Account account) {
		
		String sql = "update account set username = ?, password = ? where account_id = ?";
		
		try (Connection conn = connUtil.createConnection()){
			
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getName());
			pstmt.setString(2, account.getPassword());
			pstmt.setInt(3, accountId);
			
			Savepoint s1 = conn.setSavepoint();
			int rowsEffected = pstmt.executeUpdate();
			
			if (rowsEffected != 1) {
				conn.rollback(s1);
				log.warn("More than one account updated, rolling back");
			} else {
				conn.commit();
			}
			
			conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteAccount(Account account) {
		
		String sql = "delete from account where username = ? and password = ? and account_id = ?";
		
		try (Connection conn = connUtil.createConnection()){
			
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getName());
			pstmt.setString(2, account.getPassword());
			pstmt.setInt(3, account.getId());
			
			Savepoint s1 = conn.setSavepoint();
			int rowsEffected = pstmt.executeUpdate();
			
			if (rowsEffected != 1) {
				log.warn("More than one account updated, rolling back");
				conn.rollback(s1);
			} else {
				conn.commit();
			}
			
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
