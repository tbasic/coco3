package customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.member.LoginController;
import customer.controller.notice.NoticeController;

public class MyDispatcher extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("http신호호호호호호");
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		System.out.println(com);
		
//		NoticeDetailController controller1=new NoticeDetailController();
//		NoticeEditController controller2=new NoticeEditController();
		Controller controller=null;
		
		try {
			
			if(com.equals("/customer/notice.do")) {
				controller=new NoticeController();
			}else if(com.equals("/login/login.do")) {
				controller=new LoginController();
			}
			controller.execute(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//그냥 주석마스터에서1
		
		
		
	}

}
