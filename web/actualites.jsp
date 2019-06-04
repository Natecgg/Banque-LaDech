<%-- 
    Document   : actualites
    Created on : 4 juin 2019, 10:40:43
    Author     : ESIC
--%>
<%@include file="menuAccueil.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d'actualités</title>
    </head>
    <body>
        <br><br><br>    
      
            <div class="row">
                <div class="col container text-center" style="padding: 3%">
                    <h5>Crédit immobilier : Vous rêvez d’acheter un appartement ou une maison, vous avez besoin d’un financement ?</h5>
                    <br>
                    <img src="Images/Logement.jpg" class="d-block w-100" alt="...">
                    <br>
                    <p>Avec Banque LaDech, vous pouvez effectuer votre demande de crédit immobilier 
                        100% en ligne et bénéficier des taux fixes parmi les plus bas du marché.</p>
                    <br>
                    <p style="color: steelblue"><b>Je simule mon crédit immobilier</b></p>
                </div>
                <div class="col-6 bd-example container">
                    <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                            <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="Images/Bourse.jpg" class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
                                        <h1>Les Bourses européennes restent méfiantes, les "tech" pèsent</h1>
                                        <p>Les principales Bourses européennes évoluent en ordre dispersé mardi, 
                                        l'aversion au risque restant néanmoins prédominante chez les investisseurs face aux craintes de ralentissement de l'économie 
                                        mondiale lié à l'aggravation des tensions commerciales internationales.</p>
                                    </div>
                            </div>
                            <div class="carousel-item">
                                <img src="Images/Eglise.jpg" class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
                                        <h1>L'architecte chargé de Notre-Dame appelle à refaire la flèche "à l'identique"</h1>
                                        <p>L'architecte chargé de la restauration de Notre-Dame, Philippe Villeneuve, 
                                        a appelé mardi dans un entretien au Figaro à refaire la flèche de la cathédrale de Paris "à l'identique", 
                                        malgré le souhait du président Emmanuel Macron de voir "une reconstruction inventive".</p>
                                    </div>
                            </div>
                            <div class="carousel-item">
                                <img src="Images/Bio.jpg" class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
                                        <h1>L'agriculture biologique française a connu une "année record" en 2018</h1>
                                        <p>La production agricole biologique a enregistré une "année record" en France en 2018, 
                                        surtout dans les céréales, avec une progression à 7,5% de la surface agricole bio, 
                                        tandis que 10% des agriculteurs travaillent désormais en bio dans le pays, a annoncé mardi l'Agence Bio.</p>
                                    </div>
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <div class="col">
                    3 of 3
                </div>
            </div>
    
        
    </body>
</html>

    
 
 
 

 
    
