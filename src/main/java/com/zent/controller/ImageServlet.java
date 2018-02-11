package com.zent.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zent.util.DBConnection;



/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/image-display")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("config.properties");
	Properties properties = new Properties();
	
	String UPLOAD_FOLDER_PATH;
	private BufferedInputStream bis;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        try {
			properties.load(inputStream);
			UPLOAD_FOLDER_PATH = properties.getProperty("path");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
	         String fileName = request.getParameter("image");             
	         FileInputStream fis = new FileInputStream(new File(UPLOAD_FOLDER_PATH+File.separator+fileName));
	         bis = new BufferedInputStream(fis);             
	         response.setContentType("image/*");
	         BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
	         for (int data; (data = bis.read()) > -1;) {
	           output.write(data);
	         }             
	      }
	      catch(IOException e){

	      }finally{
	          // close the streams
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
