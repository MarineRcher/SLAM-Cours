Exercice 1 : Paramètre de fonction

Déclarez une fonction afficherValeur qui prend un paramètre valeur de type string | number.
À l'intérieur de la fonction, vérifiez le type de valeur à l'aide d'une structure conditionnelle (typeof, instanceof, etc.).
Si le type est string, affichez "La valeur est une chaîne de caractères : [valeur]" dans la console.
Si le type est number, affichez "La valeur est un nombre : [valeur]" dans la console.
Testez la fonction en l'appelant avec différentes valeurs.


Exercice 2 : Attribution de variable

Déclarez une variable resultat de type string | number.
Initialisez la variable avec une chaîne de caractères ou un nombre.
Utilisez une structure conditionnelle pour vérifier le type de resultat.
Si le type est string, concaténez-le avec une autre chaîne de caractères et affichez le résultat.
Si le type est number, multipliez-le par 2 et affichez le résultat.


Exercice 3 : Éléments d'un tableau

Déclarez un tableau valeurs pouvant contenir des éléments de type string ou number.
Ajoutez quelques éléments de différents types au tableau.
Utilisez une boucle ou des méthodes de tableau pour parcourir le tableau et effectuer des opérations spécifiques en fonction du type de chaque élément.


Exercice 4 : Gardes de type (Type guards)

Déclarez une fonction estUneChaine qui prend un paramètre valeur de type string | number.
À l'intérieur de la fonction, utilisez une garde de type (typeof, instanceof, etc.) pour déterminer si la valeur est une chaîne de caractères.
Si c'est une chaîne de caractères, retournez true ; sinon, retournez false.
Testez la fonction en l'appelant avec différentes valeurs et affichez les résultats.



Exercice 5 : Propriétés d'objet

Déclarez une interface Forme avec une propriété type de type string et des propriétés supplémentaires spécifiques à chaque forme (par exemple, rayon pour un cercle, longueur et largeur pour un rectangle).
Déclarez une fonction afficherForme qui prend un paramètre forme de type Forme.
À l'intérieur de la fonction, vérifiez la valeur de la propriété type à l'aide d'une structure conditionnelle.
En fonction du type, accédez aux propriétés correspondantes et affichez-les dans la console.