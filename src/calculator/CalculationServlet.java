package calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculator")
public class CalculationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberOneAsString = request.getParameter("number1");
        String numberTwoAsString = request.getParameter("number2");
        String operationFromRequest = request.getParameter("operation");

        int numberOne;
        int numberTwo;

        try {
            numberOne =  Integer.valueOf(numberOneAsString);
            numberTwo =  Integer.valueOf(numberTwoAsString);
        } catch (NumberFormatException exception) {
            System.err.println("To nie liczba");
            return;
        }

        boolean error = false;
        double result = 0;
        String operation = "";

        switch (operationFromRequest) {
            case "dodaj":
                result = numberOne + numberTwo;
                operation = "+";
                break;
            case "odejmij":
                result = numberOne - numberTwo;
                operation = "-";
                break;
            case "pomnoz":
                result = numberOne * numberTwo;
                operation = "*";
                break;
            case "podziel":
                result = numberOne / numberTwo;
                operation = "/";
                break;
            default:
                error = true;
        }

        if (error) {
            System.err.println("Błędna operacja");
        } else {
            System.out.println(String.format("%d %s %d = %f", numberOne, operation, numberTwo, result));
        }
    }
}
