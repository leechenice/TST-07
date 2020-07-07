import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TranslateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String english = req.getParameter("english");
        String chinese = translate(english);

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<h1>Kill Bill</h1>");
        writer.println("<p>"+english+": "+chinese+"</p>");
    }

    private String translate(String english) throws ServletException{
        try(Connection connection = DBUtil.getConnection()) {
            String sql = "select chinese from dictionary where english = ?";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1,english);

                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) return resultSet.getString("chinese");
                    else return  "不认识的单词";
                }
            }
        } catch (SQLException e) {
            throw  new ServletException(e);
        }
    }
}
