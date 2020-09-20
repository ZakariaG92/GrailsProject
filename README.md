# GrailsProject

Groupe : 
Moussaoui Mohammed
Gasmi Zakaria 
Projet :
Notre application lecoincoin se divise sur trois parties :
Un backend qui permet à l’admin de créer un utilisateur en précisant un username qui n’existe pas déjà, un password et un rôle, de le modifier, ou de le supprimer. Également, il peut appliquer les mêmes actions pour les annonces, avec la possibilité d’ajouter une ou plusieurs images. Pour les deux.
Le Backend n’est accessible que si l’utilisateur est connecté en Admin ou Modérateur
Un Front end permet à tous les utilisateur (Connecté ou non) de visualiser les annonces actuelles.
Un Api est également disponible qui fournit les endpoints suivants :
/users
GET - La liste des utilisateurs enregistrés dans la BD
POST création d’un nouvel utilisateur
paramètres : [username : texte, password : texte]
réponses  : 
201 en cas de création
un message d’erreur, si le username est déjà pris, ou erreur lors de l’enregistrement
/user/{id}
GET - les informations d’un utilisateur ainsi que ses rôles (dans réponse.authorities)
réponses  : 
404 utilisateur n’existe pas
PUT - Modifier toutes les informations d’un utilisateur
paramètres : [username : texte, password : texte]
réponses  : 
201 en cas de modification
404 utilisateur n’existe pas
PATCH - Modifier certaines informations d’un utilisateur
réponses  : 
201 en cas de modification
404 utilisateur n’existe pas
DELETE  - Supprimer un utilisateur
réponses  : 
201 en cas de suppression
404 utilisateur n’existe pas
/salesAd
GET - La liste des annonces enregistrés dans la BD
POST création d’une nouvelle annonce
paramètres : [title : texte, descShort: texte, descLong: texte, price: float]
réponses  : 
201 en cas de création
un message d’erreur si l’enregistrement ne passe pas
/saleAd/{id}
GET - les informations d’une annonce 
réponses  : 
404 annonce n’existe pas
PUT - Modifier toutes les informations d’une annonce
paramètres : [title : texte, descShort: texte, descLong: texte, price: float]
réponses  : 
201 en cas de modification
404 annonce n’existe pas
PATCH - Modifier certaines informations d’une annonce 
réponses  : 
201 en cas de modification
404 annonce n’existe pas
DELETE  - Supprimer une annonce
réponses  : 
201 en cas de suppression
404 annonce n’existe pas
