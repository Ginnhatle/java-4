package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import Utities.User;

@WebServlet({ "/users/index", "/users/create", "/users/store", "/users/edit", "/users/update", "/users/delete",
		"/users/show", })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDAO;

	public UserServlet() {
		super();
		this.userDAO = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		} else if (uri.contains("show")) {
			this.show(request, response);
		} else {
			// 404
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		} else {
			// 404
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<User> ds = this.userDAO.all();
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
	}

	private void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//
	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		//
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		//
	}
}
