
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
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
    <title>MyLinkedIn</title>
</head>
<body>
<div class="bg-primary text-right pr-5 text-white">
    <a class="text-white" style="font-size: 20px;" href="#">Sign in</a> /
    <a class="text-white" style="font-size: 20px;" href="#">Sign up</a>
</div>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center">
                        <h3><i class="fa fa-lock fa-4x"></i></h3>
                        <h2 class="text-center">Confirm your email</h2>
                        <div class="panel-body">
                            <form
                                    id="register-form"
                                    role="form"
                                    autocomplete="off"
                                    class="form"
                                    method="post">
                                <div class="form-group">
                                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                        <input
                                                id="email"
                                                name="email"
                                                placeholder="email address"
                                                class="form-control"
                                                type="email"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input
                                            name="recover-submit"
                                            class="btn btn-lg btn-primary btn-block"
                                            value="confirm"
                                            type="submit"/>
                                </div>

                                <input
                                        type="hidden"
                                        class="hide"
                                        name="token"
                                        id="token"
                                        value=""/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="text-center">
    <p>If you don't get message, please try to <a href="">send again</a></p>
</div>
</body>
</html>
