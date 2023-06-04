//Exercice 1

function addition(a: number, b:number){
    console.log(a * b)
}


addition(2,3);
addition(3,1);

//Exercice 2

function salutation(nom: string, titre: string = "M."): void {
    console.log("Bonjour, " + titre + nom);
  }
  
  // Appels de la fonction salutation avec différents arguments
  salutation("franck"); // Bonjour, M. Jean !
  salutation("claire", "Mme.");


//Exercice 3

function calculPrixTotal(prixUnitaire: number =0, quantite: number =0){
        console.log(prixUnitaire * quantite)
}

calculPrixTotal(2,1);
calculPrixTotal(1,5);

//Exercice 4
function afficherInfo(a: string | number){
    if (typeof a === "string") {
        console.log(a)
    } if(typeof a === "number") {
        console.log(a*2)
    }
  }
  afficherInfo(9)
  afficherInfo('kwkw')


//Exercice 5

//const numbers = [3, 4, 8, 2].reverse;
const chaine = ['e','d', 'r', 'w','q'].reverse;



