package todo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.domain.Todo;

@WebServlet("/todo/modify")
public class TodoModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 수정 폼 : 이전에 입력했던 데이터가 화면에 출력
		// no 값을 받고
		String noStr = request.getParameter("no");
		int no = Integer.parseInt(noStr);

		// no 값에 해당하는 Todo 데이터를 Service를 통해서 받고
		Todo todo = new Todo(no, "청소", "2023-05-04", "not");

		// request 속성에 결과 데이터를 저장
		request.setAttribute("todo", todo);

		// view 지정
		RequestDispatcher dispathcer = request.getRequestDispatcher("/WEB-INF/views/todo/modify.jsp");

		// forward
		dispathcer.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TodoModifyController...doPost()...");

		// 수정 form 에서 전달 받고
		request.setCharacterEncoding("UTF-8");

		String noStr = request.getParameter("no");
		String todo = request.getParameter("todo");
		String duedate = request.getParameter("duedate");
		String complete = request.getParameter("complete");

		Todo newTodo = new Todo(Integer.parseInt(noStr), todo, duedate,
				complete != null ? complete.equals("on") ? "done" : "not" : "not");

		System.out.println(newTodo);

		// 결과 받고
		int result = 1;
		// redirect 처리
		response.sendRedirect("list");
	}

}
