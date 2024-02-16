<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Staff Leave Seeking Application</title>
    <style>
        /* Style for the login and register section */
        .login-register {
            position: fixed;
            top: 150px; /* Adjust the top position to place it below the header */
            right: 10px;
            display: flex;
            align-items: center;
            gap: 10px;
            z-index: 1000; /* Ensure it's above other elements */
        }

   
        header {
            background-color: #2c3e50;
            color: #fff;
            text-align: center;
            padding: 20px 0;
            position: fixed;
            width: 100%;
            top: 0;
            z-index: 999; /* Ensure it's above other elements */
        }
        .content {
            margin-top: 200px; /* Adjust margin to give space below header */
            text-align: center;
        }
        h1 {
            font-size: 28px;
            margin-bottom: 20px;
            color:white
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to Staff Leave Seeking Application</h1>
    </header>
    <div class="content">
    </div>
    <div class="login-register">
         <div>
            <a href="loginpage"><button style="padding: 10px 20px; font-size: 18px;">Login Page</button></a>
        </div>
        <div>
            <a href="registerpage"><button style="padding: 10px 20px; font-size: 18px;">Register Page</button></a>
        </div>
         <div>
            <a href="homepage"><button style="padding: 10px 20px; font-size: 18px;">LogOut</button></a>
        </div>
        
    </div>
</body>
</html>
