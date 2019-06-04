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
    
    <style>
        .nav-item{
            width: 100%;
        }
        
    </style>
    <body>
        
 <!--Navbar-->       
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="index.jsp"><img src="Images/logo.png" style="width: 70px;">BanqueLaDech</a>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse " id="navbarNav">
    <ul class="navbar-nav">
        
      <li class="nav-item">
        <a class="nav-link" href="actualites.jsp" id="menuActualites">Actualités<span class="sr-only">(current)</span></a>
      </li>


      <li class="nav-item">
        <a class="nav-link" href="bourse.jsp" id="menuBourse">Bourse</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="videos.jsp" id="menuVideos">Vidéos</a>
      </li>
    </ul>
  </div>
              <!-- Button trigger modal -->
<button type="button" class="btn btn-raised btn-primary" data-toggle="modal" data-target="#exampleModal" style="background-color: blue;">
  Connexion
</button>
</nav>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="position:absolute; margin-top:-2%;">
  <div class="modal-dialog" role="document" >
      
    <div class="modal-content" style=" border: 2px solid window; margin-top:20%; background-size:cover; box-shadow: 0 19px 38px  rgba(0,0,0,0.30)">
       
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel" style="text-align:center;" >Accèder à votre compte</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" style="background-color: rgb(0,159,134);background-size:cover;">

                    <br>
                    <br>
                    <div class="col d-flex justify-content-center">
                        
                        <div class="card text-center" style="width: 22rem; height: 15rem; box-shadow: 0 19px 38px  rgba(150,150,100,0.30); margin-top: -10%;">
                                                       
                            
                            <div class="card-body" style="position:relative; top:-10%;">
                                <br> <br>
                                
                                <form action="connexion" method="POST">
                                    <div class="form-group">
                                        <input name="login" value ="${param['login']}" class="form-control" type="email" placeholder="login" required>
                                    </div>
                                    
                                    <div class="form-group">
                                        <input name="mdp" class="form-control" type="password" placeholder="password" required>
                                    </div>
                                    <br> 
                                 </form>
                                    <a href="" class="text-info">Mot de passe oublié?</a>
                                <p class="text-danger">${msg}
                                    
                                </p>
                                
                            </div>
                    </div>    
                    </div>
      </div>
     
       <div style="text-align: center; padding-top: 1%;">
        <button type="button" class="btn btn-primary btn-outline" >Se connecter</button>
       </div>
      
   
  </div>
      </div> 
</div>
      
      
     

    </body>
</html>
