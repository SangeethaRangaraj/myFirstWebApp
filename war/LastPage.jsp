<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>

    <html>

    <head>
        <title>Insert title here</title>
        <link rel="stylesheet" style="text/css" href="cssfile1.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
        </script>
        <script>
            $(document).ready(function() {
                $("#btn").click(function() {
                    $("#san").load("welcome.jsp");
                });
            });
        </script>
    </head>

    <body>
        <% HttpSession session1=request.getSession(false); String username=( String) session1.getAttribute( "username"); if (username.equals(null)) { response.sendRedirect( "index.jsp"); } %>

            <h1 align="center">Welcome to our Website</h1>
            <div id="span">
                <form method="get" action="LogOut">
                    <input type="submit" value="LogOut" />
                    <input type="button" id="btn" value="welcome" />
                </form>
                <div id="san"></div>

            </div>
    </body>

    </html>