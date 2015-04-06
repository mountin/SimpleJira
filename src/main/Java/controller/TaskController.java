package controller;

import listener.InitListener;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by mountin on 31/1/2015.
 */
public class TaskController extends HttpServlet {
    public HttpSession session;
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        this.session = req.getSession(true);
        if(this.session.getAttribute("UserLogged") == null){
            RequestDispatcher rd = req.getRequestDispatcher("/login.html");
            rd.forward(req, resp);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/tasks.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
