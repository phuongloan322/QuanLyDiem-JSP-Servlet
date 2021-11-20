package daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.TinChi;
import utils.DBConnection;

public class tinchiDao {
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private Connection cnn = DBConnection.getConnection();
	
	public List<TinChi> getAll() {
		List<TinChi> ds = new ArrayList<TinChi>();
		String sql = "SELECT `maTC`, `soTC` FROM `tinchi` WHERE 1";
		
		try {
			st = (Statement) cnn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ds.add(new TinChi(rs.getString("maTC"), rs.getInt("soTC")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public int addTC(TinChi tinChi) {
		int res = 0;
		String sql = "INSERT INTO `tinchi`(`maTC`, `soTC`) VALUES (?,?)";
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setString(1, tinChi.getMaTC());
			pst.setInt(2, tinChi.getSoTC());
			res = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
