package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private static final String MIME_TYPE_TEXT_HTML = "text/html";
    private static final String LOGIN_PARAMETER_NAME = "login";
    private static final String PASSWORD_PARAMETER_NAME = "password";
    private static final String UTF_8 = "UTF-8";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(LOGIN_PARAMETER_NAME);
        String password = request.getParameter(PASSWORD_PARAMETER_NAME);

        response.setCharacterEncoding(UTF_8);
        response.setContentType(MIME_TYPE_TEXT_HTML);

        if (ADMIN_LOGIN.equals(login) && ADMIN_PASSWORD.equals(password)) {
            response.getWriter().println("Zalogowano pomyślnie");
        } else {
            PrintWriter writer = response.getWriter();
            writer.println("Niepoprawne dane");
        }
    }
}
