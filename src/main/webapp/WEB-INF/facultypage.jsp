<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Faculty Permission Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 400px;
            margin: 50px auto;
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
    <div class="container">
        <h1 style="color: red;" align="center">Welcome Faculty: ${lst.get(0)}</h1>
        <h2 style="color: green;" align="center">Status: ${lst.get(1)}</h2>
        <h1 align="center">Permission Form</h1>
        <form method="POST" action="fnote">
            <table>
                <tr>
                    <td><label for="id">Id</label></td>
                    <td><input type="text" name="id" id="id" /></td>
                </tr>
                <tr>
                    <td><label for="note">Permission</label></td>
                    <td><input type="text" name="note" id="note" /></td>
                </tr>
                <tr>
                    <td><label for="state">State</label></td>
                    <td><input type="text" name="state" id="state" value="Pending"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Submit Note" /></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
