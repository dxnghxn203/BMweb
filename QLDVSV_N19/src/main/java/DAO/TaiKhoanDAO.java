package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import Models.TaiKhoan;
import Util.JDBCUtils;

public class TaiKhoanDAO {
	public TaiKhoanDAO() {
		super();
	}
	private static String strSQL_Login = "select * from taikhoan where taikhoan = ? and matkhau = ? and loai = ? ;";
	private static String strSQL_TaiKhoan = "select * from taikhoan where taikhoan = ? ;";

	public static boolean onLogin(TaiKhoan TaiKhoan) throws Exception {
		boolean status = false;
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(strSQL_Login);
		    preparedStatement.setString(1, TaiKhoan.getTaiKhoan());
		    preparedStatement.setString(2, TaiKhoan.getMatKhau());
		    preparedStatement.setInt(3, TaiKhoan.getLoai());
		    
		    ResultSet rs = preparedStatement.executeQuery();
		    status = rs.next();
		}
		catch (SQLException e){
            JDBCUtils.printSQLException(e);
		}
		return status;
	}
	public static TaiKhoan getTaiKhoan(String username)throws Exception {
		TaiKhoan tk = null;
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(strSQL_TaiKhoan);
		    preparedStatement.setString(1, username);
		    ResultSet rs = preparedStatement.executeQuery();

		    while (rs.next()){
		    	String taikhoan = rs.getString("taikhoan");
		    	String matkhau =  rs.getString("matkhau");
		    	String email =  rs.getString("email");
		    	int loai = rs.getInt("loai");
		    	int trangthai = rs.getInt("trangthai");
				tk = new TaiKhoan(taikhoan, matkhau, email, loai, trangthai);
            }   
		}
		catch (SQLException e){
            JDBCUtils.printSQLException(e);
		}
		return tk;
	}
	
	public static void main(String[] args) throws Exception {
		TaiKhoan tk = getTaiKhoan("21110376");
		System.out.print(tk.getMatKhau());
	}
}
