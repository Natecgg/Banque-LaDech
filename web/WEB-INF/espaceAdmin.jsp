<%-- 
    Document   : espaceAdmin
    Created on : 4 juin 2019, 10:59:42
    Author     : ESIC
--%>
<%@include file="menuIntraAdm.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
         <!-- bootstrap materials-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons">
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
         <body style="background-image: url('Images/background-bourse.jpg'); background-size: cover;">
             
             
          <div class="container"> 
              

        <center>  
        <h3> Espace Administrateur ${admin.mail}  </h3> 
        <br>
        <br>
       </center> 
       </div>
   
          <div class="container"> <h3>Tableau Employés</h3>
        <table class="table">
            <thead class="thead-dark"> 
                <tr>
            <th> Nom </th>
            <th> Prenom</th>
            <th> Mail</th>
     
            </tr>
            </thead>
            <tbody>
         
                <c:forEach items="${liste}" var="conseiller"> 
                    <tr>    
                        <td>${conseiller.nom}</td>
                        <td>${conseiller.prenom}</td>
                        <td>${conseiller.mail}</td>               
                </c:forEach>
            </tbody>
            
        </table>
      </div>
 </body>
</html>
