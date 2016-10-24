package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by chitboon on 10/23/15.
 */
@WebServlet(name = "BookDetailsServlet", urlPatterns = "/bookdetails")
/**
 * Created by ZhenYu on 24/10/2016.
 */
public class BookDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>" + "<head><title>Duke's Bookstore</title></head>" +
                "<body  bgcolor=\"#ffffff\">" + "<center>" +
                "<hr> <br> &nbsp;" + "<h1>" +
                "<font size=\"+3\" color=\"#CC0066\">Duke's </font> <img src=\"" +
                "./duke.books.gif\" alt=\"Duke holding books\"\">" +
                "<font size=\"+3\" color=\"black\">Bookstore</font>" + "</h1>" +
                "</center>" + "<br> &nbsp; <hr> <br> ");

        String bookId = request.getParameter("bookId");
        if (bookId != null) {
            BookDBAO db = new BookDBAO();
            BookDetails bd = db.getBookDetails(bookId);

            //Print out the information obtained
            out.println("<h2>" + bd.getTitle() + "</h2>" + "&nbsp;" +
                    " by<em>" + bd.getFirstName() +
                    " " + bd.getSurname() + "</em> &nbsp; &nbsp; " + "(" +
                    bd.getYear() + ")<br> &nbsp; <br>" + "<h4>" +
                    "Here's what the critcs say: </h4><blockquote>" +
                    bd.getDescription() + "</blockquote>" + "<h4>" +
                    "Our Price: " + bd.getPrice() + "</h4>" +
                    "<p><strong><a href=\"" +
                    response.encodeURL(request.getContextPath() +
                            "/bookcatalog?bookId=" + bookId) + "\">" +
                    "Add to Cart</a>&nbsp;&nbsp;&nbsp;" +
                    "<a href=\"" +
                    response.encodeURL(request.getContextPath() +
                            "/bookcatalog") + "\">" +
                    "Continue Shopping</a></p></strong>");
        }
        out.println("</body></html>");
    }
}
