package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.http.Part;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

import constans.GlobalConstans;
import daos.diemDao;
import daos.giangvienDao;
import daos.hockyDao;
import daos.monhocDao;
import daos.namhocDao;
import daos.theloaiDao;
import daos.tinchiDao;
import jdk.nashorn.internal.runtime.GlobalConstants;
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

@MultipartConfig
public class InScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public static final int COLUMN_INDEX_MASV = 0;
	 public static final int COLUMN_INDEX_HOTEN = 1;
	 public static final int COLUMN_INDEX_HS1 = 2;
	 public static final int COLUMN_INDEX_HS3 = 3;
	 public static final int COLUMN_INDEX_DIEMTHI = 4;
	 public static final int COLUMN_INDEX_DIEMHP = 5;
	 public static final int COLUMN_INDEX_LOP = 6;
	
	public InScoreController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userInfor") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		monhocDao monHocDAO = new monhocDao();
		List<MonHoc> monhocList = monHocDAO.getAll();
		request.setAttribute("monhocList", monhocList);
		
		hockyDao hockyDAO = new hockyDao();
		List<hocky> hockyList = hockyDAO.getAll();
		request.setAttribute("hockyList", hockyList);
		
		namhocDao namhocDAO = new namhocDao();
		List<NamHoc> namhocList = namhocDAO.getAll();
		request.setAttribute("namhocList", namhocList);
		
		giangvienDao giangvienDAO = new giangvienDao();
		List<GiangVien> giangvienList = giangvienDAO.getAll();
		request.setAttribute("giangvienList", giangvienList);
		
		tinchiDao tinchiDAO = new tinchiDao();
		List<TinChi> tinchiList = tinchiDAO.getAll();
		request.setAttribute("tinchiList", tinchiList);
		
		theloaiDao theloaiDAO = new theloaiDao();
		List<TheLoai> theloaiList = theloaiDAO.getAll();
		request.setAttribute("theloaiList", theloaiList);
		
		diemDao dDao = new diemDao();
		List<Diem> dsDiem = dDao.getAll();
		request.setAttribute("diemList", dsDiem);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/inScore.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		diemDao dDao = new diemDao();
		
		String maMonHoc = request.getParameter("maMonHoc");
		String maHocKy = request.getParameter("maHocKy");
		String maNamHoc = request.getParameter("maNamHoc");
		String maGiangVien = request.getParameter("maGiangVien");
		String maTinChi = request.getParameter("maTinChi");
		String maTheLoai = request.getParameter("maTheLoai");
		
		String filePath = null;
		Part part = request.getPart("fileExcel");
		String fileName = part.getSubmittedFileName();
		if(!"".equals(fileName)) {
			//lấy đường dẫn thực của dự án
			String dirPath = request.getServletContext().getRealPath("")+ GlobalConstans.DIR_UPLOAD;
			File saveDir = new File(dirPath);
			if(!saveDir.exists()) {
				saveDir.mkdirs();
			}
			filePath = dirPath + File.separator + fileName;
			part.write(filePath);
		}
		List<Diem> diemList = readExcel(filePath);
		for(Diem diem : diemList) {
			if(diem.getSinhVien() == null) {
				System.out.println("Loi null");
				break;
			}
			diem.setGiangVien(new GiangVien(maGiangVien, null, null, 0, null));
			diem.setHocky(new hocky(maHocKy, null));
			diem.setNamHoc(new NamHoc(maNamHoc, null));
			diem.setTinChi(new TinChi(maTinChi, 0));
			diem.setTheLoai(new TheLoai(maTheLoai, null));
			diem.setMonHoc(new MonHoc(maMonHoc, null, new TinChi(maTinChi, 0), new TheLoai(maTheLoai, null)));
			Diem objDiem = new Diem(0, diem.getDiem1()
								, diem.getDiem2()
								, diem.getDiem3()
								, diem.getTongDiem()
								, new GiangVien(maGiangVien, null, null, 0, null)
								, new SinhVien(diem.getSinhVien().getMaSV(), null, null, 0, null,
											new Lop(0, null, new Khoa(null, null, null)))
								, new MonHoc(maMonHoc, null, new TinChi(null, 0), 
											new TheLoai(null, null))
								, new TinChi(maTinChi, 0)
								, new TheLoai(maTheLoai, null)
								, new hocky(maHocKy, null)
								, new NamHoc(maNamHoc, null)
								, new Lop(0, null, new Khoa(null, null, null)));
			int rs = dDao.NhapDiem(objDiem);
			if(rs > 0) {
				response.sendRedirect(request.getContextPath()+"/inScore?msg=OK");
			}else {
				response.sendRedirect(request.getContextPath()+"/inScore?msg=ERROR");
			}
		}
	}
	
	private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
		Workbook workbook = null;
		if(excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if(excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}
		return workbook;
	}
	
	private static Object getCellValue(Cell cell) {
		org.apache.poi.ss.usermodel.CellType cellType = cell.getCellTypeEnum();
		Object cellValue = null;
		switch (cellType) {
		case BOOLEAN:
			cellValue = cell.getBooleanCellValue();
			break;
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case NUMERIC:
			cellValue = cell.getNumericCellValue();
			break;
		case _NONE:
		case BLANK:
		case ERROR:
			break;
		default:
			break;
		}
		return cellValue;
	}
	
