# Telepardaz
This application makes payment for merchants easy by creating links and QR codes to facilitate the process.

### List of used packages
1. The "core" and "javase" packages have been used to generate the QR code.

2. The jjwt package has been used to create links for each merchant.

3. Logs are stored in the Mongodb database.

4. The test database is h2 and packages h2 and assertj-core have been used.

### Requirements needed to devate the project
1. To run this application,simply copy the path of the exceptions_fa_IR.properties file and paste it in the RestExceptionHandler class.
2. To run this application,first you need to specify your username and password for connecting to the database in the application.yml file.

### API List:
| API name | Input Parameters | description |
|:--------------:|:-----------------:|:-----------------------------:|
| Create Merchant | MerchantDto/ | Creating a merchant (person or legal entity) and displaying its ID, name and link |
| Generate QRCode | QRCodeDto/ | Generating a QR Code for the desired merchant and printing the created QR code |
| Transfer | TransferDto/ | Deposit money to merchant account via bank or wallet |

