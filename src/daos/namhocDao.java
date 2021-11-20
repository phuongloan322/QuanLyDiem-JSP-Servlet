package daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.corba.se.spi.orbutil.fsm.State;

import models.NamHoc;
import utils.DBConnection;

public class namhocDao {
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private Connection cnn = DBConnection.getConnection();
	
	public List<NamHoc> getAll() {
		List<NamHoc> ds = new ArrayList<NamHoc>();
		String sql = "SELECT `maNH`, `tenNH` FROM `namhoc` WHERE 1";
		
		try {
			st = (Statement) cnn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ds.add(new NamHoc(rs.getString("maNH"), rs.getString("tenNH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public int addNK(NamHoc namHoc) {
		int res = 0;
		String sql = "INSERT INTO `namhoc`(`maNH`, `tenNH`) VALUES (?,?)";
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setString(1, namHoc.getMaNH());
			pst.setString(2, namHoc.getTenNH());
			res = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
