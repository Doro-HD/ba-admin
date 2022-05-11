# ba-admin
ba-admin er et internt system lavet til bilabonnement A/S

# Host projektet
Er kan hoste dette projekt såfremt det ønskes, krav og opsættelse er beskrevet nedenunder.

## Krav
- Et sted hvor programmet kan hostes, f.eks. Heroku.
  - Host sitet skal kunne opgive enviorment variable til programmet.
- En online mysql database.

## Opsætning
- Sæt databasen op og sørg for at env variablerne er tilgængelig for programmet.
  - Programmet benytter følgende env variabler
    - "db_url"
      - Programmet benytter sig af jdbc til at forbinde til en database så der skal tilføjes "jdbc:" foran "mysql:" i den url som bliver givet af database udbyderen.
    - "db_username"
    - "db_password"
- Upload programmet til host sitet

# Roadmap
## DataRegistration 
- [ ] oprette lejeaftale
## Skade og udbedring 
- [ ] oprette skades reporter på tilbageleveret biler som har overstået lejeperioden
## BusinessEngineering 
- [ ] se hvor mange biler der er lejet ud samt samlet pris