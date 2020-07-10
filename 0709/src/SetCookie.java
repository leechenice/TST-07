import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/set-cookie")
public class SetCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setHeader("Set-Cookie","today=20200709");
        Cookie cookie = new Cookie("today","20200709");
        resp.addCookie(cookie);
        resp.setContentType("text/plain; charset=utf-8");
        resp.getWriter().println("ok");
    }
}
