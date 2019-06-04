<%-- 
    Document   : operationCon
    Created on : 4 juin 2019, 13:53:32
    Author     : ESIC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            
            <h1>Retrait :</h1>
          
            <br>
          
      <div class="form-group">   
          <h5>  Entrez le montant et le compte à débiter </h5>
            
           <input name="NCompte" class="form-control" type="text" placeholder="numero compte" required>
            <input name="Montant" class="form-control" type="number" placeholder="montant" required>
             </div>
             <br> 
             <button type="submit" class="btn btn-primary">Effectuer Dépot</button>
               
            
        </div>  
        
        
          <div class="container">
            
            <h1>Gestion Clients </h1>
            
            
            <h1> </h1>
            
            
            <button type="button" class="btn btn-raised btn-primary" data-toggle="modal" data-target="#exampleModal" style="background-color: blue;">
  Création client
</button>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="position:relative; top:-100px;">
  <div class="modal-dialog" role="document" >
      
    <div class="modal-content" style="border-radius: 40px; border: 2px solid window; margin-top:20%; background-size:cover; box-shadow: 0 19px 38px  rgba(0,0,0,0.30)">
       
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel" >Accèder à votre compte</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" style="background-image: url('Images/background-login.jpg');background-size:cover;">

                    <br>
                    <br>
                    <div class="col d-flex justify-content-center">
                        
                        <div class="card text-center" style="width: 40rem; height: 50rem; box-shadow: 0 19px 38px  rgba(0,0,0,0.30); margin-top: -10%;">
                                                       
                            
                            <div class="card-body" style="position:relative; top:-10%;">
                                <br> <br>
                                
                                <form action="connexion" method="POST">
                                    <div class="form-group">
                                        <input name="nomclient" class="form-control" type="text" placeholder="Nom" required>
                                    </div>
                                    <div class="form-group">
                                        <input name="prenomclient" class="form-control" type="text" placeholder="Prenom" required>
                                    </div>
                                    <div class="form-group">
                                        <input name="Mailclient" class="form-control" type="text" placeholder=" addresse Mail" required>
                                    </div>
                                    
                                    <div class="form-group">
                                        <input name="Mdpclient" class="form-control" type="text" placeholder="mot de passe" required>
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
            
            
            
            
             
              
               
                <input name="Mdpclient" class="form-control" type="text" placeholder="mot de passe" required>
                 <input name="Idcons" class="form-control" type="text" placeholder="id conseiller" required>
            
            
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
            <h1>Autorisation découvert </h1>
            
            <div class="form-group">   
          <h5>  Entrez l'autorisation de découvert et le numéro de compte </h5>
            
           
            <input name="Montant" class="form-control" type="number" placeholder="montant" required>
            <input name="NCompte" class="form-control" type="text" placeholder="numero compte" required>
             </div>
            
            <h1>Bloquer debloquer client </h1>
            
            
          
            
        </div>   
        
    </body>
</html>
