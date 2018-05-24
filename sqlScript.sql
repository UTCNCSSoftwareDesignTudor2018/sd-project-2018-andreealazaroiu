CREATE DATABASE  IF NOT EXISTS `cookingsite` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cookingsite`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cookingsite
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','1234');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `idcomments` int(11) NOT NULL AUTO_INCREMENT,
  `recipe_id` int(11) NOT NULL,
  `content` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`idcomments`),
  KEY `RecipeFKey_idx` (`recipe_id`),
  CONSTRAINT `RecipeFKey` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`idrecipes`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,'It was very easy to make and also it was very tasty although it had no meat.'),(2,1,'Amazingly good considering it had no meat.'),(3,2,'Easy to be made and full of flavour.'),(4,4,'Delicious'),(5,4,'Delicious'),(6,4,'Very simple'),(7,4,'Amazingly good.');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipes` (
  `idrecipes` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(1000) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `admin_id` int(11) NOT NULL,
  PRIMARY KEY (`idrecipes`),
  KEY `AdminFKEy_idx` (`admin_id`),
  CONSTRAINT `AdminFKEy` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (1,'Vegan Three-Bean Chili With Spring Pesto','Heat 1 tablespoon of the oil in a large saucepan over medium-high heat. Add the onion and carrots and cook until tender, about 5 minutes.Stir in the tomatoes and their liquid, 2 cups water, 1 ½ teaspoons salt, and ½ teaspoon pepper and bring to a boil.Add the chickpeas and cannellini and kidney beans and cook until heated through, about 3 minutes.Combine the garlic, pine nuts, parsley, remaining ¼ cup oil, ¼ teaspoon salt, and ⅛ teaspoon pepper in a small bowl.Divide the chili among individual bowls and top with the pesto. Serve with the bread, if desired.',1),(2,'Vegan Asian Hot Pot','Prepare the noodles according to the package directions. Drain and cut into 3-inch lengths.Meanwhile, heat the oil in a large saucepan over medium-high heat. Add the mushrooms and cook, stirring occasionally, for 2 minutes.Add the broth, soy sauce, ginger, and chili sauce (if desired) and combine. Bring to a boil.Add the scallions, carrots, and green beans. Simmer until the vegetables are tender, 5 to 6 minutes.Divide the noodles among individual bowls and ladle the soup over the top.',1),(3,' Shrimp, Leek, and Spinach Pasta','Cook the pasta according to the package directions; drain and return it to the pot.Meanwhile, heat the butter in a large skillet over medium heat. Add the leeks, ½ teaspoon salt, and ¼ teaspoon pepper and cook, stirring occasionally, until the leeks have softened, 3 to 5 minutes.Add the shrimp and lemon zest and cook, tossing frequently, until the shrimp is opaque throughout, 4 to 5 minutes more.Add the cream and ½ teaspoon salt to the pasta in the pot and cook over medium heat, stirring, until slightly thickened, 1 to 2 minutes. Add the shrimp mixture and the spinach and toss to combine.',1),(4,'Baked Pecorino Chicken','Heat oven to 400°F. Toss together bread crumbs, Pecorino, butter, ½ teaspoon salt and ¼ teaspoon pepper. Place the chicken in an 8-inch baking dish; season with ½ teaspoon salt and ¼ teaspoon pepper and sprinkle with the bread crumb mixture. Cover with foil and bake until cooked through, 15 to 20 minutes. Uncover and bake until crumbs are golden, 3 to 5 minutes. Meanwhile, heat the oil in a large skillet over medium-high heat. Add the chard, remaining ½ teaspoon salt and ¼ teaspoon pepper. Cook, tossing, until tender, 3 to 4 minutes. Serve with the chicken.',1),(5,'Vegan Cabbage ','Boil the Water..',1);
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `idusers` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `passw` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Cocias Raul','cocRaul','coco2000','cocias_raul@yahoo.com'),(2,'Claudia Pana','claua_pana','1290','claudia_pana@gmail.com'),(3,'Andreea Lazaroiu','andreea.lazaroiu','Deea1203!','lazaroiu.sabina@gmail.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_recipes`
--

DROP TABLE IF EXISTS `users_recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_recipes` (
  `idusers` int(11) NOT NULL,
  `idrecipes` int(11) NOT NULL,
  KEY `manytomanyRel_idx` (`idusers`),
  KEY `manyToManyRe_idx` (`idrecipes`),
  CONSTRAINT `manyToManyRe` FOREIGN KEY (`idrecipes`) REFERENCES `recipes` (`idrecipes`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `manytomanyRel` FOREIGN KEY (`idusers`) REFERENCES `users` (`idusers`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_recipes`
--

LOCK TABLES `users_recipes` WRITE;
/*!40000 ALTER TABLE `users_recipes` DISABLE KEYS */;
INSERT INTO `users_recipes` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(3,4),(3,1),(3,5);
/*!40000 ALTER TABLE `users_recipes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-22 20:23:46
