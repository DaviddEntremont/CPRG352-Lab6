package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessionObject = request.getSession();
        
        String username = request.getParameter("username");
        
        String logout = request.getParameter("action");
        
        if (logout != null && logout.equals("logout")) {
            
            sessionObject.invalidate();
            
            sessionObject = request.getSession();
            
            sessionObject.setAttribute("loggedout", true);
            
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            
            return;
        }
        
        if (username != null && !username.isEmpty()) {
            
            // give the user info on one user
             getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
             
             return;
            
        } else {
            // return all users
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            
            return;

    }
    }
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessionObject = request.getSession();
        
        ArrayList shoppingListArray = new ArrayList<>();
        
        String action = request.getParameter("action");
        
        String newItem = request.getParameter("item");
        
        if (action == null || action.equals("")) {
            
        }
        
        else if (action.equals("add")) {
            
            shoppingListArray.add(newItem);
            
            sessionObject.setAttribute("shoppingListItems", shoppingListArray);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            
            return;
            
        }
        else if (action.equals("delete")) {
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            
            return;
            
        }
       
    }

}
