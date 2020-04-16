package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    //  Tomcat application context configuration: Edit Configurations... -> Deployment -> Application Context
    //  Tomcat application context: "/"
    //  http://localhost:8080/hello

    //  Tomcat application context: "/users"
    //  http://localhost:8080/users/hello

    //  Parametry żądania:
    //  http://localhost:8080/hello?parametr1=wartosc1&paramter2=wartosc2
    //  http://localhost:8080/hello?imie=Jan&nazwisko=Kowalski

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("imie");
        String lastName = request.getParameter("nazwisko");
        System.out.println(String.format("Imię: %s Nazwisko: %s", firstName, lastName));
    }
}
