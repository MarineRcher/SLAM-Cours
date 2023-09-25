# Introduction Java

Java existe depuis + de 20 ans et appartient à oracle (avt à Sun Microsystems). Standard en entreprise.

## Qu'est ce que JAVA
- Langage **orienté objet**
- platforme de dev : composée d'un ensemble de librairie et specifications (**JSR** : Java specification Request)
qui decrivent les APIs constituant la platforme et les outils qui permettent de **compiler**, **debugger** et **executer** les programmes ecrient en Java.

In reality there are many platforms : JAVA SE, Java EE et Java Embedded

- It's also a **execution environment** (**JRE**: Java runtime Evt). Il permet d'executer des programmes au travers de la JM
ou Java virtual Machine. Installation JRE necessary for execute java program (a dev will have to install **JDK**).

- Java est robuste, interprété, distribuer, Portable et sécurisé


## Goals in JAVA conception

-Obtenir un language et une plateforme simple et performantes dont le but est le deploiement et le dev d'appli


## Caracteristiques Java

- Simple : 3 types primitifs (peut etre manipulé en tant que valeur contrairement à un objet )qui sont les numériques, caracteres et boolean. Les types num sont tous signés.
- Les tableaux et String sont des objets
- Le dev ne s'occupe pas de la memoire. Un systeme de garbage collector est prst pour libérer le memoire.

En java tout est objet, à l'exception des types primitifs.


Les avantages de la programmation objet :
- Une bonne maitrise des codes et projets complexes

## La platerforme Java SE

CF schemaJSE

JDK -> propose API specifiques mais surtout outils aides en dev comme compilateur javac. Embarque le JRE (Java runtime envt)

JVM -> gestion pointeur (ref faite pour chaque objet) + liberation auto de la memoire (quand un objet n'est plus referencé)

La plupart des API de base de Java font appel à du code natif qui est fournit avec le JRE pour interreagir avec le systeme hote.

## Les implémentation de la plateforme JAVA SE

Deux principales :
- Oracle JDK (oracle java se: payant)
- Open JDK

## installation

- Mac :
Install avec homebrew
```bash
brew install openjdk@17
```

- Windows 
Install sur https://jdk.java.net/java-se-ri/17
Aller dans repertoire

```bash
C:\java\jdk-11.0.2
echo 'export PATH="/usr/local/opt/openjdk@17/bin:$PATH"' >> ~/.zshrc
source .zshrc 
java -version
```

Dans variable d'environnement : 
modifier **PATH** pour ajouter repertoire bin java 
```sh
%JAVA_HOME%/bin
```

## Java doc
https://www.oracle.com/java/technologies/javase-documentation.html

## Introduction 

- tous les modules commencent par java
- L'api est composée de modules

Afin d'etre execute correctement, un programme java doit etre compiler puis executé

### Compilation

La compilation d'un programme Java se fait avec la cmd **javac**. Permet de transformer le code source java en **bytecode** (binaire executable) ou langage intermediaire.

La compilation se fait avec JRE.

```bash
javac nameFichier.java
```

## premier pas 


### Les avariables

Permettent de mémoriser pdt ;'exec d'une appli diff valeurs utiles à son bon fonctionnement. Av d'utiliser des variables dans un programme, il convient de savoir ou les déclarer, quel nom leur donner et quel type.

On peut déclarer une variable a peu pret n'importe ou dans notre programme. Elle doivent etre obligatoirement décalenrer entre les accolades

```java

public class MyClasse {
//variable d'instance 
//pour declarer une variable il faut portee + type + nom
private int variableInstance;

//variable de classe
private static int variableClasse;

// methode 
//pour déclarer methode : portee, type retour
//nom, parametres optionnels
    public void maMethode (int parameters){
        int variableLocale = 0;
    }
}
```

nom variables : 

- Doit commencer par lettre ou underscore
- ne contient pas d'espace
- ne contient pas de caractere speciaux
- ne doit pas etre un mot cle du langage (CamelCase ou PascalCase)


Type de variables :

```java
int i = 0;
```

Il existe 2 categories de types de variables :
- types valeurs
- types refs

Les types valeurs, sont 7 catégories et on les organise en 4 catégories :
- Num entiers
- décimaux
- caracteres 
- booleens

La déclaration des variables :

```java
[modificateur] type nomVariable;
```

```java
type variable, variable1, variable2;
```

Exemple décla de variable 

```java
int i;
Date today;
String name, firstName;
```

#### Initialisation variable

```java
int i;
i=0; //initialisation
```

#### L'affectation

```java
nomVariable = nouvelleValeur;
```


