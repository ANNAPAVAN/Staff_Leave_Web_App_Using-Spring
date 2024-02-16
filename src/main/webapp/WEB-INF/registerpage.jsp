<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 400px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #2c3e50;
        }
        form {
            text-align: center;
        }
        table {
            margin: 0 auto;
        }
        td {
            padding: 8px;
            text-align: right;
        }
        input[type="text"],
        input[type="password"],
        input[type="submit"] {
            padding: 8px;
            border-radius: 4px;
            border: 1px solid #ccc;
            margin-bottom: 10px;
            width: 200px;
        }
        input[type="submit"] {
            background-color: #3498db;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/navbar.jsp"/>
    <div class="container">
        <div class="c1">
	    	<h1 style="color: red; text-align: center;">REGISTRATION PAGE</h1>
	    </div>
        <form method="POST" action="register">
            <table>
                <tr>
                    <td><label for="id">Id</label></td>
                    <td><input type="text" name="id" id="id" /></td>
                </tr>
                <tr>
                    <td><label for="name">Name</label></td>
                    <td><input type="text" name="name" id="name" /></td>
                </tr>
                <tr>
                    <td><label for="pwd">Password</label></td>
                    <td><input type="password" name="pwd" id="pwd" /></td>
                </tr>
                <tr>
                    <td><label for="email">Email</label></td>
                    <td><input type="text" name="email" id="email" /></td>
                </tr>
                <tr>
                    <td><label for="role">Role</label></td>
                    <td><input type="text" name="role" id="role" placeholder="teacher"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
