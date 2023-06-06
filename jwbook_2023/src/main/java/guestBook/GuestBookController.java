package guestBook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/guestBookControl")
public class GuestBookController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private GuestBookDAO dao;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new GuestBookDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        String view = "";

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                view = list(request, response);
                break;
            case "insert":
                view = insert(request, response);
                break;
            case "revise":
            	view = revise(request, response);
            	break;
            case "update":
                view = update(request, response);
                break;
        }

        getServletContext().getRequestDispatcher("/GuestBook/" + view).forward(request, response);
    }

    private String list(HttpServletRequest request, HttpServletResponse response) {
        List<GuestbookModel> guestbooks = dao.getAll();
        request.setAttribute("guestbooks", guestbooks);
        return "guestList.jsp";
    }

    private String insert(HttpServletRequest request, HttpServletResponse response) {
        GuestbookModel guestbook = new GuestbookModel();
        try {
            BeanUtils.populate(guestbook, request.getParameterMap());
            dao.insert(guestbook);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list(request, response);
    }
    
    private String revise(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        GuestbookModel guestbook = dao.getGuestbookById(id);
        request.setAttribute("guestbook", guestbook);
		return "guestUpdate.jsp";
    }

    private String update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        GuestbookModel guestbook = dao.getGuestbookById(id);
        
        if (guestbook != null) {
            try {
                BeanUtils.populate(guestbook, request.getParameterMap());
                dao.update(guestbook);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return list(request, response);
    }
}