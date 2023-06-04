# Introduction React

/!\ Voir my-react-app en plus

Bibliothèque qui permet la construction d'interface graphique avec HTML, CSS et JS. Il sert à créer un composant pour l'afficher.
-> Voir Repo React sur Github

Commence a être remplacé par NextJS

## Dans l'introduction de cette semaine nous allons :

- Comprendre les avantages de React
- Découvrir **JSX** :

Pour javascript XML (js et html), qui est une extension de JS
Contient des mots réservés (ex: class). Généralement les mots réservés de l'HTML sont remplacés.

- Créer des **composants**

- Comprendre les imports et exports :

Voir **imports.js** et **export.js**
imports/exports nommés
export default

- Utiliser des **props** :

- Utiliseer le state
- Utiliser les events en React

# JS permet de manipuler le DOM :

C'est la représentation 'objet' des éléments HTML qui constituent une page Web.
Autrement dit, il s'agit d'une interface qui permet d'interagir avec la structure des pages web.
https://developer.mozilla.org/fr/docs/Web/API/Document_Object_Model

React utilise un DOM virtuel pour afficher ses composants (virtual DOM, shadow DOM), car pout manipuler le DOM directement peut etre couteux.

Le DOM ne peut etre manipulé en react en dehors de :

```ts
import { StrictMode } from "react";
import { createRoot } from "react-dom/client";

import App from "./App";

const rootElement = document.getElementById("root");
const root = createRoot(rootElement);

root.render(
  <StrictMode>
    <App />
  </StrictMode>
);
```

Le JSX n'est pas directement executer par une page Web.

## Réalisation d'un projet react TS

Voir react-app-ts

Avec vite :

```bash
npm create vite my-react-app --template react
npm install
```

```bash
npm add -D
```

le -D va installer dans dependancies

Installer pnpm-lock.yaml afin d'avoir moins de problèmes avec les versions

```bash
pnpm i --frozen-lockfile	ou pnpm import
```

le tsx -> transforme en jsx
Le package.json sert à avoir la meme config pour tout le monde (vite remarque s'il y a du changement)

Installe tous les outils

# ESlint / Prettier

```bash
npm add -D prettier
```

permet de configurer

```bash
npm add -D eslint-config-prettier eslint-plugin-prettier
```

Réglage par defaut

```bash
touch .prettierrc.json
```

installer extension prettier - code formater

dans setting > default formatter > Prettier code formatter
setting > format on save > activer

ESlint : Outils de dev qui corrigent les fautes
Prettier : Formatte / mise en forme

# Composant

fonction qui retourne du JSX
Ceux ci peuvent etre imbriqués

# Créer un component

```ts
function ComponentOne() {
  return (
    <>
      <h1>My name is Toto</h1>
    </>
  );
}

export default ComponentOne;
```

L'importer dans App

```ts
import ComponentOne from "./components/ComponentOne.jsx";

function App() {
  return (
    <>
      <h1>Hello</h1>
      <ComponentOne />
    </>
  );
}

export default App;
```

# Props

Les props ont un paramètre optionnel qu'on peut passer à un composant React
Elles constituent un objet qui contient notamment des priorités que l'on peut choisir

- Paramètre de fonction
- permettent de configurer les composants, ils sont passés en tant qu'attributs JSX
- Key et childrey sont des props communes à tous les composants

children : affiche le contenu à l'interieur de la balise

Toujours donner un type aux éléments (number, string...) avec interface ou type

exemple

```ts
type Props = {
  heading: string;
  children: number;
};
function Alert({type = 'Infos, heading, children} : Props})
```

# Les states / hook

Une fonction
L'Etat d'un composant désigne une variable spéciale qui contient des informations sur le contenu actuel du composant
Par exemple, un composant peut-etre en état d'erreur ou de chargement
Un chargement de cet etat va entrainer ce qu'on appelle un **re-render**

`useState` est un hook d'etat qui fournit une variable d'état
et une fonction pour la mettre à jour

```ts
const [state, setState] = useState(initialState);
```

**Règles à respecter**

- Les hooks peuvent etre appelé qu'au niveau le plus haut d'un composant
- Ne peut etre appelé au sein d'un boucle ou event handler
- Un hook ne peut etre appelé conditionnelement
- Les hooks ne peuvent etre appelés qu'à l'interieur d'un fonction composant et pas dans un composant classe

**Hook useContext**
useEffect permet de gérer les effets en React (sideEffects).
L'application React est une fonction qui affiche du contenu à un endroit precis du DOM (element HTML dont l'id est root)

