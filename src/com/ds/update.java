package com.ds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class update  extends HttpServlet {
	 
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	String arr=req.getParameter("store");
	ArrayList<String> arr1 = null;
	String[] p= arr.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

	int[] g=new int[p.length];
	
			String title1=show2.flag;
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			for (int i = 0; i < p.length; i++) {
			    try {
			        g[i] = Integer.parseInt(p[i]);
			    }
			    catch(Exception e)
			    {
			    	
			    }
			}
			
		/*	String[] items = arr.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

			int[] results = new int[items.length];

			for (int i = 0; i < items.length; i++) {
			    try {
			        results[i] = Integer.parseInt(items[i]);
			    }
			*/
			

Key k = KeyFactory.createKey("show", title1);
try {
	Entity tr=Create.datastore.get(k);
	String a1 = (String) tr.getProperty("title");
	String a2 =(String) tr.getProperty("content");
	 @SuppressWarnings("unchecked")
	ArrayList<String> a3= (ArrayList<String>) tr.getProperty("seat");
	arr1=a3;
	for(int i=0;i<p.length;i++) {
		arr1.set( g[i],Register.email);
		}
	tr.setProperty("title", a1);
	tr.setProperty("content", a2);
	tr.setProperty("seat", a3);
	Create.datastore.put(tr);
	
	out.println("");
} catch (EntityNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

	
	}
}
