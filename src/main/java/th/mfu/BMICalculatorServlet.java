package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO: get parameter from request: "weight" and "height"
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        double weight1 = Double.parseDouble(weight);
        double height1 = Double.parseDouble(height);

        // TODO: calculate bmi
        double BMI = weight1 / (height1 * height1);
        int bmi = (int) Math.round(BMI);
        // TODO: determine the built from BMI
        String build;
        if (bmi < 18.5) {
            build = "underweight";
        } else if (bmi < 25) {
            build = "normal";

        } else if (bmi < 30) {
            build = "overweight";

        } else if (bmi < 35) {
            build = "obese";

        } else {
            build = "extremely obese";
        }

        // TODO: add bmi and built to the request's attribute
        request.setAttribute("BMI", bmi);
        request.setAttribute("build", build);

        // TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request, response);

    }

}
