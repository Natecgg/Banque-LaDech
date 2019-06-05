<%-- 
    Document   : operationClient
    Created on : 4 juin 2019, 09:19:08
    Author     : ESIC
--%>
<%@include file="menuIntraCli.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Opération, espace ${client.nom} ${client.prenom}</title>
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
            <form action="Virment" method="POST">  
            
            <input name="NCompte" class="form-control" type="text" placeholder="numero compte" required>
            <input name="Montant" class="form-control" type="number" placeholder="montant" required>
             </div>
</form>
             <br> 
             <button type="submit" class="btn btn-primary">Effectuer virement</button>
               
            
        </div>   
        
          <div class="container">
            
            <h1>Dépot :</h1>
          
            <br>
          
      <div class="form-group">   
          <h5>  Entrez le montant à déposer </h5>
            
          <form action="dépot" method="POST">
            <input name="Montant" class="form-control" type="number" placeholder="montant" required>
             </div> </form> 
             <br> 
             <button type="submit" class="btn btn-primary">Effectuer Dépot</button>
              
            
        </div>   
            
        
        <br><br>
        
          <div class="container"> <h3>Tableau clients</h3>
        <table class="table">
            <thead class="thead-dark"> 
                <tr>
            <th> Libellé </th>
            <th> Montant</th>
            <th> Id Bénéficiaire</th>
            <th> n° compte</th>
            </tr>
            </thead>
            <tbody>
               <c:forEach items="${liste}" var="op"> 
                    <tr>    
                        <td>${op.libelle}</td>
                        <td>${op.montantOperation}</td>
                        <td>${op.idBeneficiaire}</td>
                        <td>${op.dateOperation}</td>
                    
                    </tr>
                </c:forEach>
                
                
                
            </tbody>
            
        </table>
      </div>
        
        
    </body>
</html>
