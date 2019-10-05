<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous"
    />
    <script
            src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"
    ></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"
    ></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"
    ></script>
    <title>Registration</title>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-6">
            <% String error = (String) request.getAttribute("error");
                if (error != null) {%>
                    <h1>${error}</h1>
                <%} else {%> <h1>Welcome</h1><%}%>
            <form method="post" action="/login">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email</label>
                    <input
                            type="email"
                            class="form-control"
                            id="exampleInputEmail1"
                            aria-describedby="emailHelp"
                            placeholder="Enter email"
                            name="email"
                    />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input
                            type="password"
                            class="form-control"
                            id="exampleInputPassword1"
                            placeholder="Password"
                            name="password"
                    />
                </div>
                <button type="submit" class="btn btn-primary btn-lg btn-block">
                    Sign in
                </button>
            </form>
        </div>
    </div>
    <div class="row justify-content-center pt-4">
        <a href="/getpassword" class="text-primary" style="text-decoration: underline">Forgot password?</a>
    </div>
    <div class="row justify-content-center pt-2">
        <p>if you are not registered <a href="/register" class="text-primary" style="text-decoration: underline">Sign
            up!</a></p>
    </div>
</div>
</body>
</html>
