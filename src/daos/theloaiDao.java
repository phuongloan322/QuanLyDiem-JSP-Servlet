package daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.TheLoai;
import utils.DBConnection;

public class theloaiDao {
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private Connection cnn = DBConnection.getConnection();
	
	public List<TheLoai> getAll() {
		List<TheLoai> ds = new ArrayList<TheLoai>();
		String sql = "SELECT `maTL`, `tenTL` FROM `theloai` WHERE 1";
		
		try {
			st = (Statement) cnn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ds.add(new TheLoai(rs.getString("maTL"),rs.getString("tenTL")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public int addTL(TheLoai theLoai) {
		int res = 0;
		String sql = "INSERT INTO `theloai`(`maTL`, `tenTL`) VALUES (?,?)";
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setString(1, theLoai.getMaTL());
			pst.setString(2, theLoai.getTenTL());
			res = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
