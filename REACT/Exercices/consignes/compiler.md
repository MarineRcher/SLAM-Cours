Exercice 1: Configuration du fichier tsconfig.json

    Créez un fichier tsconfig.json à la racine de votre projet TypeScript.
    Ajoutez une option target dans le fichier tsconfig.json pour spécifier la version ECMAScript cible (par exemple, "target": "es2018").
    Ajoutez une option outDir pour spécifier le répertoire de sortie des fichiers JavaScript compilés.

    
Exercice 2: Activation de la vérification des types stricts

    Ajoutez l'option "strict": true dans le fichier tsconfig.json pour activer la vérification des types stricts.
    Modifiez un fichier TypeScript existant en introduisant une erreur de type (par exemple, en assignant une chaîne de caractères à une variable de type nombre).
    Exécutez la commande de compilation TypeScript pour vérifier que l'erreur de type est détectée.


Exercice 3: Configuration des options de compilation supplémentaires

    Ajoutez une option "noUnusedLocals": true dans le fichier tsconfig.json pour détecter les variables locales non utilisées.
    Ajoutez une option "noImplicitReturns": true pour détecter les fonctions qui n'ont pas de retour explicite.
    Modifiez votre code TypeScript existant pour introduire des variables non utilisées ou des fonctions sans retour explicite.
    Exécutez la commande de compilation TypeScript et vérifiez que les avertissements ou les erreurs appropriés sont signalés.



Exercice 4: Configuration des options de suppression des commentaires et de génération de source map

    Ajoutez l'option "removeComments": true dans le fichier tsconfig.json pour supprimer les commentaires lors de la compilation.
    Ajoutez l'option "sourceMap": true pour générer des fichiers source map lors de la compilation.
    Compilez votre projet TypeScript et vérifiez que les commentaires sont supprimés et que les fichiers source map sont générés.



Exercice 5: Utilisation de fichiers de configuration partielle

    Créez un fichier tsconfig.base.json qui contient les options de configuration communes à tous les projets TypeScript.
    Créez un fichier tsconfig.app.json qui étend le fichier tsconfig.base.json et contient des options spécifiques à une application.
    Utilisez les commandes de compilation TypeScript pour compiler votre projet en utilisant les fichiers de configuration partielle.