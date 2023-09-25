//Exercice 1

const age: number = 21;
const chaine: string = 'blablablabla';
const changeAge: number | boolean = 0;

//Exercide 2

function Count() {
    
}

//Exercice 3 
let nombre: Array<number> = [1,2,3];
let addNumber= nombre.push(0);

nombre.forEach(function(item, array) {
    console.log(item);
  });

//Exercice 4
enum user {
    name,
    age,
    mail
}

console.log(user);

//Exercice 5
/*
class Personne {
    nom: string;
    age: number;
    sePresenter(): void {
        console.log('Je m\'appelle' + [this.nom] + 'et j\'ai ' + [this.age] + ' ans');
    }
}
const a = new Personne();
console.log(a.sePresenter);

//Exercice 6
interface Forme{
    hauteur: number;
    largeur: number;
}

class Rectangle implements Forme{
    hauteur: number;
    largeur: number;
    calculerSurface: number;
    constructor(hauteur: number, largeur: number) {
        const calculerSurface = hauteur * largeur;
      
    }
}
const r = new Rectangle;
console.log(r.calculerSurface)
*/






  



