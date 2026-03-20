# Projet-1-Coin-Coin-Arena
Conception orientée objet – Concepts avancés Séance 5 – Projet 1 : Coin-Coin Arena



# Rapport :

# Partie A : Héritage et polymorphisme

## R1 — Pourquoi utiliser une classe abstraite ?

J’ai utilisé une classe abstraite `CanardDeCombat` afin de regrouper les attributs et comportements communs à tous les canards (surnom, points de vie, attaque, méthode attaquer).  
Cela permet d’éviter la duplication de code et de garantir une structure commune pour toutes les sous-classes.

---

## R2 — Rôle des sous-classes

J’ai créé plusieurs sous-classes (`CanardFeu`, `CanardEau`, `CanardPlante`, `CanardClassique`) pour représenter les différents types de canards.

Chaque sous-classe possède un type spécifique et peut adapter son comportement, notamment pour le calcul des dégâts.

Cela permet de spécialiser le comportement tout en conservant une base commune.

---

## R3 — Polymorphisme utilisé

Le polymorphisme est utilisé lorsque je manipule des objets via le type `CanardDeCombat`.

Par exemple, dans une équipe ou dans l’arène, je peux stocker différents types de canards et appeler la méthode `attaquer()` sans connaître leur type exact.

C’est le type réel de l’objet qui détermine le comportement exécuté.

---

## R4 — Limite rencontrée avec getMultiplicateur

J’ai tenté de créer plusieurs méthodes `getMultiplicateur` surchargées en fonction du type de la cible.

Cependant, cela ne fonctionne pas correctement car Java choisit la méthode à appeler en fonction du type de référence (`CanardDeCombat`) et non du type réel de l’objet.

La bonne méthode n’est donc pas appelée.

---

## R5 — Problème technique rencontré

Le problème vient du fait que la surcharge de méthode (overloading) est résolue à la compilation, alors que le polymorphisme fonctionne à l’exécution.

Ainsi, même si la cible est d’un type spécifique (Feu, Eau, etc.), Java utilise la version générique de la méthode.

Cela empêche d’avoir un comportement adapté selon le type réel.

---

## R6 — Conclusion sur cette approche

L’approche basée sur l’héritage devient rapidement complexe lorsqu’il faut gérer les interactions entre types.

Elle nécessite beaucoup de code et reste difficile à faire évoluer.

Une approche différente, utilisée dans la Partie B, permet de simplifier cette logique et de mieux gérer les interactions entre types.
