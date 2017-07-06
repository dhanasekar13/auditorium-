package com.ds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class Create extends HttpServlet {

	static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	static ArrayList<String> a3=new ArrayList<>(300);
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String a1 = req.getParameter("f1");
		String a2 = req.getParameter("f2");
		for(int i=0;i<300;i++)
		{
			a3.add("");
		}
		a3.add(45,"mail2dhanasekar");
		
		Entity show1 = new Entity("show", a1);
		show1.setProperty("title", a1);
		show1.setProperty("content", a2);
		show1.setProperty("seat", a3);
		try {
			datastore.put(show1);
		} catch (Exception e) {

		}
		Key k1 = show1.getKey();
		try {
			System.out.println(datastore.get(k1));
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect("admin.html");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Entity show1 = new Entity("show");
		String d=req.getParameter("key");
		
		Key k11=KeyFactory.createKey("show",d );
		
	datastore.delete(k11);
	req.getRequestDispatcher("admin.html").forward(req, resp);
	}
	

}
