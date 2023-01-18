# ToDoList

Ce projet a été développé en Java 19 avec l'utilisation de JavaFX, Junit5 et Mockito. Les fonctionnalités suivantes ont été implémentées :

## Utilisateur

- Seul un utilisateur valide peut créer une ToDoList
- Un utilisateur est considéré comme valide s'il remplit les critères suivants :
- Son adresse email est au bon format
- Il a bien un firstname et un lastname
- Son password (non crypté) fait entre 8 et 40 caractères et contient au moins une minuscule, une majuscule et un chiffre
- Il a 13 ans ou plus

## ToDoList

- Un utilisateur peut n'avoir qu'une seule ToDoList
- Une ToDoList peut contenir de 0 à 10 items
- Un item contient un name (unique), un content (maximum 1000 caractères), une date de création
- Il faut obligatoirement respecter une période de 30 min entre la création de 2 items d'une même liste.
- L'ajout d'un item ne se fait que si l'utilisateur est valide.
- Il est possible d'ajouter un item à la liste en utilisant la fonction add(Item)

## Notification

À l'ajout du 8ème item, un email devra être envoyé au User (via une classe EmailSenderService) pour lui indiquer qu'il ne peut plus qu'ajouter 2 items.
> EDIT : L'envoi de mail n'as pas été réalisé, seulement les tests.

## Interface graphique

L'interface graphique de l'application a été développée en utilisant JavaFX. Elle permet à l'utilisateur de :

- S'inscrire en remplissant les informations nécessaires et en vérifiant qu'elles respectent les critères décrits ci-dessus.
- Visualiser et gérer sa ToDoList en ajoutant ou supprimant des items.
- Recevoir une notification lorsqu'il ne peut plus ajouter de nouveaux items à sa liste.
- L'interface est intuitive et facile à utiliser pour permettre une expérience utilisateur agréable.
