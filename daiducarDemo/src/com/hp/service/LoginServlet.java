package com.hp.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.methods.CloseableHttpResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���ǰ�˲���
		String despath = request.getParameter("message");  //��ǰ�˽��ܵ���ͼƬbase64����
		/*faceMatch match = new faceMatch();  //����ͼƬ�����ȶ�
		String score = match.match(despath);
		System.out.println("score:"+score);*/
		System.out.println(despath+"-----&&&&-----");
		FaceSearch search = new FaceSearch();
		String result = search.search(despath);
		response.setContentType("text/html; charset=utf-8");
		System.out.println("result:"+result);
		response.getWriter().println(result);
	
	}

}
