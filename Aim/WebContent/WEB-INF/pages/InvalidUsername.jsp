<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
    <style>
    	body{
		    margin: 0;
		    padding: 0;
		    background: url(http://localhost:1000/Aim/resources/img/pic1.jpg);
		    background-size: cover;
		    font-family: sans-serif;
		}
		
		.loginbox{
		    width: 320px;
		    height: 420px;
		    background: #000;
		    color: #fff;
		    top: 50%;
		    left: 50%;
		    position: absolute;
		    transform: translate(-50%,-50%);
		    box-sizing: border-box;
		    padding: 70px 30px;
		}
		
		.avatar{
		    width: 100px;
		    height: 100px;
		    border-radius: 50%;
		    position: absolute;
		    top: -50px;
		    left: calc(50% - 50px);
		}
		
		h1{
		    margin: 0;
		    padding: 0 0 20px;
		    text-align: center;
		    font-size: 22px;
		}
		
		.loginbox p{
		    margin: 0;
		    padding: 0;
		    font-weight: bold;
		}
		
		.loginbox input{
		    width: 100%;
		    margin-bottom: 20px;
		}
		
		.loginbox input[type="text"], input[type="password"]
		{
		    border: none;
		    border-bottom: 1px solid #fff;
		    background: transparent;
		    outline: none;
		    height: 40px;
		    color: #fff;
		    font-size: 16px;
		}
		.loginbox input[type="submit"]
		{
		    border: none;
		    outline: none;
		    height: 40px;
		    background: #fb2525;
		    color: #fff;
		    font-size: 18px;
		    border-radius: 20px;
		}
		.loginbox input[type="submit"]:hover
		{
		    cursor: pointer;
		    background: #ffc107;
		    color: #000;
		}
		.loginbox a{
		    text-decoration: none;
		    font-size: 12px;
		    line-height: 20px;
		    color: darkgrey;
		}
		
		.loginbox a:hover
		{
		    color: #ffc107;
		}
    </style>
<body>
	<h1>Please enter a valid Username!!</h1>
    <div class="loginbox">
    <img src="http://localhost:1000/Aim/resources/img/avatar.png" class="avatar">
        <h1>Login Here</h1>
        <form>
            <p>Username</p>
            <input type="text" name="username" placeholder="Enter Username">
            <p>Password</p>
            <input type="password" name="password" placeholder="Enter Password">
            <input type="submit" name="" value="Login">
            <a href="#">Lost your password?</a><br>
            <a href="/Aim/register">Don't have an account?</a>
        </form>
        
    </div>

</body>
</head>
</html>