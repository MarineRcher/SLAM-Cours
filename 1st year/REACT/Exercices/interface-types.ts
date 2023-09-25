//Exercice 1

interface Vehicule{
    marque: string;
    annee: string;
    couleur: string;
}

function getVehiculeDetail(tableVehicule: Vehicule) {
    console.log((tableVehicule.marque), (tableVehicule.annee), (tableVehicule.couleur));
}
let voiture = {
    marque:"Porshe",
    annee:'2020',
    couleur:"noir",
};

getVehiculeDetail(voiture);


//Exercice 2
interface Personne{
    nom: string;
    age: string;
    adresse: string;
}

function getPersonDetail(tablePersonne: Personne) {
    console.log((tablePersonne.nom), (tablePersonne.age), (tablePersonne.adresse));
}

let personne = {
    nom:"Marine",
    age:'21',
    adresse:"lyon"
};

getPersonDetail(personne);


//Exercice 3
interface Animal {
    nom: string
}
interface Chien extends Animal {
    race: string
}

function animalDetail(tableChien: Chien){
    console.log((tableChien.nom), (tableChien.race));
}

let monChien = {
    nom: 'iouky',
    race: 'labrador'
}

animalDetail(monChien); 


//Exercice 4

type Identifiant = string | number;

function getId(tableId: Identifiant) {
    console.log(tableId)
}

let id : Identifiant = '445vvv'

//Exercice 5
/*
interface Calcul {
    a: number,
    b: number
}

function addition(tableCalcul: Calcul){
    console.log((tableCalcul.a) + (tableCalcul.b))
}


let calculatrice: Calcul ={
    a:2,
    b:1 
  }
  
  addition(calculatrice);
*/

