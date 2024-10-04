package com.sap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sap.Bean.RegisterBean;
import com.sap.Implementation.SImplementaion;
import com.sap.Interface.SInterface;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String name = request.getParameter("name");
		String uname =request.getParameter("username");
		String pass = request.getParameter("password");
		String cpass = request.getParameter("cpassword");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		System.out.println(name+""+uname+""+pass+""+cpass+""+email+""+mobile);
		
		if(pass.equals(cpass)){
			System.out.println("YES");
			
			RegisterBean rb = new RegisterBean();
			rb.setName(name);
			rb.setUsername(uname);
			rb.setPassword(pass);
			rb.setEmail(email);
			rb.setMobile(mobile);
			
			SInterface si = new SImplementaion();
			int t = si.register(rb);
			System.out.println("The value of t: "+t);
			
			if(t!=0){
				response.sendRedirect("success.jsp");
			}else{
				response.sendRedirect("error.jsp");
			}
		}
		
		
	}

}
