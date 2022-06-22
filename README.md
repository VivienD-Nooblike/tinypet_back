# Projet TinyPet - Web & Cloud - M1 MIAGE
This project is developped for the Web & Cloud course of M1 MIAGE at Nantes University
The goal is to create a small scalable REST API using Google Cloud Platform

Members of the project : DUVERNOIS Vivien and HERVIEUX Hugo

Link to app : https://tinypet-354117.oa.r.appspot.com

# Endpoints

# Datastore Schemes #
## Petition ##
|  id | creator  |  title | description  | tags  |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |
|   |   |   |   |   |

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
