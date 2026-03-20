# Projet-1-Coin-Coin-Arena
Conception orientée objet – Concepts avancés Séance 5 – Projet 1 : Coin-Coin Arena



# Rapport :

# Partie B : Refactorisation : composition et Enum

## B.1 – Le constat

En relisant la Partie A, j’ai remarqué trois problèmes principaux :

1. **Données dupliquées (R1)** : chaque canard avait ses propres stats. Par exemple, deux “Canard Flamme” avaient chacun une copie de leurs PV et ATK.
2. **Explosion des méthodes (R3)** : le double dispatch fonctionnait, mais ajouter un type demandait de créer une méthode `etreAttaqueePar` dans la classe mère et de la redéfinir dans toutes les sous-classes. Avec N types, ça faisait N² méthodes.
3. **Explosion des classes (R5)** : chaque combinaison type × comportement spécial nécessitait une nouvelle sous-classe.

Si je voulais ajouter 18 types ou changer le type d’un canard en cours de combat, l’héritage ne le permettait pas. C’est pour ça que j’ai décidé de passer à la **composition** : le type et l’espèce deviennent des **données**, pas des classes.

**Réflexion R7 :**
- Ajouter un nouveau type devient simple : je n’ai qu’à modifier l’Enum.
- Changer le type à l’exécution devient possible, contrairement à l’héritage.
- Je n’ai plus besoin de faire des `instanceof` partout, toutes les instances sont des `Canard`.

---

## B.2 – L’Enum TypeCanard

J’ai créé l’Enum `TypeCanard` qui centralise tous les types (`FEU`, `EAU`, `PLANTE`, `NORMAL`) et qui contient la logique des multiplicateurs avec `getMultiplicateur(TypeCanard cible)`.

Avec cette approche :
- Toute la logique des multiplicateurs est **centralisée**, plus besoin d’avoir plein de méthodes dispersées dans les sous-classes.
- Ajouter un nouveau type, comme `ELECTRIQUE`, ne demande aucune modification de classe, juste une nouvelle valeur dans l’Enum et la table de multiplicateurs.
- Ce design est beaucoup plus maintenable et respecte mieux le **principe Open/Closed**.

---

## B.3 – La classe EspeceCanard

J’ai créé `EspeceCanard` comme un modèle immuable pour chaque espèce, avec le nom, le type, les PV et ATK de base, et la description.

En utilisant des constantes `static final` (`CANARD_FLAMME`, `CANARD_MARIN`, etc.), toutes les instances d’un type partagent le même objet.

**Réflexion R9 (Flyweight) :**
- Si je crée 50 canards Flamme, il n’existe qu’un **seul objet `EspeceCanard` en mémoire**.
- Dans la Partie A, chaque canard avait ses propres stats, donc 50 copies existaient en mémoire.
- Avec cette approche, j’applique le **pattern Flyweight**, ce qui économise de la mémoire et évite de dupliquer les données.

---

## B.4 – La nouvelle classe Canard

La classe `Canard` est maintenant concrète, et je n’ai plus besoin de sous-classes pour chaque type.

Chaque `Canard` a :
- un template `EspeceCanard`
- un surnom
- des PV actuels
- une attaque

Le type est stocké dans l’Enum (`getType()`) et la méthode `attaquer` utilise `getType().getMultiplicateur(cible.getType())` pour calculer les dégâts.

**Avantages :**
- Une seule classe `Canard` pour tous les types.
- Ajouter un nouveau type : juste une valeur dans l’Enum et compléter la table, aucun changement dans `Canard`.
- Le polymorphisme se fait par **composition** (attribut Enum), pas par héritage.

**Réflexion R10 :**
- Dans la Partie A, le double dispatch était élégant, mais chaque nouveau type nécessitait de modifier plusieurs classes.
- Avec la Partie B, je peux **ajouter un type sans toucher au code existant**, ce qui respecte mieux le **principe Open/Closed**.

## B.5 ....(En cours)
