package controllers.reports;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Nice;
import utils.DBUtil;

/**
 * Servlet implementation class ReportsNiceServlet
 */
@WebServlet("/reports/nice")
public class ReportsNiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsNiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        EntityManager em = DBUtil.createEntityManager();
        Employee login_employee =(Employee)request.getSession().getAttribute("login_employee");
        Integer report_id = Integer.parseInt(request.getParameter("report_id"));


        Nice nice = new Nice();
        em.getTransaction().begin();
        nice.setreport_id(report_id);
        nice.setemployee_id(login_employee.getId());
        em.persist(nice);
        em.getTransaction().commit();
        em.close();
        request.getSession().setAttribute("flush", "いいねしました。");

        response.sendRedirect(request.getContextPath() + "/reports/show?id=" + report_id);


        }
    }


