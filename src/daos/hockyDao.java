package daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.hocky;
import utils.DBConnection;

public class hockyDao {
	
	private Connection cnn = DBConnection.getConnection();
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	
	public List<hocky> getAll() {
		List<hocky> ds = new ArrayList<hocky>();
		String sql ="SELECT `maHK`, `tenHK` FROM `hocky` WHERE 1";
		try {
			st = (Statement) cnn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ds.add(new hocky(rs.getString("maHK"), rs.getString("tenHK")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public int add(hocky hk) {
		String sql = "INSERT INTO `hocky`(`maHK`, `tenHK`) VALUES (?,?)";
		int res = 0;
		try {
			
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setString(1, hk.getMaHK());
			pst.setString(2, hk.getTenHK());
			res = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
