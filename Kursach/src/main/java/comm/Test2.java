package comm;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class Test2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    /*
       generate the page showing all the request parameters
     */
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Лаб5";
        out.println("<HTTP><HEADER>Request Headers</HEADER>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
                "<B>Request Method: </B>" +
                request.getMethod() + "<BR>\n" +

                "<B>Request URI: </B>" +
                request.getRequestURI() + "<BR>\n" +

                "<B>SERVER_SOFTWARE: </B>" +
                request.getRequestURI() + "<BR>\n" +

                "<B>Request URI: </B>" +
                request.getRequestURI() + "<BR>\n" +

                "<B>Request Protocol: </B>" +
                request.getProtocol() + "<BR><BR>\n" +

                "<TABLE BORDER=1 ALIGN=CENTER>\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "<TH>Header Name<TH>Header Value");
        Enumeration headerNames = request.getHeaderNames();


        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            out.println("<TR><TD>" + headerName);
            out.println("    <TD>" + request.getHeader(headerName));
        }

        out.println("<TR><TD>" + request.getParameter("name"));
        out.println("    <TD>" + request.getParameter("surname"));
        out.println("<TR><TD>" + request.getParameter("sex"));
        out.println("    <TD>" + request.getParameter("info") );
        out.println("<TR><TD>" + request.getParameter("birthday"));
        out.println("    <TD>" + request.getAuthType());
        out.println("</TABLE>\n</BODY></HTML>");

    }
}

