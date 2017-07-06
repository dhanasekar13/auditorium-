package com.ds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;

public class Admin extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ObjectMapper map1 = new ObjectMapper();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.getRequestDispatcher("admin.html").forward(req, resp);;
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HashSet<String> hm=new HashSet<String>();
		hm.clear();
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		
		Entity show1 = new Entity("show");
		Key k=show1.getKey();	
		Query photoQuery = new Query("show");
		
		List<Entity> results =Create.datastore.prepare(photoQuery).asList(FetchOptions.Builder.withDefaults());
		for(Entity g1:results)
		{
		String f1= map1.writeValueAsString( g1);
		String f2= map1.writeValueAsString(	g1.getProperty("content"));
		String f3= map1.writeValueAsString(g1.getProperty("seat"));
		hm.add(f1);
		}
					System.out.println(hm);
					out.println(hm);
		
	}
}