//	https://viblo.asia/p/huong-dan-doc-va-ghi-file-excel-trong-java-su-dung-thu-vien-apache-poi-RQqKLENpZ7z
	
	public static List<Diem> readExcel(String excelFilePath) throws IOException {
		List<Diem> diemList = new ArrayList<Diem>();
		
		//get file
		InputStream inputStream = new FileInputStream(new File(excelFilePath));
		
		//get workbook
		Workbook workbook = getWorkbook(inputStream, excelFilePath);
		
		//get sheet
		Sheet sheet = workbook.getSheetAt(0);
		
		//get all row
		Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                continue;
            }
			
			//get all cell
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            
            // Read cells and set value for book object
            Diem diem = new Diem();
            while (cellIterator.hasNext()) {
            	Cell cell = cellIterator.next();
				Object cellValue = getCellValue(cell);
				if(cellValue == null || cellValue.toString().isEmpty()) {
					continue;
				}
				
				// Set value for book object
				int columnIndex = cell.getColumnIndex();
				switch (columnIndex) {
				case COLUMN_INDEX_MASV:
					String msv =  getCellValue(cell).toString();
					diem.setSinhVien(new SinhVien(msv, null, null, 0, null,
							new Lop(0, null,
									new Khoa(null, null, null))));
					break;
				case COLUMN_INDEX_HOTEN:
					String hoten = getCellValue(cell).toString();
					break;
				case COLUMN_INDEX_HS1:
					Float diem1 = Float.parseFloat(getCellValue(cell).toString());
					diem.setDiem1(diem1);
					break;
				case COLUMN_INDEX_HS3:
					Float diem2 = Float.parseFloat(getCellValue(cell).toString());
					diem.setDiem2(diem2);
					break;
				case COLUMN_INDEX_DIEMTHI:
					Float diem3 = Float.parseFloat(getCellValue(cell).toString());
					diem.setDiem3(diem3);
					break;
				case COLUMN_INDEX_DIEMHP:
					Float tongDiem = Float.parseFloat(getCellValue(cell).toString());
					diem.setTongDiem(tongDiem);
					break;
				case COLUMN_INDEX_LOP:
					String tenLop = getCellValue(cell).toString();
					diem.setLop(new Lop(0, tenLop, new Khoa(null, null, null)));
					break;
				default:
					break;
				}
			}
			diemList.add(diem);
		}
		workbook.close();
		inputStream.close();
		
		return diemList;
	}
}
