<%-- 
    Document   : espaceClient
    Created on : 3 juin 2019, 16:22:13
    Author     : ESIC
--%>
<%@page import="fr.dev13.model.Client"%>
<%@include file="menuIntraCli.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url('Images/background-bourse.jpg'); background-size: cover;">
        
          <div class="container"> 
              
                  
        <h3> Espace client de ${client.nom} ${client.prenom} :  </h3> 
        <br> <br>
       </div>
        <div class="container">
            <center>
            <img src="Images/rain.gif" alt=""/>
            </center>
         </div>
        <br><br>
        <div class="container">
            <center>
        <h3> Votre solde actuel est : ${solde} </h3> <br>
        </center>
         </div>
        
 </body>
</html>
 




