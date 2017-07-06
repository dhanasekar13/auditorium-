package com.ds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register  extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PersistenceManager pm = singldata.get().getPersistenceManager();
public static String email;
String emailfull;
	static Regpojo jd;
	Regdatastore rd;
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String p1 = req.getParameter("u1");
		String p2 = req.getParameter("p1");
		System.out.println("this is sign in block");
		try {
			rd = pm.getObjectById(Regdatastore.class, p1);
			System.out.println(rd);
			String uname = rd.getEmail();
			String passw = rd.getPassword();
			if(uname.equals("Admin@Admin")&&passw.equals("Admin"))
			{
				req.getRequestDispatcher("admin.html").forward(req, resp);
			}
			
			else if (uname.equals(p1) && passw.equals(p2)) {
				email=p1;	
				resp.sendRedirect("user.html");
			} else {
				System.out.println("the entereed data  is wrong");
				req.getRequestDispatcher("index.html").forward(req, resp);
			}
		} catch (Exception e) {
			System.out.println("it is in catch block of data");

		}
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		System.out.println("this is the registration block");
		PrintWriter out = resp.getWriter();
		String uname = req.getParameter("r1");
		 emailfull = req.getParameter("r2");
		String pwrd = req.getParameter("r3");
		jd = new Regpojo(uname, emailfull, pwrd);
		// the above one is java data object
		String a1 = jd.getName();
		String a2 = jd.getEmail();
		String a3 = jd.getPassword();
		rd = new Regdatastore(a1, a2, a3);
		
			System.out.println("before the persistent"+rd);
		try{
			pm.makePersistent(rd);
		}
		catch(Exception e)
		{
			}
		System.out.println("after the persistent");
		
			resp.sendRedirect("index.html");
		
	}
}
