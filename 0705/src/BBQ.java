import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BBQ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String target = req.getParameter("target");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if (target != null) {
            writer.println("<p>hello " + target + "</p>");
        }
        if (name != null && age != null) {
            writer.println("<p>再见 "+name+",年龄 "+age+"</p>");
        }
    }
}
