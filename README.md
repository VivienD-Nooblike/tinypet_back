# Projet TinyPet - Web & Cloud - M1 MIAGE
This project is developped for the Web & Cloud course of M1 MIAGE at Nantes University
The goal is to create a small scalable REST API using Google Cloud Platform

Members of the project : DUVERNOIS Vivien and HERVIEUX Hugo

Link to app : https://tinypet-354117.oa.r.appspot.com

# Endpoints

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
