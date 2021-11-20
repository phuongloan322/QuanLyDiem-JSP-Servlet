package daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.Diem;
import models.GiangVien;
import models.Khoa;
import models.Lop;
import models.MonHoc;
import models.NamHoc;
import models.SinhVien;
import models.TheLoai;
import models.TinChi;
import models.hocky;
import utils.DBConnection;

public class diemDao {
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private Connection cnn = DBConnection.getConnection();
	
	public int NhapDiem(Diem diem) {
		int res = 0;
		String sql = "INSERT INTO `diem`(`diem1`, `diem2`, `diem3`, `tongDiem`, `maGV`, `maSV`, `maMH`, `maTC`, `maTL`, `maHK`, `maNH`)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setFloat(1, diem.getDiem1());
			pst.setFloat(2, diem.getDiem2());
			pst.setFloat(3, diem.getDiem3());
			pst.setFloat(4, diem.getTongDiem());
			pst.setString(5, diem.getGiangVien().getMaGV());
			pst.setString(6, diem.getSinhVien().getMaSV());
			pst.setString(7, diem.getMonHoc().getMaMH());
			pst.setString(8, diem.getTinChi().getMaTC());
			pst.setString(9, diem.getTheLoai().getMaTL());
			pst.setString(10, diem.getHocky().getMaHK());
			pst.setString(11, diem.getNamHoc().getMaNH());
			res = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public List<Diem> getAll() {
		List<Diem> ds = new ArrayList<Diem>();
		String sql ="SELECT d.maBD as dstt\r\n" + 
				", d.diem1 as d1, \r\n" + 
				"d.diem2 as d2, \r\n" + 
				"d.diem3 as d3, \r\n" + 
				"d.tongDiem as dtong,\r\n" + 
				"d.maGV as dmagv, gv.tenGV as tengv,gv.diachi as diachigv, gv.sdt as sdtgv, gv.email as mailgv,\r\n" + 
				"d.maSV as dmasv, sv.tenSV as tensv, sv.diachi as diachisv, sv.sdt as sdtsv, sv.email as mailsv, \r\n" + 
				"sv.maLop as malopsv, \r\n" + 
				"l.tenLop as tenlop,\r\n" + 
				"d.maMH as dmamh, mh.tenMH as tenmh,\r\n" + 
				"d.maTC as dmatc, tc.soTC as sotc,\r\n" + 
				"d.maTL as dmatl, tl.tenTL as tentl,\r\n" + 
				"d.maHK as dmahk, hk.tenHK as tenhk,\r\n" + 
				"d.maNH as dmanh, nh.tenNH as tennh\r\n" + 
				"FROM diem AS d JOIN namhoc as nh on d.maNH = nh.maNH \r\n" + 
				"join theloai as tl on d.maTL = tl.maTL \r\n" + 
				"JOIN tinchi as tc on d.maTC = tc.maTC \r\n" + 
				"JOIN monhoc as mh ON d.maMH = mh.maMH \r\n" + 
				"JOIN giangvien as gv on d.maGV = gv.maGV \r\n" + 
				"JOIN sinhvien as sv on d.maSV = sv.maSV \r\n" + 
				"join hocky as hk on d.maHK = hk.maHK \r\n" + 
				"JOIN lop as l ON sv.maLop = l.maLop\r\n" + 
				"WHERE 1";
		try {
			st = (Statement) cnn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				NamHoc namHoc = new NamHoc(rs.getString("dmanh"), rs.getString("tennh"));
				Lop lop = new Lop(Integer.parseInt(rs.getString("malopsv")), rs.getString("tenlop"), new Khoa(null, null, null));
				hocky hocKy = new hocky(rs.getString("dmahk"), rs.getString("tenhk"));
				TheLoai theLoai = new TheLoai(rs.getString("dmatl"), rs.getString("tentl"));
				TinChi tinChi = new TinChi(rs.getString("dmatc"), Integer.parseInt(rs.getString("sotc")));
				MonHoc monHoc = new MonHoc(rs.getString("dmamh"), rs.getString("tenmh"), tinChi, theLoai);
				SinhVien sinhVien = new SinhVien(rs.getString("dmasv"), rs.getString("tensv"), rs.getString("diachisv"),
						Integer.parseInt(rs.getString("sdtsv")), rs.getString("mailsv"), lop);
				GiangVien giangVien = new GiangVien(rs.getString("dmagv"), rs.getString("tengv"), rs.getString("diachigv"),  Integer.parseInt(rs.getString("sdtgv")),  rs.getString("mailgv"));
				int stt = Integer.parseInt( rs.getString("dstt"));
				float d1 = Float.parseFloat(rs.getString("d1"));
				float d2 = Float.parseFloat(rs.getString("d2"));
				float d3 = Float.parseFloat(rs.getString("d3"));
				float dtong = Float.parseFloat(rs.getString("dtong"));
				Diem diem = new Diem(stt, d1, d2, d3, dtong, giangVien, sinhVien, monHoc, tinChi, theLoai, hocKy, namHoc, lop);
				ds.add(diem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
