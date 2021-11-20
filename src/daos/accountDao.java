package daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.account;
import utils.DBConnection;

public class accountDao {
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private Connection cnn = DBConnection.getConnection();
	
	public List<account> allAccount() {
		cnn = DBConnection.getConnection();
		List<account> taikhoanList = new ArrayList<account>();
		String sql = "SELECT `id`, `loginID`, `password`, `permission` FROM `account` WHERE 1";
		try {
			st = (Statement) cnn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				account acc = new account(rs.getLong("id"), rs.getString("loginId"), rs.getString("password"), rs.getInt("permission"));
				taikhoanList.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taikhoanList;
	}
	
	public account findAccount(String loginID, String pass) {
		String sql = "SELECT `id`, `loginID`, `password`, `permission`, `name`,`address`"
					+" FROM `account`"
					+" WHERE loginID = ? and password = ?";
//					+" WHERE loginID = '"+loginID+"' and password = '"+pass+"'";
		account acc = null;
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);	//su dung khi truy van ?
			pst.setString(1, loginID);
			pst.setString(2, pass);			
			rs = pst.executeQuery();
			if(rs.next()) {
				acc = new account(rs.getString("loginId"), rs.getString("password"), rs.getInt("permission"), rs.getString("name"), rs.getString("address"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acc;
	}
	public account findAccount(String loginID) {
		String sql = "SELECT `id`, `loginID`, `password`, `permission`"
					+" FROM `account`"
					+" WHERE loginID = ?";
		account acc = null;
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);	
			pst.setString(1, loginID);
			rs = pst.executeQuery();
			if(rs.next()) {
				acc = new account(rs.getLong("id"), rs.getString("loginId"), rs.getString("password"), rs.getInt("permission"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acc;
	}
	public int addAccount(account acc) {
		int result = 0;
		String sql = "INSERT INTO `account`(`loginID`, `password`, `permission`, `name`, `address`) VALUES (?,?,?,?,?)";
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setString(1, acc.getLoginID());
			pst.setString(2, acc.getPassword());
			pst.setInt(3, acc.getPermission());
			pst.setString(4, acc.getName());
			pst.setString(5, acc.getAddress());
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
