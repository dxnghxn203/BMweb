package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TaiKhoanDAO;
import Models.TaiKhoan;

@WebServlet("/login")
public class TaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaiKhoanDAO  taikhoanDAO;
    
    public TaiKhoanController() {
        super();
    }
    
	public void init(ServletConfig config) throws ServletException {
		taikhoanDAO = new TaiKhoanDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
        try {
            switch (action) {
                case "/login":
                	postLogin(request,response);
                	break;
                default:
                	break;
            }
		}catch (Exception e) {
			e.printStackTrace();
		}		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void postLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String taikhoan = request.getParameter("taikhoan");
        String matkhau = request.getParameter("matkhau");
        int loai = Integer.parseInt(request.getParameter("loai"));
        
        TaiKhoan tk = new TaiKhoan();
        tk.setTaiKhoan(taikhoan);
        tk.setMatKhau(matkhau);
        tk.setLoai(loai);
        HttpSession session = request.getSession();

        RequestDispatcher dispatcher = null;

        try {
        	boolean status = TaiKhoanDAO.onLogin(tk);
            if (status){
                session.setAttribute("taikhoan", taikhoan);
            	if(loai == 0) 
            	{
            		response.sendRedirect("Admin.jsp");
            	}
            	              
            } else {
                session.setAttribute("status", "failed");
                response.sendRedirect("login.jsp");
            }
            dispatcher.forward(request, response);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	protected void postGetTaiKhoan(HttpServletRequest request, HttpServletResponse response) {
		String taikhoan = request.getParameter("taikhoan");
		
	}
}
