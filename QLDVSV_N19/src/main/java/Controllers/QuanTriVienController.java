package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QuanTriVienDAO;
import Models.QuanTriVien;

@WebServlet("/")
public class QuanTriVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public QuanTriVienController() {
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
        try {
            switch (action) {
                case "/QuanTriVien":
                	getQuanTriVien(request,response);
                    break;
                default:
                	break;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void getQuanTriVien(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msqt = request.getParameter("id");
		QuanTriVien qtv = QuanTriVienDAO.getQuanTriVien(msqt);
		RequestDispatcher dispatcher = request.getRequestDispatcher("frmAdminInfor.jsp");
		request.setAttribute("quantrivien", qtv);
        dispatcher.forward(request, response);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
