# Requirements Analysis – Contact List

## Original Requirements

On the Contact List page, users can view the list of added contacts and add a new contact using the **Add** button.

When adding a new contact, the following information is required:

| Field | Type | Length | Required |
|---|---|---|---|
| First Name | characters | 1–15 | Mandatory |
| Last Name | characters | 1–15 | Mandatory |
| Date of Birth | YYYY-MM-DD format | — | Optional |
| Email | — | max 25 | Mandatory |
| Phone | digits only | 7–11 digits | Optional |
| Street Address 1 | — | max 40 | Optional |
| Street Address 2 | — | max 40 | Optional |
| City | alphanumeric | max 20 | Optional |
| State or Province | — | max 20 | Optional |
| Postal Code | — | max 6 | Optional |
| Country | — | max 20 | Optional |

The **Cancel** button cancels the addition. The **Submit** button saves the contact. Once saved, the contact appears in the Contact List with: Name, Birthdate, Email, Phone, Address, City, State/Province, Postal Code, and Country.

An **Edit** button on each contact redirects to the Contact Details page where the user can view, edit, or delete the contact. The same validations apply when editing. Once edited, the updated details are visible in the Contact List. When deleting, a confirmation box appears: *"Are you sure you want to delete this contact?"* with **Yes** and **No** options.

---

## Test Scenarios

### Mandatory Fields

| Scenario | Expected Result |
|---|---|
| Create contact with all mandatory and all optional fields valid | Valid |
| Create contact with First Name blank, all optional blank | Invalid |
| Create contact with Last Name blank, all optional blank | Invalid |
| Create contact with Email blank, all optional blank | Invalid |
| Create contact with all mandatory fields blank, all optional valid | Invalid |
| Create contact with all mandatory fields valid, all optional blank | Valid |

---

### First Name (characters, 1–15 length, mandatory)

| Scenario | Expected Result |
|---|---|
| First Name has 1 character | Valid |
| First Name has 15 characters | Valid |
| First Name has 16 characters | Invalid |
| First Name has alphanumeric characters | Valid |
| First Name has numeric characters | Valid |
| First Name has alphabetic characters | Valid |

---

### Last Name (characters, 1–15 length, mandatory)

| Scenario | Expected Result |
|---|---|
| Last Name has 1 character | Valid |
| Last Name has 15 characters | Valid |
| Last Name has 16 characters | Invalid |
| Last Name has alphanumeric characters | Valid |
| Last Name has numeric characters | Valid |
| Last Name has alphabetic characters | Valid |

---

### Date of Birth (YYYY-MM-DD format, optional)

| Scenario | Expected Result |
|---|---|
| DOB is empty | Valid |
| DOB has valid format | Valid |
| DOB has valid format and valid date | Valid |
| DOB has invalid format (mm-dd-yyyy, dd-mm-yyyy, yyyy-dd-mm) and invalid date | Invalid |
| DOB has invalid format but valid date | Invalid |
| DOB has alphabetic characters | Invalid |
| DOB has spaces | Invalid |
| DOB is incomplete | Invalid |

---

### Email (max 25 characters, mandatory)

| Scenario | Expected Result |
|---|---|
| Email with already existing address | Valid *(requirement does not specify uniqueness)* |
| Email with invalid format (email, email@, email@email, email@email.) | Invalid |
| Email has 24 characters | Valid |
| Email has 25 characters | Valid |
| Email has 26 characters | Invalid |

---

### Phone (7–11 digits, optional)

| Scenario | Expected Result |
|---|---|
| Phone is blank | Valid |
| Phone has 7 digits | Valid |
| Phone has 11 digits | Valid |
| Phone has 6 digits | Invalid |
| Phone has 12 digits | Invalid |
| Phone contains alphabetic characters | Invalid |
| Phone contains spaces | Invalid |
| Phone contains symbols | Invalid |

---

### Street Address 1 (max 40 characters, optional)

| Scenario | Expected Result |
|---|---|
| Street Address 1 is blank | Valid |
| Street Address 1 has 39 characters | Valid |
| Street Address 1 has 40 characters | Valid |
| Street Address 1 has 41 characters | Invalid |

---

### Street Address 2 (max 40 characters, optional)

| Scenario | Expected Result |
|---|---|
| Street Address 2 is blank | Valid |
| Street Address 2 has 39 characters | Valid |
| Street Address 2 has 40 characters | Valid |
| Street Address 2 has 41 characters | Invalid |

---

### City (alphanumeric, max 20 characters, optional)

| Scenario | Expected Result |
|---|---|
| City is blank | Valid |
| City has 20 alphanumeric characters | Valid |
| City has 21 alphanumeric characters | Invalid |
| City has spaces | Invalid |
| City has symbols | Invalid |

---

### State or Province (max 20 characters, optional)

| Scenario | Expected Result |
|---|---|
| State or Province is blank | Valid |
| State or Province has 19 characters | Valid |
| State or Province has 20 characters | Valid |
| State or Province has 21 characters | Invalid |

---

### Postal Code (max 6 characters, optional)

| Scenario | Expected Result |
|---|---|
| Postal Code is blank | Valid |
| Postal Code has 5 characters | Valid |
| Postal Code has 6 characters | Valid |
| Postal Code has 7 characters | Invalid |

---

### Country (max 20 characters, optional)

| Scenario | Expected Result |
|---|---|
| Country is blank | Valid |
| Country has 19 characters | Valid |
| Country has 20 characters | Valid |
| Country has 21 characters | Invalid |

---

## Ambiguities / Clarifications Needed

### 1. First Name / Last Name
- What types of characters are allowed? Only alphabetic (A–Z, a–z)? Are diacritics allowed? Apostrophes or hyphens?
- Are spaces allowed (e.g. "Mary Jane")?
- What happens if the input exceeds 15 characters — truncate, reject, or show an error?
- Is case sensitivity relevant?

### 2. Date of Birth
- What is the valid date range (no future dates? no dates older than 150 years)?
- What happens if an invalid date is entered — is there UI validation or is it accepted silently?
- Should minimum/maximum age validation be applied?

### 3. Email
- Does the 25-character limit refer to the total length? Many real-world emails exceed 25 characters.
- Should email format validation be enforced (local-part@domain.tld)?
- Is the email address required to be unique?

### 4. City
- The requirement says "alphanumeric" — are spaces or hyphens allowed (e.g. "New York", "Saint-Denis")?

### 5. Cancel Button
- Does Cancel discard all entered data immediately, or does it prompt the user first?

### 6. Edit Validations
- The requirement states "the same validations apply" for editing — does this include mandatory field checks?