exemple

```ts
function getWeather(city: any): promise<any> {
  return fetch("https//weather" + city);
}
```

**Hook useEffect**
Rafraichie la page, permet de déclarer un effet
La syntaxe du hook useEffect est :

```ts
function unComponent(){
  useEffect()
//1er parametre: fonction
  useEffect(() => {
    console.log('passage par le hook effect');
    return() => {}
  },
  //2eme parametre : Tableau dépendances, si ce dernier vide, la fonction passe en premier parametre du hook useEffect est execute a chque rendu du composant à //l'écran
  //peut etre une variable qui change de données
  []
  return <>Hello</>)
}
```

# Affichage conditionnel

ne pas afficher du contenu

```ts
state(visible): false;
```

Interferance de type: ts devine le type des variable grace au type de retour des fonctions
Si useState n'est pas défini, utiliser boolean

```ts
const [visible, setVisible] = useState<boolean>(true);
```

Plutot que

```ts
const [visible, setVisible] = useState(null);
```

# Promise

L'interface Promise représente un intermédiaire (proxy) vers une valeur qui n'est pas nécessairement connue au moment de la création de la promesse. Cela permet d'associer des gestionnaires au succès éventuel d'une action asynchrone et à la raison d'une erreur. Ainsi, les méthodes asynchrones peuvent renvoyer des valeurs de manière similaire aux méthodes synchrones, la seule différence est que la valeur retournée par la méthode asynchrone est une promesse (d'avoir une valeur plus tard).

https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Global_Objects/Promise

# Ternaire

```ts
type === "Warning" ? "Warnin" : "Information";
```

Equivalent de

```ts
if(type === 'Warning'){
  return 'Warning'
} else {
  return 'Information
}
```

# event (onClick) et handlers

Des fonctions qui vont se lancer lors d'un evenement, comme lorsque l'on clique sur bouton

```ts
// handleClick clickHandler
const handleClick = () => {
  setCount(count + 1);
};
<button onClick={handleClick}>Plus 1</button>;
```

# CSS

**fichier CSS importé**

on importe un fichir Css
on utilise des

```ts
className={styles.nomClasse}
```

pour attribuer à des éléments
dans le fichier css, faire

```css
.nomClasse {
  color: red;
}
```

**CSS dans JS**
repose sur l'utilisation des libs :

- styled components
  -emotion

```ts
export default function App() {
  return (
    <div
      css={`
        font-weight: 800;
        font-size: 2rem;
      `}
    >
      Untiled1
    </div>
  );
}
```

**In js file**
const styles à la fin, mais il ne s'agit pas de CSS (on utilise une lib)
Assez restreint en ressources

**TailwindCSS**

Collection de classes CSS préconstruites et pretes à l'emploi. Pour faire usage de tailwind et profiter des classes founies,
il faut avoir des bases solides en CSS.

https://tailwindcss.com/docs/installation

```bash
npm install -D tailwindcss
npx tailwindcss init
```

Config template in tailwind.config.js

```ts
/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js}"],
  theme: {
    extend: {},
  },
  plugins: [],
};
```

In CSS file

```ts
@tailwind base;
@tailwind components;
@tailwind utilities;
```

start build process

```bash
npx tailwindcss -i ./src/input.css -o ./dist/output.css --watch
```

in html

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="/dist/output.css" rel="stylesheet" />
  </head>
  <body>
    <h1 class="text-3xl font-bold underline">Hello world!</h1>
  </body>
</html>
```

Installer extension Tailwind CSS IntelliSense

# Routes

**React-router-dom**

lib de routing pour React. Un route permet de selection le contenu à afficher pour un chemin.
Pour toute appli react qui contient plusieurs pages les routes sont essentiels

```bash
npm i react-router-dom
```

# Sources

Passe du JSX à JS
https://babeljs.io/repl

compilateur React
https://codesandbox.io/s/react-new

vite : permet de dev en local
https://vitejs.dev/

Vidéo :

[https://www.youtube.com/c/devaslife]

[https://www.youtube.com/channel/UCsBjURrPoezykLs9EqgamOA]

kevin powell -> chaine CSS

extension chrome
https://chrome.google.com/webstore/detail/react-developer-tools/fmkadmapgofadopljbjfkapdkoienihi

promise
https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Global_Objects/Promise

tailwind css
https://tailwindcss.com/docs/installation

Extension VScode
Tailwind CSS Intellisense

# Pratique

https://github.com/type-challenges/type-challenges

Dossier Exercices

```

```
