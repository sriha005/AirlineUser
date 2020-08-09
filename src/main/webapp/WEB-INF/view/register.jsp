<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=password], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  margin: 0px 750px 0px 0px;
}

.error{
			display: inline-block;
			border: 1px solid;
			margin: 0px 0px 15px;
			padding: 15px 10px 15px 50px;
			background-repeat: no-repeat;
			background-position: 10px center;
			color: #D8000C;
			background-color: #FFBABA;
			background-image: url('https://i.imgur.com/GnyDvKN.png');
		}
		
	.button {
  background-color: #4CAF50; /* Green */
  
  border: none;
  color: white;
  padding: 14px 40px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px 0px 350px;
  cursor: pointer;
	}
	.button4 {border-radius: 12px;}
</style>
	<link rel="stylesheet" type="text/css" href="/css/nav.css">
</head>
<body>
 
		
		<ul class = "navbar">
		  <li class = "navbarelement" id = "logoli"><img src="/images/delta.png" id = "logo"></li>
		  <li class = "navbarelement"><a href="login">Login</a></li>
		  <li class = "navbarelement"><a href="register">Register</a></li>
		  
		  <li class = "navbarelement" style="float:right"><a class="active" href="#about">About</a></li>
		</ul>

<h2>Registration Form</h2>
<c:if test = "${response!=null}">
<a class = "error">${response}</a>
</c:if>

 <form:form action="../user/" method="post" modelAttribute = "user_register">  
    <div class="form-group">
      <label for="name">First Name</label>
      <input type="text"  
        class="form-control"
        id="firstname"
        name="firstname" required
        placeholder="Enter your first name"
        >
    </div>
         <div class="form-group">
      <label for="lastname">Last Name</label>
      <input type="text" 
        class="form-control"
        id="lastname"
        name="lastname" required
        placeholder="Enter your last name"
        >
    
    </div>
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text"
          class="form-control"
          id="username"
          name="username" required
          placeholder="Enter your user name"
          >
        
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" 
          class="form-control"
          id="password"
          name="password" required
          placeholder="Enter your password"
          >
        
      </div>
	<button class="button button4" type="submit">Submit</button>
  </form:form>
</body>
</html>