<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Staff Leave Seeking Application</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #2c3e50;
            color: #fff;
            text-align: center;
            padding: 20px 0;
        }
        .container {
            margin: 50px auto;
            text-align: center;
        }
        h1 {
            font-size: 28px;
            margin-bottom: 20px;
        }
        a {
            text-decoration: none;
            color: #3498db;
            transition: color 0.3s ease;
        }
        a:hover {
            color: #2980b9;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to Staff Leave Seeking Application</h1>
    </header>
    <div class="container">
        <h2>Choose an Option:</h2>
        <div>
            <a href="loginpage"><button style="padding: 10px 20px; font-size: 18px;">Login Page</button></a>
        </div>
        <div style="margin-top: 20px;">
            <a href="registerpage"><button style="padding: 10px 20px; font-size: 18px;">Register Page</button></a>
        </div>
    </div>
</body>
</html>
