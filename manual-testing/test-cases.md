# Test Cases

## Valet Parking

| Test Case ID | Feature | Test Summary / Scenario | Steps | Test Data | Expected Result |
|---|---|---|---|---|---|
| VP01 | Valet Parking | Enter negative parking time | 1. Access parking app 2. Enter parking time 3. Click Calculate | T = -1h | Error message "invalid time" |
| VP02 | Valet Parking | Enter zero parking time | 1. Access parking app 2. Enter parking time 3. Click Calculate | T = 0h | Error message |
| VP03 | Valet Parking | Enter Parking time less than 5h | 1. Access parking app 2. Enter parking time 3. Click Calculate | T = 2h | Price = 12$ |
| VP04 | Valet Parking | Enter parking time exactly 5h | 1. Access parking app 2. Enter parking time 3. Click Calculate | T = 5h | Price = 18$ |
| VP05 | Valet Parking | Enter parking time more than 5h | 1. Access parking app 2. Enter parking time 3. Click Calculate | T = 5h01m | Price = 18$ |
| VP06 | Valet Parking | Enter parking time 10h | 1. Access parking app 2. Enter parking time 3. Click Calculate | T = 10h | Price = 18$ |
| VP07 | Valet Parking | Enter parking time below 24h | 1. Access parking app 2. Enter parking time 3. Click Calculate | T = 23h59m | Price = 18$ |
| VP08 | Valet Parking | Enter parking time exactly 24h | 1. Access parking app 2. Enter parking time 3. Click Calculate | T = 24h | Price = 18$ |
| VP09 | Valet Parking | Enter parking time more than 24h | 1. Access parking app 2. Enter parking time 3. Click Calculate | T = 24h01m | Error message |
| VP10 | Valet Parking |  |  |  |  |

## Long term garage parking

| Test Case ID | Test Summary / Scenario | Steps | Test Data | Expected Result |
|---|---|---|---|---|
| LT01 | Enter negative parking time | 1. Access parking app 2. Enter parking time 3. Click Calculate | t = -2h | Error message |
| LT02 | Enter zero parking time | 1. Access parking app 2. Enter parking time 3. Click Calculate | t = 0h | Error message |
| LT03 | Enter parking time under 1h | 1. Access parking app 2. Enter parking time 3. Click Calculate | t = 30m | Price = 2$ |
| LT04 | Enter parking time 1h | 1. Access parking app 2. Enter parking time 3. Click Calculate | t = 1h | Price = 2$ |
| LT05 | Enter parking time 4h | 1. Access parking app 2. Enter parking time 3. Click Calculate | t = 4h | Price = 8$ |
| LT06 | Enter parking time below 6h | 1. Access parking app 2. Enter parking time 3. Click Calculate | t = 5h59m | Price = 12$ |
| LT07 | Enter parking time exactly 6h | 1. Access parking app 2. Enter parking time 3. Click Calculate | t = 6h | Price = 12$ |
| LT08 | Enter parking time above 6h | 1. Access parking app 2. Enter parking time 3. Click Calculate | t = 6h01m | Price = 72$ |
| LT09 | Enter parking time 100h | 1. Access parking app 2. Enter parking time 3. Click Calculate | t = 100h | Price = 72$ |
| LT10 | Enter parking time below 168h | 1. Access parking app 2. Enter parking time 3. Click Calculate | t = 167h59m | Price = 72$ |
| LT11 | Enter parking time exactly 168h | 1. Access parking app 2. Enter parking time 3. Click Calculate | t = 168h | Price = 72$ |
| LT12 | Enter parking time above 168h | 1. Access parking app 2. Enter parking time 3. Click Calculate | t = 168h1m | error message or 74$ |
| LT13 |  |  |  |  |

## Create Contact

