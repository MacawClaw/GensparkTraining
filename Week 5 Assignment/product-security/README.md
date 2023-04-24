# Product REST API with a User Database and Spring Security & JWT

## By Omar Garcia

This is my REST API for use with a set of products. It can be used with a properly
configured database, port, and user privileges. This can be changed in application.properties,
otherwise the default will be Port 9080 and a database named 'productdb'.

## Getting Up and Running

### Step 1

If you starting the application for the first time, you will need to create a create a
user to use the API. Otherwise you can skip to Step 2. You can create a user in Postman by Posting to
http://localhost:9080/api/v1/auth/register in the JSON format. An example has been provided.

```
{
"firstname" : "Bruce",
"lastname" : "Wayne",
"email" : "bwayne@wayneindustries.com",
"password" : "GothamCity",
"role" : "ADMIN"
}
```

#### NOTE: For this API, you will get the most access by specifying the ADMIN role.

You can specify a role to use with the API. This API is configured for a USER
or ADMIN role. More can be added in the Role enum under SecurityPackageSuite.Entity
with access being configured through the ProductController. 

When posted, you get a token to use with the API, copy this and skip to Step 3.

### Step 2

Each time you run the API, you will need to get a new token. You can easily get one 
in Postman by Posting to http://localhost:9080/api/v1/auth/authenticate in the JSON
format. You only need the user email and password to log in. An example has been 
provided.

```
{
"email" : "bwayne@wayneindustries.com",
"password" : "GothamCity"
}
```

This will generate a new token to use the API. Copy this and move onto Step 3.
It will appear as such:

```
{
"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJid2F5bmVAd2F5bmVpbmR1c3RyaWVzLmNvbSIsImlhdCI6MTY4MjMwNDIxMSwiZXhwIjoxNjgyMzA1NjUxfQ.zR-lfE3U-896b0N6vr0hqQDlzurxtbI_pQ3RJxVFxHg"
}
```

### Step 3

Go to the Authorization tab for your Postman request. Select 'Bearer Token' under Type
and paste your generated token, this will allow you use all of the API methods IF you
an ADMIN. Otherwise you can only read the information.

## REST API Methods

Here are the links for basic CRUD operations where the Universal Product Number (UPC)
serves as an id. Product Objects also contain a Product Name, Manufacturer, Price,
and Description. #### NOTE: Prices are in BigDecimal for the purposes of financial math. 
Has no bearing on the entry of information, but important to note nonetheless.

http://localhost:9080/api/v1/products (for Create, Read, Update)

http://localhost:9080/api/v1/products/{upc} (for Read, Delete)

The UPC is autogenerated upon creation, so you can create new products as such:

```
{
"productName": "APEX 7 Mechanical Gaming Keyboard QX2 Clicky Switch",
"manufacturer": "SteelSeries",
"price": 159.99,
"description": "The Apex 7 keyboard has mechanical switches guaranteed for 50 million keypresses. Has Clicky switches."
}
```


You can also update products as such:

```
{
"upc" : 2,
"productName": "APEX 7 Mechanical Gaming Keyboard QX2 Blue Switch",
"manufacturer": "SteelSeries",
"price": 159.99,
"description": "The Apex 7 keyboard has mechanical switches guaranteed for 50 million keypresses. Has blue switches."
}
```