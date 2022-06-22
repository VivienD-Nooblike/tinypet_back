# Projet TinyPet - Web & Cloud - M1 MIAGE
This project is developped for the Web & Cloud course of M1 MIAGE at Nantes University
The goal is to create a small scalable REST API using Google Cloud Platform

Members of the project : DUVERNOIS Vivien and HERVIEUX Hugo

Link to app : https://tinypet-354117.oa.r.appspot.com
Link to API : https://tinypetback.nw.r.appspot.com/

# Endpoints #
|Name|Method|URL|Usage|
|---|---|---|---|
|getUsers|GET|/users|Get all users|
|getUser|GET|/user/{id}|Get the user identified by the parameter id|
|getUsersByLastNameAndFirstName|GET|/users/searchName/{firstName}/{lastName}|Get a list of users with corresponding names|
|getUsersByMail|GET/user/searchMail/{mail}|Get a list of user ocrresponding to this mail adress|
|saveUser|POST|/user|Creates a new user|
|deleteUser|DELETE|/user/{id}|Delete the user identified by the parameter id|

|Name|Method|URL|Usage|
|---|---|---|---|
|getPetitions|GET|/petitions|Get all petitions|
|getPetition|GET|/petition/{id}|Get the petition identified by the parameter id|
|savePetition|POST|/petition|Creates a new petition|
|deletePetition|DELETE|/petition/{id}|Delete the petition identified by the parameter id|

|Name|Method|URL|Usage|
|---|---|---|---|
|getSignatures|GET|/signatures|Get all signatures|
|getSignature|GET|/signature/{id}|Get the signature identified by the parameter id|
|saveSignature|POST|/signature|Creates a new signature|
|deleteSignature|DELETE|/signature/{id}|Delete the signature identified by the parameter id|

# Shell Methods #
|Name|Command|Usage|
|---|---|---|
|deleteAllPetitions|delete-all-petitions|deleting all petitions from the datastore|
|populatePetitions|populate-petitions <number>|creating 'number' petitions|

|Name|Command|Usage|
|---|---|---|
|deleteAllSignatures|delete-all-signatures|deleting all signatures from the datastore|
|populateSignatures|populate-signatures <number>|creating 'number' signatures|

|Name|Command|Usage|
|---|---|---|
|deleteAllUsers|delete-all-users|deleting all users from the datastore|
|populateUsers|populate-users <number>|creating 'number' users|


# Datastore Schemes #
## Petition ##
|Field|Type|Usage|
|---|---|---|
|id|Long|Datastore Id|
|creator|Long|Id of the User creating the petition|
|title|String|Title of the petition|
|description|String|Description of the petition|
|tags|HashSet<String>|List of all the tags|
|signatureNumber|int|Number of signatures for this petition|
|startDate|Date|Creation date|
|endDate|Date|End of the signing collecting period|
  
## User ##
|Field|Type|Usage|
|---|---|---|
|id|Long|Datastore Id|
|first_name|String|First name of the user|
|last_name|String|Last name of the user|
|mail|String|mail adress of the user|
|password|String|password of the user|
 
 
## Signature ##
|Field|Type|Usage|
|---|---|---|
|id|Long|Datastore Id|
|signatory|Long|Id of the User signing the petition|
|petition|String|Id of the signed petition|
|date|Date|Signature's date|

# Indexes #
indexes:
  - kind: Petition
    properties:
      - name: titre
      - name: tags
      
  - kind: Petition
    properties:
      - name: creator
      - name: titre
  
  - kind: User
    properties:
      - name: first_name
      - name: last_name
  
  - kind: Signature
    properties:
      - name: petition
      - name: signatory
  
  - kind: Signature
    properties:
      - name: petition
      - name: date
