package todo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.domain.Todo;
import todo.domain.TodoDTO;
import todo.service.TodoUpdateService;
import todo.service.TodoViewService;

@WebServlet("/todo/modify")
public class TodoModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TodoViewService viewService;
	private TodoUpdateService updateService;

	public TodoModifyController() {
		this.viewService = TodoViewService.getInstance();
		this.updateService = TodoUpdateService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TodoModifyController...doGet()...");

		// 회원의 로그인 여부를 확인 후 비로그인상태 -> 로그인 페이지로 이동
		HttpSession session = request.getSession();

		// session 이 새로만들어진 세션이 아니고 세션에 로그인 정보를 가지고 있다면 => 로그인 상태
		// 리다이랙션 => 로그인 페이지로 조건은 새로 만들어진 세션이거나 세션에 로그인 정보가 없다면
		if (session.isNew() || session.getAttribute("loginInfo") == null) {
			System.out.println("로그인 상태가 아님");

			response.sendRedirect("/app/login");
			return;
		}

		// 수정 폼 : 이전에 입력했던 데이터가 화면에 출력
		// no 값을 받고
		String noStr = request.getParameter("no");
		int no = Integer.parseInt(noStr);

		// no 값에 해당하는 Todo 데이터를 Service를 통해서 받고
		TodoDTO todo = viewService.getTodo(no);

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
//		request.setCharacterEncoding("UTF-8");

		String noStr = request.getParameter("no");
		String todo = request.getParameter("todo");
		String duedate = request.getParameter("duedate");
		String complete = request.getParameter("complete");

//		Todo newTodo = new Todo(Integer.parseInt(noStr), todo, duedate,
//				complete != null ? complete.equals("on") ? "done" : "not" : "not");

//		System.out.println(newTodo);

		TodoDTO todoDTO = new TodoDTO(Integer.parseInt(noStr), todo, duedate,
				complete != null ? complete.equals("on") ? true : false : false);

		// 결과 받고 service 전달
		int result = updateService.modify(todoDTO);

		if (result > 0) {
			System.out.println("update shoot");
		} else {
			System.out.println("update failed");
		}

		// redirect 처리
		response.sendRedirect("list");
	}

}
