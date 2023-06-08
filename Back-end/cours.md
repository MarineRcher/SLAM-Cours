# MongoDB

Objectifs de la semaine

- Apprendre à importer et exporter des données dans différents formats
- Optimiser l'usage des collections en utilisant l'indexation
- effectuer requetes pour extraire de facon efficace les infos
- Apprendre à optimiser le tps d'execution des requetes en utilisant des index
- Exploiter les fonctionnalités proposées par le framwork d'agregation mongoDB
- Etudier le stockage et la manipulation de fichiers volumineux

## Format JSON

format universel(seul condition: syntaxe) sans structure imposé.

- Les docs permettent de regrouper des infos
- Les bd stockant des docs permettant la gestion d'un grande quantité de docs

Créé la représentation en code vers base de donnée

## MongoDB

système de bd orienté docs et cross-platform.
Proche d'un systeme de code de fichier

## BD

conteneur physique des collections.
Chaque bd prossede ses propres fichiers dans le systeme de gestion de fichiers

## Collection

Groupe de docs MongoDB. équivalent d'une table dans un système de gestion de bd. Les collections n'imposent pas de schema précis.

Les docs présents au sein d'une meme collection peuvent avoir des champs diff

malgrès ca, Tous les docs d'une meme collection sont généralement similaires ou ont un usage similaire

## Document

Ensemble de données clés-valeurs.
Schema de docs dit "dynamique"

Base de donnée : Collection[Documents]

# Avantage MongoDb

- Pas de schéma
- Structure claire et simple
- pas de jointure complexe
- requetes imbriquées et dynamique
- facile de 'scale'
- stockage sur disque
- plus besoin d'ORM

## Pourquoi l'utiliser

- stockage orienté document
- Indexation possible sur chaque attribut
- MAJ simplifiées
- bon support et dev rapide

## Dans quel domaine

- Data hub
- Appli web
  -Big data

## Installation Atlas

- MongoDB Atlas
- gere les clusters
- Maintient et déploie la BD

# Les types de données

- boolean
  -numérique
  -chaine de caracteres
- tableau
- objet
- null (marque absence de valeur)

A ces types MongoDB vient ajouter :

- Le type Date : stock sous la forme d'un entier signé(=positif ou negatif) de 8 octets qui represente le nombre de secondes ecoulees depuis l'époque (epoch) unix : le 1er janvier 1970 à minuit
- Le type ObjectId : un type interne utilisé par MongoDb pour garantir l'unicite des. identifiant generées par la bd
- les types entiers NumberLong(8octets) et NumberInt(4octets) : par defaut MDB considere que les nombres sont des nombres à virgule flottante
- Le type NumberDecimal : 16octets. Nombre à virgule flottante de grande precision

# BSON

format d'échange de données informatiques utilisé principalement comme stockage de données et format de transfert de données par le réseau dans la base de données MongoDB.

https://www.mongodb.com/basics/bson

# MongoDB en ligne de commandes

demarre mongodb

```bash
mongod --port 27017 --dpath /data/db --logpath /tmp/mongodb
```

se connecter

```bash
mongo --host lien.moncluster.fr --port 27017
```

voir bd

```bash
show databases

show dbs
```

Apres une installation fraiche de mongodb vous avez 3 bases solides :

- `admin`
- `config`
- `local`

Elles servent à gérer les roles, autorisations, gestion de mongodb, du parametrage d'instance

Pour savoir quelle base de données on se trouve actuellement en commande `db`, pour lister les collections presentes dans votre base on entre
`show collections`

Pour switcher de base de donnée on utilise `use maDb`

Pour se connecter à une base inexistante, c'est lorsque vous insererez votre premier doc dans une collection de cette base elle sera créée.

```sql
use maBaseDeDonnée
db.maCollection.insert({"une_cle": "une valeur"})
```

```sql
db.maCollection.find()

{
    "_id":ObjectId("..."),
    "une_cle": "une valeur"
}
```

L'insertion de document :

```sql
db.collection.insert(<doc ou tableau>)
```

## API

- acces admin
- acces user
- acces boutique

L'architecture RESTful est un model d'architecture de dev de services web.

**REST** : (Representation State transfert)
Définit un standard et des contraintes tel que :

- L"utilisation d'URI pour identifier les ressources
- L'utilisation de methodes HTTP (GET, POST, PUT, DELETE...), pour effectuer des operations sur ces ressources
- La représentation des ressources au format JSON ou XML

Les APIs (Application programming interface), sont des 'interfaces' qui permettent à des applications de communiquer entre elles.
On s'en sert notamment afin d'échanger des données

Exemple de JSON qui représente un étudiant ISITECH

```JSON
{
  "name":"  ",
  "lastName": " ",
  "age": ,
  "adress" : {
    "rue": " ",
    "ville":"  "
  },
  "phoneNumber": [ {
    "type": "mobile",
    "number": "2321123"
  },
  {
    "type": "fixe",
    "number": "34412"
  }

  ]
}
```

endpoint: Point d'entree unique vers une ressource. Constitué d'un verbe qui designe une methode http et d'une url (uri)

Les codes Http :

- 2XX: Tout s'est bien passé(200: ok, 201: created)
- 3XX: Redirection
- 4XX: Erreur due au client(404: Not Found)
- 5XX: Erreur due au serveur

Pour chaque ressource, mettre en place un CRUD:

- Create
- Read
- Update

# Créer API

```bash
npm init -y
```

```bash
npm install express
pnpm install body-parser
npm i mongodb
```

express :
framework pour construire des applications web basées sur Node.js.

body-parser : middleware qui permet de parser le contenu des

Dans Index.js

