<%-- 
    Document   : login
    Created on : Jun 24, 2022, 12:13:04 AM
    Author     : hungp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="login-css.css">
        <script src="https://kit.fontawesome.com/05f194fd2c.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <form action="MainController" method="post">
            <header style="background-color: #f1f1f1;padding: 20px 10px;">
                <div class="container">
                    <div class="row"> 
                        <div class="col-md-12">
                            <h2><i aria-hidden="true"></i>GROUP 6 - DEMO ASSIGNMENT</h2><!-- Site name and icon-->
                        </div>
                    </div>
                </div>
            </header>
            <div class="login-box">
                <h1 style="text-align: center;">LOGIN</h1>
                <div class="textbox" >
                    <i class="fas fa-user"></i>
                    <input type="text" name="userId" placeholder="Enter your userId" autofocus>
                </div>
                <div class="textbox">
                    <i class="fas fa-lock"></i>
                    <input type="password" name="password" placeholder="Enter your password">
                </div>
                <p><input type="checkbox" name="txtremember">Remember Me</p>
                <div class="submit">
                    <p><input type="submit" value="Login" name="action"></p>
                </div>
            </div>
        </form>
         <h2 style="color: red">
            ${requestScope.ERROR_MESSAGE}
        </h2>
    </body>
</html>
