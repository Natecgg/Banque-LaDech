<%-- 
    Document   : bourse
    Created on : 4 juin 2019, 11:06:45
    Author     : ESIC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="menuAccueil.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <style>
        #menuBourse{
           color:white;
           font-weight: bold;
           text-decoration: underline;
        }
        
    </style>
    
    <body style="background-image: url('Images/background-bourse.jpg'); background-size: cover;">
       
        <div class="container" style="margin-top:5%; background-color: rgba(0,0,0,0.5); background-size:cover; top: 5%; left:20%; margin:auto; margin-top:2%">
            <div class="header" style="text-align:center; color: white;"><h3>Suivez la bourse presque en directe</h3></div>
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                
                <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
                   
  <div class="carousel-inner">
    <div class="carousel-item active">
        <img class="d-block w-200" src="Images/bourse-CAC40.png" alt="First slide" style="margin: auto;">
        <div class="footer" style="text-align:center; font-weight: bold; font-size:20px; color:white; margin-top:1%;">CAC 40</div>
    </div>
    <div class="carousel-item">
        <img class="d-block w-300" src="Images/bourse-Eurostoxx50.png" alt="Eurostoxx50" style="margin: auto;">
        <div class="footer" style="text-align:center; font-weight: bold; font-size:20px; color:white; margin-top:1%;">EUROSTOXX 50</div>
    </div>
    <div class="carousel-item">
        <img class="d-block w-200" src="Images/bourse-DowJones.png" alt="Third slide" style="margin: auto;">
        <div class="footer" style="text-align:center; font-weight: bold; font-size:20px; color:white; margin-top:1%;">DOW JONES</div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
                  
            
            
        </div>
       <br><br> 
    </body>
</html>
