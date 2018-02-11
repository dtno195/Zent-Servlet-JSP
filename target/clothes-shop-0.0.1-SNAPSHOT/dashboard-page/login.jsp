<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <script src="https://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>

<link href='https://fonts.googleapis.com/css?family=Raleway:300,200' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  
      <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/login.css">

  
</head>

<body>
  <div class="menu">
  <ul class="mainmenu clearfix">
    <li class="menuitem">Well</li>
    <li class="menuitem">how</li>
    <li class="menuitem">about</li>
    <li class="menuitem">that?</li>
  </ul>
</div>
<button id="findpass">What's the password?</button>
<div class="form">
 <form role="form" method="POST" action="<%=request.getContextPath() %>/login">
  <div class="forceColor"></div>
  <div class="topbar">
    <div class="spanColor"></div>
   
	 <input type="text" class="input" id="username" name="username" placeholder="Username"/>
    <input type="password" class="input" id="password" name="password" placeholder="Password"/>
   
  </div>
   <a href="" class="forgotPass">Forgot password ?</a>
  <button class="submit" id="submit" >Login</button>
  </form>
</div>
<article class="article">
 
</article>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script  src="<%=request.getContextPath() %>/assets/js/login.js"></script>

</body>
</html>
