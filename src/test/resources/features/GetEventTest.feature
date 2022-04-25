Feature: Recuperer la liste des evenements


  Scenario Outline: Recuperer la liste des evenements
    Given une base de donnée ne contenant aucun Evenement existe
#    And un Evenement1 avec les informations suivantes existe
#      | titleEvenement          | startDateEvenement          | endDateEvenement          | locationEvenement         | categoryEvenement         | flagEvenement         | stateEvenement          | nbOfPlacesEvenement         | descriptionEvenement          | photoPreEventEvenement          |
#      | <valueTitleEvenement1>  | <valueStartDateEvenement1>  | <valueEndDateEvenement1>  | <valueLocationEvenement1> | <valueCategoryEvenement1> | <valueFlagEvenement1> | <valueStateEvenement1>  | <valueNbOfPlacesEvenement1> | <valueDescriptionEvenement1>  | <valuePhotoPreEventEvenement1>  |
#    And un Organisateur1 avec les informations suivantes existe
#      | lastNameOrganisateur          | firstNameOrganisateur         | emailOrganisateur         |
#      | <valueLastNameOrganisateur1>  | <valueFirstNameOrganisateur1> | <valueEmailOrganisateur1> |
#    And une liste1 de Oragnisateurs contient le Organisateur1
#    And la liste1 de Organisateurs existe dans Evenement1
#    And une liste2 vide de Participants existe
#    And la liste2 de Participants existe dans Evenement1
#    And une liste3 vide de Photos post event existe
#    And la liste3 de Photos post event existe dans Evenement1
#    And une liste4 vide de Reactions existe
#    And la liste4 de Reactions existe dans Evenement1
#    And une liste5 vide de Regions existe
#    And la liste5 de Regions existe dans Evenement1
#    And le Evenement1 existe en base de donnee
#    When la liste des evenements est recuperee
#    Then une liste de Evenements est renvoyee
#    And la liste de Evenements renvoyee contient un unique Evenement
#    And le premier Evenement de la liste de Evenements renvoyee possede les memes informations que Evenement1
#    And le premier Evenement de la liste de Evenements renvoyee possede un identifiant

    Examples:
      | valueTitleEvenement1  | valueStartDateEvenement1  | valueEndDateEvenement1  | valueLocationEvenement1 | valueCategoryEvenement1 | valueFlagEvenement1 | valueStateEvenement1  | valueNbOfPlacesEvenement1 | valueDescriptionEvenement1  | valuePhotoPreEventEvenement1  | valueLastNameOrganisateur1  | valueFirstNameOrganisateur1 | valueEmailOrganisateur1 |
      | titleEvenement1       | 2023-04-18T13:10:28Z      | 2024-04-18T13:10:28Z    | 13 rue des satellites   | LINKERS                 | NONE                | TODO                  |                           | Ceci est la description     | /photo/image2.png             | TAVAZ                       | BURAK                       | btabaz@afdtech.com      |