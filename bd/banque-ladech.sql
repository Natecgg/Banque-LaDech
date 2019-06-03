-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 03 Juin 2019 à 17:25
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `banque-ladech`
--
CREATE DATABASE IF NOT EXISTS `banque-ladech` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `banque-ladech`;

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `idadmin` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(45) NOT NULL,
  `mdp` varchar(45) NOT NULL,
  PRIMARY KEY (`idadmin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `idclient` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `mdp` varchar(45) NOT NULL,
  `derniereConnexion` datetime DEFAULT NULL,
  `idconseiller` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `idcompteBancaire` int(11) NOT NULL,
  PRIMARY KEY (`idclient`),
  KEY `fk_client_conseiller_idx` (`idconseiller`),
  KEY `fk_client_compte_bancaire1_idx` (`idcompteBancaire`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `compte_bancaire`
--

CREATE TABLE IF NOT EXISTS `compte_bancaire` (
  `idcompteBancaire` int(11) NOT NULL AUTO_INCREMENT,
  `solde` double NOT NULL,
  `demandeDecouvert` double NOT NULL DEFAULT '0',
  `compteActif` tinyint(1) NOT NULL,
  `carteActive` tinyint(1) NOT NULL,
  PRIMARY KEY (`idcompteBancaire`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `compte_bancaire`
--

INSERT INTO `compte_bancaire` (`idcompteBancaire`, `solde`, `demandeDecouvert`, `compteActif`, `carteActive`) VALUES
(1, 8000, 0, 1, 1),
(2, 500, 0, 1, 0),
(3, -55, 200, 1, 1),
(4, 430, 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

CREATE TABLE IF NOT EXISTS `conseiller` (
  `idconseiller` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `mdp` varchar(45) NOT NULL,
  `derniereConnexion` datetime DEFAULT NULL,
  PRIMARY KEY (`idconseiller`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `conseiller`
--

INSERT INTO `conseiller` (`idconseiller`, `nom`, `prenom`, `mail`, `mdp`, `derniereConnexion`) VALUES
(1, 'Banka', 'Joel', 'j-conseiller@ladech.com', 'joel', NULL),
(2, 'revardel', 'Nicolas', 'n-conseiller@ladech.com', 'nicolas', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE IF NOT EXISTS `operation` (
  `idoperation` int(11) NOT NULL AUTO_INCREMENT,
  `beneficiaire` int(11) DEFAULT NULL,
  `idcompte_bancaire` int(11) NOT NULL,
  `libelle` varchar(45) NOT NULL,
  `montant_operation` double NOT NULL,
  `date_operation` datetime NOT NULL,
  PRIMARY KEY (`idoperation`),
  KEY `fk_operation_client1_idx` (`beneficiaire`),
  KEY `fk_operation_compte_bancaire1_idx` (`idcompte_bancaire`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `fk_client_compte_bancaire1` FOREIGN KEY (`idcompteBancaire`) REFERENCES `compte_bancaire` (`idcompteBancaire`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_client_conseiller` FOREIGN KEY (`idconseiller`) REFERENCES `conseiller` (`idconseiller`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `operation`
--
ALTER TABLE `operation`
  ADD CONSTRAINT `fk_operation_client1` FOREIGN KEY (`beneficiaire`) REFERENCES `client` (`idclient`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_operation_compte_bancaire1` FOREIGN KEY (`idcompte_bancaire`) REFERENCES `compte_bancaire` (`idcompteBancaire`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
