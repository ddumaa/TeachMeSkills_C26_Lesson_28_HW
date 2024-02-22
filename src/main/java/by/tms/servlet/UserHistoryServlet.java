package by.tms.servlet;

import by.tms.model.Operation;
import by.tms.model.User;
import by.tms.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(value = "/history", name = "UserHistoryServlet")
public class UserHistoryServlet extends HttpServlet {

    private final OperationService service = new OperationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Operation> history = service.findHistory(user);
        req.setAttribute("history", history);
        getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }
}
