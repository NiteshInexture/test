package comm.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.AddressPojo;
import com.pojo.UserPojo;
import com.service.ServiceImplement;
import com.service.ServiceInterface;

/**
 * Servlet implementation class insert
 */
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceInterface serviceInterface;
	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		serviceInterface = new ServiceImplement();
		UserPojo pojo =new UserPojo();
		AddressPojo addressPojo = new AddressPojo();
		
		pojo.setFirstName(req.getParameter("fname"));
		pojo.setLastName(req.getParameter("lname"));
		addressPojo.setFirstName(req.getParameter("fname"));
		addressPojo.setLastName(req.getParameter("lname"));
		addressPojo.setCity(req.getParameter("city"));
		addressPojo.setState(req.getParameter("state"));
			
		serviceInterface.saveData(pojo,addressPojo);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
		public void destroy() {
			serviceInterface = null;
		}
}

