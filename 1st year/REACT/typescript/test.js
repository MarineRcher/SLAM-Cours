//TS apporte une syntaxe qui permet d'ajouter des infos sur le type de variable
// Voici la syntaxe de déclaration d'une variable en TS
// let myVariable = type;
var entier = 0;
var chaine = 'Une chute de caracteres';
//on peut creer ses propres types
//const unEtudiant: Etudiant = new Etudiant();
//TS apporte également genericite
var etudiants = [maChaine];
//union de type
var iCanChangeType = 4;
iCanChangeType = false;
//TS propose le type enum
var StudentStatus;
(function (StudentStatus) {
    StudentStatus[StudentStatus["Asleep"] = 0] = "Asleep";
    StudentStatus[StudentStatus["Missing"] = 1] = "Missing";
    StudentStatus[StudentStatus["Focused"] = 2] = "Focused";
})(StudentStatus || (StudentStatus = {}));
//Type de retour
// pour les parametres optionels ajouter ? à cote du nom
function createStudent(firstname, lastname, age, status) {
    var newStudent = {
        age: age,
        firstname: firstname,
        lastname: lastname,
        status: status
    };
    return newStudent;
}
/*
const Marine: Student = {
    firstname:"Marine",
    lastname:"Richer",
    age: 21,
    status : StudentStatus.Focused
    followInClass: function (cours: string)
}
*/
var vehicule = /** @class */ (function () {
    function vehicule() {
    }
    return vehicule;
}());
