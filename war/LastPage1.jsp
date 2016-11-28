<%@page import="com.example.jdo.UserDataBase" %>
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
                        showWelcome();
                    });
                    $("#deletebtn").click(function() {
                        deleteUser();
                    });
                });

                function showWelcome() {
                    $("#san").load("welcome.jsp");
                }

                function deleteUser() {
                    var deluser = $("#username").val();

                    
                   
                    
                   
                    $.get( "DeleteUser",
                        {
                        	"user":deluser
                        },
                        
                        function(result) {
							if(result=="true")
                            alert("deleted the account");
							else if(result=="false")
								alert("please provide the username to delete");
                        });

                }
            </script>
        </head>

        <body>
            <% HttpSession session1=request.getSession(false); String username=( String) session1.getAttribute( "username"); if (username.equals(null)) { response.sendRedirect( "index.jsp"); } %>

                <h1 align="center">Welcome to our Website</h1>
                <div id="span">
                    <form method="get" action="LogOut">
                        <input type="submit" value="LogOut" />
                        <input type="button" id="btn" value="welcome" />
                        <input type="text" id="username" />
                        <input type="button" id="deletebtn" value="DELETE USERS" />
                    </form>
                    <div id="san"></div>

                </div>
        </body>

        </html>