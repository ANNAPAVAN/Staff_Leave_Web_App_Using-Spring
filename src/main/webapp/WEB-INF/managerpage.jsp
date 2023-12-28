<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.pavan.dto.FacultyNote" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Coordinator: Faculty Requests</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: red;
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        form {
            text-align: center;
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
        <h1>Requests From Faculty</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Permission</th>
                    <th>State</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<FacultyNote> list_fn = (List<FacultyNote>) request.getAttribute("list_fn");
                    for (FacultyNote facultyNote : list_fn) {
                %>
                    <tr>
                        <td><%= facultyNote.getFn_id() %></td>
                        <td><%= facultyNote.getFn_note() %></td>
                        <td><%= facultyNote.getFn_state() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        
        <form method="POST" action="bymanager">
            <h2>Action on Request</h2>
            <label for="id">Enter ID:</label>
            <input type="text" name="id"/><br>
            <label for="choice">forward/reject:</label>
            <input type="text" name="choice"/><br>
            <input type="submit" value="Submit"/>
        </form>
    </div>
</body>
</html>
