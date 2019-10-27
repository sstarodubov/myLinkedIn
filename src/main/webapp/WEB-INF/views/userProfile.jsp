<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
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
    <title>Login</title>
</head>


<body>
<div class="bg-primary text-right pr-5 text-white">
    <a class="text-white" style="font-size: 20px;" href="/editProfile">edit page</a> /
    <a class="text-white" style="font-size: 20px;" href="/logout">log out</a>
</div>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-6">
            <div class="card mt-5" style="width: 18rem;">
                <img src="${photo}" class="card-img-top" alt="...">
                <div class="card-body">
                    <p class="card-text">
                        ${softSkills}
                    </p>
                </div>
            </div>
            <h2 class="pt-3">${name} ${lastname}</h2>
            <h3 class="pt-3">${position}</h3>
            <h5 class="py-3">${hardSkills}</h5>
        </div>
    </div>

</div>
</body>
</html>
