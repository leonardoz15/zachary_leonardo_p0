/**
 * 
 */
package BankingManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;

import BankingManagement.pojos.Banking;
import BankingManagement.util.ConnectionUtil;

/**
 * @author Zachary Leonardo
 *
 */
public class BankingDaoPostgres implements BankingDao {
	
	private ConnectionUtil connUtil = new ConnectionUtil();

	@Override
	public void createBanking(Banking bank) {
		
		String sql = "insert into banking (account_id,loan_id,current_balance,credit_score) values (?, ?, ?, ?)";
		
		try(Connection conn = connUtil.createConnection()){
			
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bank.getAccount().getId());
			pstmt.setNull(2, java.sql.Types.INTEGER); 										//TODO:loan implementation
			pstmt.setInt(3, (int)bank.getCurrentBalance());
			pstmt.setInt(4, bank.getCreditScore());
			
			Savepoint s1 = conn.setSavepoint();
			int rowsEffected = pstmt.executeUpdate();
			
			if (rowsEffected != 1) {
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
	public Banking readBanking(int bankingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Banking> readAllBankings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Banking updateBanking(int bankingId, Banking bank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBanking(Banking bank) {
		// TODO Auto-generated method stub

	}

}
