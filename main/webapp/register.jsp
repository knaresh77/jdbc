<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<%@include file="bootstrap.jsp" %>
</head>
<style>

</style>
<body>
 
   <section>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-content">
                            <form action="register" method="post">
                                <input type="text" placeholder="enter username" class="form-control" name="username">
                                <input type="email" placeholder="enter emalil" class="form-control" name="email">
                                <input type="password" placeholder="enter password" class="form-control" name="password">
                                <input type="password" placeholder="confirm password" class="form-control" name="confirmpassword">
                                <button>Register</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
 
</body>
</html>