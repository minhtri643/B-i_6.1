package murach.email;

import java.io.*;
import java.util.Calendar;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import murach.business.User;

public class EmailListServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {

        String url = "/index.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // Calculate current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        request.setAttribute("currentYear", currentYear);

        // Perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        } else if (action.equals("add")) {
            // Get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // Store data in User object
            User user = new User(firstName, lastName, email);
            
            // Set User object and current year in request object
            request.setAttribute("user", user);
            request.setAttribute("currentYear", currentYear);

            url = "/thanks.jsp";   // the "thanks" page
        }

        // Forward request and response objects to the specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }    
    
    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                         throws ServletException, IOException {
        doPost(request, response);
    }
}
