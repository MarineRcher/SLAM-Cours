<h1> API REST</h1>

Une API est une interface qui permet de faire le lien entre une application et une base de donnée.

REST (representational state transfer) est un style d'architecture logicielle définissant un ensemble de contraintes à utiliser pour créer des services web.
Les données sont généralement reçues au format JSON(javascript object notation)

## Principes

### Ressources

Une ressource peut être tout type d’objet nominal (on lui attribue un nom) que vous pouvez utiliser pour représenter les données dans votre application.
C'est similaire a des collections, dans lesquelles on retrouve des informations supplémentaires.
Tel que
**A list of the open bugs in the bug database**

### URI (Uniform Ressource Identifer)

Les ressources sont identifiables avec les URI, ceux-ci contiennent les chemins vers les ressources comme
**"http://localhost:3003/user/rose"**

Cet URI permet de retrouver un user spécifique avec son nom, qui est Marine.
Principalement les users sont identifiés par un id, qui est une clé unique.

### Représentation

C'est la communication entre le serveur et le client, il s'agit d'une représention et non de la ressource.

```XML
<Customer>
   <Name>Questpond.com</Name>
   <Address>Mulund Mumbai</Address>
</Customer>
```

L'évolutivité est améliorée car le fait de ne pas avoir à stocker l'état entre les requêtes permet au composant serveur de libérer rapidement des ressources et simplifie davantage la mise en œuvre car le serveur n'a pas à gérer l'utilisation des ressources entre les requêtes.

### Méthode HTTP

Les méthodes HTTP (Hypertext Transfer Protocol) sont utilisées dans les API REST (Representational State Transfer) pour indiquer l'action à réaliser sur une ressource spécifique.
Il s'agit du CRUD. La méthode HTTP va provoquer une reponse avec le code 200, qui représente le bon fonctionnement de l'opération ou 404 /500 qui vont représenter des erreurs.

Une API REST doit utiliser différentes methode HTTP :

#### GET
La methode GET permet de representer les ressources demander. Cette methode doit être en mode read-only.

#### POST
La methode POST permet de créer une ressource au seins d'une base de donnée. 

#### PUT
La methode PUT permet de modifier une ressources en remplacent son contenue. 

#### PATCH
LA methode PATCH ressemble a la metode PUT a la différence qu'elle est traité différemment par la serveur. PATCH permet de mettre a jour les ressources. Cependant, ce procéder pour avoir des effets de bords comme la créations de nouvelles ressources. La données doit forcement etre transmis via un format commun comme le JSON ou le XML.

#### DELETE
La methode DELETE resulte en la suppression totale d'une ressource.


