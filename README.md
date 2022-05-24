# ba-admin
ba-admin er et internt system lavet til bilabonnement A/S

# Host projektet
Dette projekt kan hostes af hvem end der ønsker det, krav og opsættelse er beskrevet nedenunder.

## Krav
- Et sted hvor programmet kan hostes, f.eks. Heroku.
  - Host sitet skal kunne opgive enviorment variable til programmet.
- En online mysql database med følgende tabeller.
  - cars:
    - car_number: int auto incremented
    - chassis_number: varchar
    - car_state: varchar
  - damage_reports:
    - id: int auto:  incremented
    - total_cost: int
    - car_number: foreign key int
    - warning_date: date
  - damages:
    - id: int auto incremented
    - damage_type: varchar
    - price: int
    - damage_report_id: foreign key int
  - Leases
    - id: auto incremented int
    - lease_name: varchar
    - monthly_payment
    - car_number: foreign key int
    - expiration_date: date
  - users
    - id: auto incremented int
    - username: varchar
    - user_password: varchar
    - role: 

## Opsætning
- Sæt en databasen op.
  - På nuværende tidspunkt kan programmet ikke selv oprette brugere så de skal oprettes på anden vis, f.eks. via mysql workbench.
    - Vær opmærksom på at programmet benytter sig af bcrypt til at validere brugeres passwords, derfor skal alle passwords i databasen være hashet med bcrypt, ellers vil der opstår en fejl når en bruger prøver at logge ind.
- Sæt host sitet op, vær opmærksom på at programmet benytter sig af enviorment variabler som host sitet skal kunne give til det.
  - Programmet benytter følgende env variabler
    - "db_url". Url til databasen.
      - Programmet benytter sig af jdbc til at forbinde til en database så der skal tilføjes "jdbc:" foran "mysql:" i den url som bliver givet af database udbyderen.
    - "db_username". Brugernavnet til databasen
    - "db_password". Password til databasen.
- Upload programmet til host sitet.

# Roadmap
## Login
- [ ] Generere hashed passwords.
- [X] Validere passwords.
- [X] Brugere kan logge ind på det interne system.
## DataRegistration
- [X] Oprette lejeaftale.
- [X] Oprette biler.
- [ ] Bil ændre stadie til udlejet efter oprettet lejeaftale.
- [ ] Ændre bils stadie fra udlejet til check up.
## Skade og udbedring 
- [X] oprette skades reporter på tilbageleveret biler som har overstået lejeperioden.
- [X] UI til skades rapport der har overskredet en bestemt advarselsdato. 
- [X] UI til at se hvilke skades reporter brugeren har oprettet.
- [ ] Bil ændre stadie fra checkup til skadet eller ledig efter check up
## BusinessEngineering 
- [X] se hvor mange biler der er lejet ud samt samlet pris
## CarService
- [X] Kan hente biler fra databasen.
