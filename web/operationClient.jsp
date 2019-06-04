<%-- 
    Document   : operationClient
    Created on : 4 juin 2019, 09:19:08
    Author     : ESIC
--%>
<%@include file="menuIntraCli.jsp" %>
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
        <title>Opération client</title>
    </head>
    <body style="background-image: url('Images/background-bourse.jpg'); background-size: cover;">
    <center>
        <h1>Toutes vos oprérations et bien plus encore!</h1>
          </center> 
     <br>
    <div class="container">
            
            <h1>Virement : </h1>
            <br>
          
      <div class="form-group">   
          <h5>  Entrez le compte à crediter </h5>
            
            <input name="NCompte" class="form-control" type="text" placeholder="numero compte" required>
            <input name="Montant" class="form-control" type="number" placeholder="montant" required>
             </div>
             <br> 
             <button type="submit" class="btn btn-primary">Effectuer virement</button>
               
            
        </div>   
        
          <div class="container">
            
            <h1>Dépot </h1>
          
            <br>
          
      <div class="form-group">   
          <h5>  Entrez le montant à déposer </h5>
            
<!--            <input name="NCompte" class="form-control" type="text" placeholder="numero compte" required>-->
            <input name="Montant" class="form-control" type="number" placeholder="montant" required>
             </div>
             <br> 
             <button type="submit" class="btn btn-primary">Effectuer Dépot</button>
               
            
        </div>   
            
        </div>   
        <br><br>
        
        
    </body>
</html>
