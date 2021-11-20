package daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.NienKhoa;
import utils.DBConnection;

public class nienkhoaDao {
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private Connection cnn = DBConnection.getConnection();
	
	public List<NienKhoa> getAll() {
		List<NienKhoa> ds = new ArrayList<NienKhoa>();
		String sql = "SELECT `maNK`, `tenNK` FROM `nienkhoa` WHERE 1";
		
		try {
			st = (Statement) cnn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ds.add(new NienKhoa(rs.getString("maNK"), rs.getString("tenNK")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public int addNK(NienKhoa nienKhoa) {
		int res = 0;
		String sql = "INSERT INTO `nienkhoa`(`maNK`, `tenNK`) VALUES (?,?)";
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setString(1, nienKhoa.getMaNK());
			pst.setString(2, nienKhoa.getTenNK());;
			res = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
