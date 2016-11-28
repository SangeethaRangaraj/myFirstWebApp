<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        <link rel="stylesheet" style="text/css" href="cssfile.css">
        <link rel="stylesheet" style="text/css" href="cssfile3.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
        </script>
        <script src="source.js">
        </script>

    </head>

    <body>
       <%
        HttpSession session1=request.getSession(false);
        String username=( String) session1.getAttribute( "username"); 
        try { 
        	if (username.equals( "san"))
        	{ 
        		response.sendRedirect( "LastPage1.jsp"); 
        	}
        	else if (!username.equals(null))
       		{
       	 	response.sendRedirect( "LastPage.jsp");
            }
           } 
        catch (Exception e) { }
        %>
        	<div id="indexcss">
            <button type="button" id="signinbtn">SIGNIN</button>
            <button type="button" id="signupbtn">SIGNUP</button>
            </div>

            <div id="signIn">
                <h1>Sign In</h1>
                <div id="div">


                    USERNAME &nbsp; &nbsp;
                    <input type="text" id="username" placeholder="enter your username">
                    <br />
                    <br /> PASSWORD &nbsp; &nbsp;
                    <input type="password" id="pwd" placeholder="enter your password">
                    <br />
                    <br />
                    <button name="submit" id="btn">Submit</button>


                </div>
            </div>
            <div id="signUp">
                <header>Sign Up Form</header>
                <div id="div">


                    UserName &nbsp; &nbsp;
                    <input type="text" id="uname" placeholder="enter your username" required>
                    <br />
                    <br /> FirstName &nbsp; &nbsp;
                    <input type="text" id="firstname" placeholder="enter your firstname" required>
                    <br />
                    <br /> LastName &nbsp; &nbsp;
                    <input type="text" id="lastname" placeholder="enter your lastname">
                    <br />
                    <br /> Password &nbsp; &nbsp;
                    <input type="password" id="password" placeholder="enter your password" required>
                    <br />
                    <br /> Phone &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
                    <input type="number" id="ph_no" minlength="10" maxlength="10" placeholder="enter your PhoneNumber" required>
                    <br />
                    <br /> Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
                    <input type="email" id="email" placeholder="enter your mail-id" required>
                    <br />
                    <br />
                    <button name="submit" id="signUpSubmit">Submit</button>


                </div>
            </div>

    </body>

    </html>