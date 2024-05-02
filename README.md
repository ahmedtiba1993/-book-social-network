# Book Social Network ( En cours de deloppement )

## Description
Book Social Network est une application full-stack qui permet aux utilisateurs de gérer leurs collections de livres et d'interagir avec une communauté d'enthousiastes de la lecture. Elle propose des fonctionnalités telles que l'inscription des utilisateurs, la validation sécurisée par e-mail, la gestion des livres (création, mise à jour, partage et archivage), le prêt de livres avec vérification de disponibilité, le retour de livres et l'approbation des retours de livres. L'application assure la sécurité en utilisant des jetons JWT et respecte les meilleures pratiques en matière de conception d'API REST. Le backend est construit avec Spring Boot 3 et Spring Security 6, tandis que le frontend est développé avec Angular et Bootstrap pour le style.

## Fonctionnalités
- **Inscription des utilisateurs** : Les utilisateurs peuvent s'inscrire pour un nouveau compte.
- **Validation par e-mail** : Les comptes sont activés en utilisant des codes de validation par e-mail sécurisés.
- **Authentification des utilisateurs** : Les utilisateurs existants peuvent se connecter à leur compte de manière sécurisée.
- **Gestion des livres** : Les utilisateurs peuvent créer, mettre à jour, partager et archiver leurs livres.
- **Emprunt de livres** : Met en œuvre les vérifications nécessaires pour déterminer si un livre peut être emprunté.
- **Retour de livres** : Les utilisateurs peuvent retourner les livres empruntés.
- **Approbation des retours de livres** : Fonctionnalité pour approuver les retours de livres.

## Diagramme de classe
![class-diagram](https://github.com/ahmedtiba1993/-book-social-network/assets/72476268/bc1e0467-f46e-40b4-9f78-c0ecba5cdacc)

## Les technologies utilisées sont :
### Backend (book-network)
- Spring Boot 3
- Spring Security 6
- JWT Token Authentication
- Spring Data JPA
- JSR-303 and Spring Validation
- OpenAPI and Swagger UI Documentation
- Docker
## Améliorations prévues :
- GitHub Actions (bientôt disponible)
- Keycloak  (bientôt disponible)

### Frontend (book-network-ui)
- Angular
- Component-Based Architecture
- Lazy Loading
- Authentication Guard
- OpenAPI Generator for Angular
- Bootstrap

## Contact
Pour plus d'informations, veuillez me contacter sur [LinkedIn](https://www.linkedin.com/in/ahmedtiba1993/).
