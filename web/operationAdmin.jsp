<%-- 
    Document   : operationAdmin
    Created on : 4 juin 2019, 13:53:09
    Author     : ESIC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil Administrateur</title>
    </head>
    <body style="background-image: url('Images/background-bourse.jpg'); background-size: cover;">
        <center>
            <br><br>
        <h1>Toutes vos opérations et bien plus encore!</h1>
        </center> 
 <br>
 <center>
        <div class="container">
        <h1>Gestion des conseillés </h1>
        </div>  
 <br><br> 
        <div class="row container text-center">
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Suppression d'un conseiller</h5>
                        <p class="card-text">Sélectionnez le conseiller que vous souhaitez supprimer</p>
                        <form>
                           <select>
                                <c:forEach items="${getAllConseillers}" var="conseiller">
                                     
                                    <option>${conseiller.nom} ${conseiller.prenom}
                                        
                                </c:forEach> <!--Accessible grâce au taglist-->
                            </select>
                        </form>
                        <br>
                        <a href="#" class="btn btn-primary">Valider</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Ajouter un nouveau conseiller</h5>
                        <form>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <input type="text" class="form-control" placeholder="Nom">
                                </div>
                                <div class="form-group col-md-6">
                                    <input type="text" class="form-control" placeholder="Prénom">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <input type="email" class="form-control" placeholder="Email">
                                </div>
                                <div class="form-group col-md-6">
                                    <input type="password" class="form-control" placeholder="Mot de passe">
                                </div>
                            </div>
                          
                        </form>
                        <br>
                        <a href="#" class="btn btn-primary">Ajouter</a>
                    </div>
                </div>
            </div>
        </div>
 </center>
    </body>
</html>

    