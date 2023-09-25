//TS apporte une syntaxe qui permet d'ajouter des infos sur le type de variable

// Voici la syntaxe de déclaration d'une variable en TS
// let myVariable = type;
/*
const entier: number = 0;
const chaine: string = 'Une chute de caracteres';

//on peut creer ses propres types
//const unEtudiant: Etudiant = new Etudiant();

//TS apporte également genericite
const etudiants: Array<string> = [maChaine]

//union de type
let iCanChangeType : number | boolean = 4;

iCanChangeType= false;

//TS propose le type enum
enum StudentStatus {
    Asleep,
    Missing,
    Focused
}

//Les interfaces 
// On peut comparer une interface a un contrat, implémenter une interface c'est s'engager à posséder toutes les propriétés présentes dans l'interface
interface Student{
    firstname: string,
    lastname: string,
    age: number,
    status : StudentStatus
    followInClass(Cours: String): void 
}

//Type de retour
// pour les parametres optionels ajouter ? à cote du nom
function createStudent(firstname: string, lastname: string,age: number, status: StudentStatus): Student {
    const newStudent : Student = {
        age: age,
        firstname: firstname,
        lastname: lastname,
        status: status
    }
    return newStudent
}

const Marine: Student = {
    firstname:"Marine",
    lastname:"Richer",
    age: 21,
    status : StudentStatus.Focused
    followInClass: function (cours: string)
}
*/

class vehicule {
        brand: string;
        color: string;
        speed: number;

        deplacer(): void {
            console.log('je me deplace');
        }
        constructor(){
            console.log('nouveau vehicule cree')
        }
}