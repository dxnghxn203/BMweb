package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import Models.QuanTriVien;
import Models.TaiKhoan;
import Util.JDBCUtils;

public class QuanTriVienDAO {

	public QuanTriVienDAO() {
		super();
	}
	private static String strSQL_getQTV = "select * from quantrivien where msqt = ?;";
	
	public static QuanTriVien getQuanTriVien(String msqt)throws Exception {
		QuanTriVien qtv = null;
		System.out.print(msqt);
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(strSQL_getQTV);
		    preparedStatement.setString(1, msqt);
		    ResultSet rs = preparedStatement.executeQuery();
		    while (rs.next()){
		    	String ho =  rs.getString("ho");
		    	String tendem = rs.getString("tendem");
		    	String ten = rs.getString("ten");
		    	int gioitinh = rs.getInt("gioitinh");
	            java.sql.Date namsinh = (java.sql.Date)rs.getDate("namsinh");
	            String cccd = rs.getString("cccd");
	            String sdt = rs.getString("sdt");
				qtv = new QuanTriVien(msqt, ho, tendem, ten, gioitinh, namsinh,cccd, sdt );
            }
		}
		catch (SQLException e){
            JDBCUtils.printSQLException(e);
		}
		return qtv;
	}
}
