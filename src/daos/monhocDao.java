package daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.MonHoc;
import models.TheLoai;
import models.TinChi;
import utils.DBConnection;

public class monhocDao {
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private Connection cnn = DBConnection.getConnection();
	
	public List<MonHoc> getAll() {
		List<MonHoc> ds = new ArrayList<MonHoc>();
		String sql = "SELECT tc.maTC as mTC, tc.soTC as sTC, mh.maMH as mMH, mh.tenMH as tMH, mh.maTL as mTL, tl.maTL as mTL, tl.tenTL as tTL " + 
				" FROM tinchi as tc JOIN monhoc as mh ON tc.maTC = mh.maTC " + 
				" JOIN theloai as tl ON mh.maTL = tl.maTL";
		try {
			st = (Statement) cnn.createStatement();
			rs = st.executeQuery(sql);
		
			while(rs.next()) {
				ds.add(new MonHoc(rs.getString("mMH"), rs.getString("tMH")
						,new TinChi(rs.getString("mTC"), rs.getInt("sTC"))
						, new TheLoai(rs.getString("mTL"), rs.getString("tTL"))));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public int addMH(MonHoc monHoc) {
		int res = 0;
		String sql = "INSERT INTO `monhoc`(`maMH`, `tenMH`, `maTC`, `maTL`) VALUES (?,?,?,?)";
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setString(1, monHoc.getMaMH());
			pst.setString(2, monHoc.getTenMH());
			pst.setString(3, monHoc.getTinchi().getMaTC());
			pst.setString(4, monHoc.getTheloai().getMaTL());
			res = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
