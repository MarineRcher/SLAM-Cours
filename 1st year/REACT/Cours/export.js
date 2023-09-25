// Les imports et exports permettent de structure les fichiersjs en module

// Par defaut JS execute la 'global scope'
//Le contenu du code d'un fichier est automatiquement disponible au sein d'un autre fichier

// On peut considérer qu'un fichier js est un module dès lors qu'il contient un 'export'


function myFuncA () {
    console.log('A')

}

function myFuncB () {
    console.log('B')
}

function myFuncC () {
    console.log('C')
}

//syntaxe des l'export nomme
export {myFuncA, myFuncB, myFuncC};

//syntaxe export default
export default myFuncA;