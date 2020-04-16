package welcome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/welcome")
public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "";

        String firstName = Optional.ofNullable(request.getParameter("firstName"))
                .map(name -> "Cześć " + name + ". ")
                .orElse("Jak masz na imię? ");
        result += firstName;

        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");

//        if (firstName != null) {
//            result += "Cześć " + firstName + ". ";
//        } else {
//            result += "Jak masz na imię? ";
//        }

        if (lastName != null) {
            result += "Wiem, że masz na nazwisko " + lastName + ". ";
        } else {
            result += "Niestety nie wiem jak masz na nazwisko";
        }

        if (age != null) {
            result += "Też kiedyś miałem " + age + " lat";
        } else {
            result += "Ja też nie lubię się chwalić wiekiem";
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.getWriter().println(result);
    }
}
