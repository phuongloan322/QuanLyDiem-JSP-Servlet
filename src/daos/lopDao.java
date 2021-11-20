package daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.Khoa;
import models.Lop;
import utils.DBConnection;

public class lopDao {
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private Connection cnn = DBConnection.getConnection();

	public List<Lop> getAll() {
		List<Lop> ds = new ArrayList<Lop>();
		String sql = "SELECT"
				+ " l.maLop as lMa,"
				+ " l.tenLop as lTen,"
				+ " l.maKhoa as lMaKH,"
				+ " k.tenKhoa as kTen,"
				+ " k.lienheKhoa as kLH"
				+ " FROM lop as l"
				+ " INNER JOIN khoa as k ON k.maKhoa = l.maKhoa";
		try {
			st = (Statement) cnn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Lop objLop = new Lop(rs.getInt("lMa"), rs.getString("lTen"),
						new Khoa(rs.getString("lMaKH"),
								rs.getString("kTen"),
								rs.getString("kLH")));
				ds.add(objLop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public Lop getLop(String tenLop) {
		Lop lop = new Lop();
		String sql = "SELECT"
				+ " l.maLop as lMa,"
				+ " l.tenLop as lTen,"
				+ " l.maKhoa as lMaKH,"
				+ " k.tenKhoa as kTen,"
				+ " k.lienheKhoa as kLH"
				+ " FROM lop as l"
				+ " INNER JOIN khoa as k ON k.maKhoa = l.maKhoa WHERE tenLop = \""+tenLop+"\"";
		try {
			st = (Statement) cnn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				lop = new Lop(rs.getInt("lMa"), rs.getString("lTen"),
						new Khoa(rs.getString("lMaKH"),
								rs.getString("kTen"),
								rs.getString("kLH")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lop;
	}
	
	public int addLop(Lop L) {
		int res = 0;
		String sql = "INSERT INTO `lop`(`tenLop`, `maKhoa`) VALUES (?,?)";
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setString(1, L.getTenLop());
			pst.setString(2, L.getKhoa().getMaKhoa());
			res = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
