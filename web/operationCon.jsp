<%-- 
    Document   : operationCon
    Created on : 4 juin 2019, 13:53:32
    Author     : ESIC
--%>
<%@include file="menuIntraCon.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>page conseiller</title>
        
            <!--CSS pour Bootstrap materials-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons">
<link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" 
      integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">

        <!--JS pour Bootstrap materials-->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" 
integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" 
integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>
    </head>
    <body style="background-image: url('Images/background-bourse.jpg'); background-size: cover;">
        
         <center>
        <h1>Toutes vos oprérations et bien plus encore!</h1>
          </center> 
    <br>
        
         <div class="container">
            
            <h1>Virement : </h1>
            <br>
            
      <form action="Crediter" method="POST">     
      <div class="form-group">   
          <h5>  Entrez le compte à crediter </h5>
          
            
            <input name="NCompte" class="form-control" type="text" placeholder="numero compte" required>
            <input name="Montant" class="form-control" type="number" placeholder="montant" required>
            
            </div>
            </form>
             
             <button type="submit" class="btn btn-primary">Effectuer virement</button>
              <br>  
            
        </div>   
        
          <div class="container">
            
            <h1>Retrait :</h1>
          
            <br>
            
     <form action="Debiter" method="POST">     
      <div class="form-group">   
       <h5>  Entrez le montant et le compte à débiter </h5>
            
           
           <input name="NCompte" class="form-control" type="text" placeholder="numero compte" required>
            <input name="Montant" class="form-control" type="number" placeholder="montant" required>
             
            </div>
     </form>
             
             <button type="submit" class="btn btn-primary">Effectuer Dépot</button>

             <br>
        </div>  
        
        
          <div class="container">
            
            <h1>Gestion Clients </h1>
            
            <br>
            <h1> </h1>
            
            
            <button type="button" class="btn btn-raised btn-primary" data-toggle="modal" data-target="#exampleModal" style="background-color: blue;">
  Création client
</button>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="position:relative; top:-100px;">
  <div class="modal-dialog" role="document" >
      
    <div class="modal-content" style="border-radius: 15px; border: 2px solid window; margin-top:20%; background-size:cover; box-shadow: 0 19px 38px  rgba(0,0,0,0.30)">
       
    

      <div class="modal-body" style="background-image: url('Images/background-login.jpg');background-size:cover;">

                    <br>
                    <br>
                    <div class="col d-flex justify-content-center">
                        
                        <div class="card text-center" style="width: 45rem; height: 25rem; box-shadow: 0 19px 38px  rgba(0,0,0,0.30); margin-top: -5%;">
                                                       
                            
                            <div class="card-body" style="position:relative; top:-10%;">
                                <br> <br>
                                
                                <form action="ajoutClient" method="POST">
                                    <div class="form-group">
                                        <input name="nomclient" class="form-control" type="text" placeholder="Nom" required>
                                    </div>
                                    <div class="form-group">
                                        <input name="prenomclient" class="form-control" type="text" placeholder="Prenom" required>
                                    </div>
                                    <div class="form-group">
                                        <input name="Mailclient" class="form-control" type="email" placeholder=" addresse Mail" required>
                                    </div>
                                    
                                    <div class="form-group">
                                        <input name="Mdpclient" class="form-control" type="password" placeholder="mot de passe" required>
                                    </div>
                                    <br> 
                                     <div class="form-group">
                                        <input name="Idcons" class="form-control" type="text" placeholder="id conseiller" required>
                                    </div>
                                 </form>
                              
                            </div>
                    </div>    
                    </div>
      </div>
     
       <div style="text-align: center; padding-top: 1%;">
        <button type="button" class="btn btn-primary btn-outline" >Ajouter</button>
       </div>
      
   
  </div>
            
            
            
   </div>
     </div>
            
<br><br>
              
            <h1>Autorisation découvert </h1>
            
            <div class="form-group">   
          <h5>  Entrez l'autorisation de découvert et le numéro de compte </h5>
            
           
            <input name="Montant" class="form-control" type="number" placeholder="montant" required>
            <input name="NCompte" class="form-control" type="text" placeholder="numero compte" required>
             </div>
            
            <br>
             <div class="form-group">   
            <h1>Bloquer debloquer client </h1>
            
             <input name="NCompte" class="form-control" type="text" placeholder="numero compte" required>
          
            
        </div>   
          <button type="button" class="btn btn-primary btn-outline" style="background-color: red;">Bloquer compte</button>
          <button type="button" class="btn btn-primary btn-outline" style="background-color: green;">Débloquer compte</button>
    </body>
</html>
