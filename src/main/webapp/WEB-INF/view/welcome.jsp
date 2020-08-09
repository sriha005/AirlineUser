<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<style>
	</style>
	<link rel="stylesheet" type="text/css" href="/css/nav.css">
	<script>
	
	
	</script>
</head>
<body>
<script>console.log(localStorage.getItem("hasCodeRunBefore"));</script>
 
		
		<ul class = "navbar">
		  <li class = "navbarelement" id = "logoli"><img src="/images/delta.png" id = "logo"></li>
		  <li class = "navbarelement"><a href="login">Login</a></li>
		  <li class = "navbarelement"><a href="register">Register</a></li>
		  
		  <li class = "navbarelement" style="float:right"><a class="active" href="#about">About</a></li>
		</ul>
		
		<a>Name: ${User.firstname}</a>
		<a>Name: <span id="firstname"></span></a>
		<script>
			var num = "${User.firstname}";
			//console.log(num);
			// Check browser support
			if (typeof(Storage) !== "undefined") {
			  // Store
			  console.log(localStorage.getItem("name"));
			  if(localStorage.getItem("hasCodeRunBefore")===null){
				 localStorage.setItem("hasCodeRunBefore", true);
			 	 localStorage.setItem("name", "${User.firstname}" );
			 	 console.log(localStorage.getItem("name"));
			  }
			  // Retrieve
			  document.getElementById("firstname").innerHTML = localStorage.getItem("name");
			} else {
			  document.getElementById("firstname").innerHTML = "Sorry, your browser does not support Web Storage...";
			}
			
		</script>
</body>
</html>
