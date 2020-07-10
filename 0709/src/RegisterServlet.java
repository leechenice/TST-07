import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        // 1. 读取用户的输入（username + password）
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 2. 验证用户输入的正确性，并得到 User 对象
        User.insert(username, password);
        writer.println("<p>注册成功</p>");
        new LoginServlet().doPost(req,resp);
    }
}
