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
        
        String username = (String) sessionObject.getAttribute("username");
        
        String logout = request.getParameter("action");
        
        if (logout != null && logout.equals("logout")) {
            
            sessionObject.invalidate();
            
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            
            return;
        }
        
        if (username != null && !username.isEmpty()) {
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);

             return;
            
        } else {

            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            
            return;

    }
    }
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessionObject = request.getSession();
        
        String action = request.getParameter("action");
        
        if (action.equals("register")) {
             
             String username = request.getParameter("username");
            
            sessionObject.setAttribute("username", username);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            
            return;
            
        }
        
        ArrayList shoppingListArray = (ArrayList) sessionObject.getAttribute("shoppingListItems");
        
        if (shoppingListArray == null) {
        
        shoppingListArray = new ArrayList<>();
        
        }
        
        if (action.equals("add")) {
            
            String newItem = request.getParameter("item");
            
            shoppingListArray.add(newItem);
            
            sessionObject.setAttribute("shoppingListItems", shoppingListArray);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            
            return;
            
        }
        else if (action.equals("delete")) {
            
            String oldItem = request.getParameter("item");
            
            shoppingListArray.remove(oldItem);
            
            sessionObject.setAttribute("shoppingListItems", shoppingListArray);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            
            return;
            
        }
       
    }

}
