package com.ds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;

public class show2 extends HttpServlet {
	static String flag;
	ObjectMapper map1 = new ObjectMapper();
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/plain");
	flag=req.getParameter("flag");
	
	req.getRequestDispatcher("show2.html").forward(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//this api will provide specific data of the show
		
		HashSet<String> hm=new HashSet<String>();
		hm.clear();
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		
		Entity show1 = new Entity("show");
		Key k=KeyFactory.createKey("show", flag);	
		Entity e1 = null;
		try {
			e1 = Create.datastore.get(k);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String f1=map1.writeValueAsString(e1);
		hm.add(f1);
		
					System.out.println(hm);
					out.println(hm);
	}
	
}
