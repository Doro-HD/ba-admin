# ba-admin
ba-admin er et internt system lavet til bilabonnement A/S

# Host projektet
Dette projekt kan hostes af hvem end der ønsker det, krav og opsættelse er beskrevet nedenunder.

## Krav
- Et sted hvor programmet kan hostes, f.eks. Heroku.
  - Host sitet skal kunne opgive enviorment variable til programmet.
- En online mysql database.

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
## DataRegistration 
- [X] Oprette lejeaftale.
## Skade og udbedring 
- [X] oprette skades reporter på tilbageleveret biler som har overstået lejeperioden.
- [ ] UX til at se hvilke skades reporter brugeren har oprettet.
## BusinessEngineering 
- [X] se hvor mange biler der er lejet ud samt samlet pris
## CarService
- [X] Kan hente biler fra databasen.
