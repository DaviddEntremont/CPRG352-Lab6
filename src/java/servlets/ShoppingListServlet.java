package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        if (username != null && !username.isEmpty()) {
            // give the user info on one user
             getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            
        } else {
            // return all users
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);

    }
    }
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}
