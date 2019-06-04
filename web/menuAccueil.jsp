<%-- 
    Document   : menuAccueil
    Created on : 3 juin 2019, 16:24:04
    Author     : ESIC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
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
        

        <title>Banque La Dech - Accueil</title>
    </head>
    <body style="background-color: goldenrod; opacity:0.6;">
        
 <!--Navbar-->       
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#"><img src="Images/logo.png" style="width: 70px;">BanqueLaDech</a>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse " id="navbarNav">
    <ul class="navbar-nav">
        
      <li class="nav-item active">
        <a class="nav-link" href="#">Actualités<span class="sr-only">(current)</span></a>
      </li>


      <li class="nav-item">
        <a class="nav-link" href="#">Bourse</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Vidéos</a>
      </li>
    </ul>
  </div>
              <!-- Button trigger modal -->
<button type="button" class="btn btn-raised btn-primary" data-toggle="modal" data-target="#exampleModal" style="background-color: blue;">
  Connexion
</button>
</nav>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document" >
      
    <div class="modal-content" style="border-radius: 40px; border: 2px solid window; margin-top:20%; background-image: url('login-background.jpg'); background-size:cover;">
       
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel" >Accèder à votre compte</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">

                    <br>
                    <br>
                    <div class="col d-flex justify-content-center">
                        <div class="card text-center" style="width: 20rem; height: 25rem; box-shadow: 0 19px 38px  rgba(0,0,0,0.30)">
                            
                            
                            <div class="card-header" style="background-color: turquoise; color: white"> Connexion
                                                   </div>
                            <div class="card-body">
                                <br> <br>
                                
                                <form action="connexion" method="POST">
                                    <div class="form-group">
                                        <input name="login" value ="${param['login']}" class="form-control" type="email" placeholder="login" required>
                                    </div>
                                    
                                    <div class="form-group">
                                        <input name="mdp" class="form-control" type="password" placeholder="password" required>
                                    </div>
                                    <br> 
                                    <button type="submit" class="btn btn-primary"> Connexion </button>
                                </form>
                                <p class="text-danger">${msg}
                                    
                                </p>
                                
                            </div>
                    </div>    
                    </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
        <button type="button" class="btn btn-primary">Se connecter</button>
      </div>
   
  </div>
      </div> 
</div>
      
      
     

    </body>
</html>