```js
const express = require("express");

const app = express();

const postRoutes = require("./routes/post");

app.use("/", (req, res, next) => {
  res.send("hello");
  next();
});

app.use("/blog", postRoutes);

app.listen(3003, () => {
  console.log("app is listening on port 3003");
});
```

Créer dossiers 'controller' et 'routes', avec chacun un fichier post.js

faire marcher avec

```bash
node index.js
```

Dans routes/post.js

```js
const express = require("express");

const postController = require("./../controller/post.js");

const router = express.Router();

router.get("/posts", postController.getPosts);

module.exports = router;
```

Dans controller/post.js

```js
exports.getPosts = (req, res) => {
  res.status(200).json({
    posts: [
      {
        title: "first post",
        content: "blablabla",
      },
    ],
  });
};
```

```bash
npm i -D nodemon
```

On retrouve les infos avec /blog/posts

**ajouter**
dans controller/post

```js
const products = require("./../models/product.js");

exports.createProduct = (req, res) => {
  const name = req.body.name;
  const price = req.body.price;

  // TODO: ajouter des controles...
  const product = new products({
    name: name,
    price: price,
  });

  product
    .save()

    .then((result) => {
      res.status(201).json({
        message: "Product created successfully",
        product: result,
      });
    })
    .catch((error) => {
      console.log("error: ", error);
      // envoyer une reponse appropriee
    });
};
```

Dans routes/post

```js
router.post("/post", postController.createPost);
```

creer dossier models avec post.js

```js
const mongoose = require("mongoose");

const schema = mongoose.schema;

//schema determine la structure du doc de base
const postSchema = new schema({
  title: {
    type: string,
    required: true,
  },
  content: {
    type: string,
    required: true,
  },
});

module.exports = mongoose.model("Post", postSchema);
```

Le fichier index est modifié pour créer la connexion avec la base de donnée

```js
const bodyParser = require("body-parser");
const express = require("express");
const mongoose = require("mongoose");

const app = express();

const productRoutes = require("./routes/product");

app.use(bodyParser.json());

app.use((req, res, next) => {
  console.log("middleware");
  next();
});

// connexion à la base de donnée
app.use("/", productRoutes);

mongoose
  .connect("url mongodb")
  .then((result) => {
    //je lance l'appli express que si je suis connecter à mongodb
    app.listen(3003, () => {
      console.log("app is listening on port 3003");
    });
    //le +e signifie d'afficher l'erreur
  })
  .catch((e) => console.log("echec de connexion" + e));
```

Product by id

dans routes/product

```js
router.get("/:id", productController.getProductById);
```

controller/product

```js
exports.getProductById = async (req, res) => {
  const productid = req.params.id;
  products
    .findById(productid)
    .then((product) => {
      // verifier si le post est correcte

      //si ok

      res.status(200).json({
        message: "product found",
        post: product,
      });
    })
    .catch((error) => {
      if (!error.statusCode) {
        error.status = 500;
      }
      nextTick(err);
    });
};
```

## creer middleware de gestion d'erreurs

https://www.youtube.com/watch?v=WXa1yzLR3hw&ab_channel=procademy

index.js

```js
app.use((error, req, res, next) => {
  error.statuscode = error.statuscode || 500;
  error.status = error.status || "error";
  res.status(error.statuscode).json({
    status: error.statuscode,
    message: error.message,
  });
});

app.all("*", (req, res, next) => {
  const err = new Error("Can't find url on the server");

  err.status = "fail";
  err.statusCode = 400;

  next(err);
});
```

### Custom error class

https://www.youtube.com/watch?v=BZPrK1nQcFI&ab_channel=procademy

dossier error, fichier CustomError

```js
class CustomError extends Error {
  constructor(message, statusCode) {
    super(message);
    this.statusCode = statusCode;
    this.status = statusCode >= statusCode < 500 ? "fail" : "error";

    this.isOperationnal = true;

    Error.captureStackTrace(this, this.constructor);
  }
}
module.exports = CustomError;
//const error = new customError("error", 404);
```

dans index.js

```js
const customError = require("./error/CustomError");

app.use((error, req, res, next) => {
  error.statuscode = error.statuscode || 500;
  error.status = error.status || "error";
  res.status(error.statuscode).json({
    status: error.statuscode,
    message: error.message,
  });
});

app.all("*", (req, res, next) => {
  //const err = new Error("Can't find url on the //server");

  //err.status = "fail";
  // err.statusCode = 400;
  const err = new CustomError("Can't find url on the server", 404);
  next(err);
});
```

Créer fichier controller/errorController

```js
module.exports = (error, req, res, next) => {
  error.statuscode = error.statuscode || 500;
  error.status = error.status || "error";
  res.status(error.statuscode).json({
    status: error.statuscode,
    message: error.message,
  });
};
```

Dans app.js, supprimer

```js
app.use((error, req, res, next) => {
  error.statuscode = error.statuscode || 500;
  error.status = error.status || "error";
  res.status(error.statuscode).json({
    status: error.statuscode,
    message: error.message,
  });
});
```

et ajouter

```js
const globalErrorHandler = require("./controller/errorController");
app.use(globalErrorHandler);
```

## Error in async function

https://www.youtube.com/watch?v=xnedbgDoRkA&ab_channel=procademy

dans un fichier dans controller

```js
const asyncErrorHandler = require('./../error/asyncErrorHandler');

exports.createProduct = asyncErrorHandler(async (req, res, next) => {
  const name = req.body.name;
  const price = req.body.price;

  // TODO: ajouter des controles...
  const product = new products({
    name: name,
    price: price,
  });

  product
    .save()

    .then((result) => {
      res.status(201).json({
        message: "Product created successfully",
        product: result,
      });
    });
});
```

dans error/asyncErrorHandler

```js
module.exports = (func) => {
  return (req, res, next) => {
    func(req, res, next).catch((err) => next(err));
  };
};
```