| Test Case ID | Test Summary / Scenario | Steps | Test Data | Expected Result |
|---|---|---|---|---|
| CC01 | Create contact with all mandatory fields and all optional fields completed | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | First name: Ana Last name: Popescu Date of birth: 1995-07-23 Email: john.doe@mail.com Phone: 0722333444 Street Address 1: StradaIndependentei10 Street Address 2: BlocApt5 City: Bucuresti12 State / Province: Ilfov Postal Code1: 123456 Country: Romania | contact is created |
| CC02 | Create contact with blank mandatory fields and all other valid | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | Enter first name blank/ all other valid Enter last name blank/ all other valid Enter email blank/ all other valid | contact is not created |
| CC03 | Create contact with all valid fields and first name having 1 character | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | first name: A | contact is created |
| CC04 | Create contact with all valid fields and first name having 15 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | first name: AnamariaPopescu | contact is created |
| CC05 | Create contact with all valid fields and first name having 16 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | first name: AnamariaPopescul | contact is not created |
| CC06 | Create contact with all valid fields and first name having alphanumeric characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | first name: Ana123 | contact is created |
| CC07 | Create contact with all valid fields and first name having numeric characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | first name: 1234567 | contact is created |
| CC08 | Create contact with all valid fields and first name having alphabetic characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | first name: Ana | contact is created |
| CC09 | Create contact with all valid fields and last name having 1 character | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | first name: P | contact is created |
| CC10 | Create contact with all valid fields and last name having 15 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | first name: AnamariaPopescu | contact is created |
| CC11 | Create contact with all valid fields and last name having 16 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | first name: AnamariaPopescul | contact is not created |
| CC12 | Create contact with all valid fields and last name having alphanumeric characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | first name: Popescu123 | contact is created |
| CC13 | Create contact with all valid fields and last name having numeric characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | first name: 1234567 | contact is created |
| CC14 | Create contact with all valid fields and last name having alphabetic characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | first name: Popescu | contact is created |
| CC15 | Create contact with all valid fields but DOB is empty | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button |  | contact is created |
| CC16 | Create contact with all valid fields and DOB has valid format | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 1995-07-23 00:00:00 | contact is created |
| CC17 | Create contact with all valid fields and DOB has valid format and valid date | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 1995-07-23 00:00:00 | contact is created |
| CC18 | Create contact with all valid fields but DOB has invalid format and invalid date | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 07-23-2027 | contact is not created |
| CC19 | Create contact with all valid fields but DOB has invalid format but valid date | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 07-23-1995 | contact is not created |
| CC20 | Create contact with all valid fields but DOB has alphabetic characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | abcd-ab-ac | contact is not created |
| CC21 | Create contact with all valid fields but DOB has spaces | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 1995 07 23 | contact is not created |
| CC22 | Create contact with all valid fields but DOB is incomplete | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 1995 07 | contact is not created |
| CC23 | Create contact with valid fields but already existing email | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | ana.popescu@gmail.com | contact is created |
| CC24 | Create contact with valid field but with an invalid email format | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | ana.gmail.com | contact is not created |
| CC25 | Create contact with valid fields but email has 26 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | anamaria.popescu@gmail.com | contact is not created |
| CC26 | Create contact with all valid fields but email has 24 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | ana123.popescu@gmail.com | contact is not created |
| CC27 | Create contact with all valid fields but email has 25 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | ana12.popescu@gmail.com | contact is created |
| CC28 | Create contact with all valid fields and blank phone number | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button |  | contact is created |
| CC29 | Create contact with all valid fields and 7 digits phone number | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 7223330 | contact is created |
| CC30 | Create contact with all valid fields and 11 digits phone number | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 72233344411 | contact is created |
| CC31 | Create contact with all valid fields but phone number has 6 digits | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 72233 | contact is not created |
| CC32 | Create contact with all valid fields but phone number has 12 digits | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 722333444011 | contact is not created |
| CC33 | Create contact with all valid fields but phone number contains alphabetic characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | abcdefghi | contact is not created |
| CC34 | Create contact with all valid fields but phone number contains spaces | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 722 333 44411 | contact is not created |
| CC35 | Create contact with all valid fields but phone number contains symbols | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 722!@#44411 | contact is not created |
| CC36 | Create contact with all valid fields and street address 1 is blank | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button |  | contact is created |
| CC37 | Create contact with all valid fields and street address 1 has 40 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | StradaIndependentei101Bucurestisectorul2 | contact is created |
| CC38 | Create contact with all valid fields and street address 1 has 39 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | StradaIndependentei11Bucurestisectorul2 | contact is not created |
| CC39 | Create contact with all valid fields and street address 1 has 41 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | StradaIndependentei1001Bucurestisectorul2 | contact is not created |
| CC40 | Create contact with all valid fields and street address 2 is blank | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button |  | contact is created |
| CC41 | Create contact with all valid fields and street address 2 has 40 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | StradaIndependentei101Bucurestisectorul2 | contact is created |
| CC42 | Create contact with all valid fields and street address 2 has 39 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | StradaIndependentei11Bucurestisectorul2 | contact is not created |
| CC43 | Create contact with all valid fields and street address 2 has 41 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | StradaIndependentei1001Bucurestisectorul2 | contact is not created |
| CC44 | Create contact with all valid fields and city is blank | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button |  | contact is created |
| CC45 | Create contact with all valid fields and city has 20 alphanumeric characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | Bucuresti0000000000 | contact is created |
| CC46 | Create contact with all valid fields and city has 21 alphanumeric characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | Bucuresti00000000001 | contact is not created |
| CC47 | Create contact with all valid fields but city has spaces | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | Bu cu resti | contact is not created |
| CC48 | Create contact with all valid fields but city has symbols | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | Bucuresti! | contact is not created |
| CC49 | Create contact with all valid fields and State or Province is blank | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button |  | contact is created |
| CC50 | Create contact with all valid fields and State or Province has 20 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | Romaniaromaniaromani | contact is created |
| CC51 | Create contact with all valid fields and State or Province has 19 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | Romaniaromaniaroman | contact is not created |
| CC52 | Create contact with all valid fields and State or Province has 21 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | Romaniaromaniaromania | contact is not created |
| CC53 | Create contact with all valid fields and Postal Code1 is blank | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button |  | contact is not created |
| CC54 | Create contact with all valid fields and Postal Code1 has 6 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 123456 | contact is created |
| CC55 | Create contact with all valid fields and Postal Code1 has 5 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 12345 | contact is not created |
| CC56 | Create contact with all valid fields and Postal Code1 has 7 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | 1234567 | contact is not created |
| CC57 | Create contact with all valid fields and Country is blank | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button |  | contact is created |
| CC58 | Create contact with all valid fields and Country has 20 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | Romaniaromaniaromani | contact is created |
| CC59 | Create contact with all valid fields and Country has 19 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | Romaniaromaniaroman | contact is not created |
| CC60 | Create contact with all valid fields and Country has 21 characters | 1. Access tool 2. Access Contact List 3. Click on Add button 4. Enter information req 5. Click on Submit Button | Romaniaromaniaromania | contact is not created |
| CC61 |  |  |  |  |