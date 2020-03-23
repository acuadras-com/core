TuTendero API

Context Path : tutendero
port: 9072
version: 1.0

Important : Put the version in the requestMapping url of the rest controller.

Auth

1.  Description: It must validate user and password, it they are right return a jwt token.

HTTP Method: POST /login
Description: Return a list of merchants near(2kms around) to the user.
Request URL: http://localhost:9072/tutendero/auth/login
Request Headers:
{
  "Accept": "*/*" 
}

Request Body:
{
  email: String,
  password: String
 }

Response Body:
{
  token:String
 }

2.  Description: It must validate user and password, it they are right return a jwt token.

HTTP Method: POST /logout
Description: Decline token auth and return redirect
Request URL: http://localhost:9072/tutendero/auth/login
Request Headers:
{
  "Accept": "*/*",
  "JWT-TOKEN: "String",
  "USER-ID: "UUID"
}

Response Header: http code 203 

Resource: Merchant

1. HTTP Method: GET /merchant/
Description: Return a list of merchants near(2kms around) to the user.
Request URL: http://localhost:9072/tutendero/merchant/
Request Headers:
{
  "Accept": "*/*",
  "JWT-TOKEN: "String",
  "USER-ID: "UUID"
}

Response Body:
{
  merchants: [
    {
      id: UUID (String),
      name: String,
      telephone: String,
      photo: String,
      categories: [
        String
      ]
    }
  ]
}


2. HTTP Method: GET /merchant/{id}
Description: Return the specific merchant of the id param
Request URL: http://localhost:9072/tutendero/merchant/{id}
Request Headers:
{
  "Accept": "*/*",
  "JWT-TOKEN: "String",
  "USER-ID: "UUID"
}

Response Body:
{
  id: UUID (String),
  name: String,
  telephone: String,
  photo: String,
  categories: [
    String
  ]
}

3. HTTP Method: GET /merchant?category=panaderia
Description: Return a list of merchants near(2kms around) to the user that are clasified within the category asked.
Request URL: http://localhost:9072/tutendero/merchant?category=param
Request Headers:
{
  "Accept": "*/*",
  "JWT-TOKEN: "String",
  "USER-ID: "UUID"
}

Response Body:
{
  merchants: [
    {
      id: UUID (String),
      name: String,
      telephone: String,
      photo: String,
      categories: [
        String
      ]
    }
  ]
}

3. HTTP Method: GET /merchant?category=panaderia
Description: Return a list of merchants near(2kms around) to the user that are clasified within the category asked.
Request URL: http://localhost:9072/tutendero/merchant?category=param
Request Headers:
{
  "Accept": "*/*",
  "JWT-TOKEN: "String",
  "USER-ID: "UUID"
}

Response Body:
{
  merchants: [
    {
      id: UUID (String),
      name: String,
      telephone: String,
      photo: String,
      categories: [
        String
      ]
    }
  ]
}

4. HTTP Method: GET /merchant?search=merchantName
Description: Return a list of merchants near(2kms around) to the user that correspond to the merchanName.
Request URL: http://localhost:9072/tutendero/merchant?search=merchantName
Request Headers:
{
  "Accept": "*/*",
  "JWT-TOKEN: "String",
  "USER-ID: "UUID"
}

Response Body:
{
  merchants: [
    {
      id: UUID (String),
      name: String,
      telephone: String,
      photo: String,
      categories: [
        String
      ]
    }
  ]
}

5. HTTP Method: POST /merchant
Description: Create new merchant, return the created merchant
Request URL: http://localhost:9072/tutendero/merchant
Request Headers:
{
  "Accept": "*/*",
  "JWT-TOKEN: "String",
  "USER-ID: "UUID"
}

Request Body:
{     
      email: String,
      password: String,
      name: String,
      telephone: String,
      photo: String,
      categories: [
        String
      ]
}

Response Body:
{
  id: UUID (String),
  name: String,
  telephone: String,
  photo: String,
  categories: [
    String
  ]
}

6. HTTP Method: PUT /merchant
Description: Modify existing merchant, return the modified merchant
Request URL: http://localhost:9072/tutendero/merchant
Request Headers:
{
  "Accept": "*/*",
  "JWT-TOKEN: "String",
  "USER-ID: "UUID"
}

Request Body:
{    id: UUID (String),
      name: String,
      telephone: String,
      photo: String,
      categories: [
        String
      ]
}

Response Body:
{
  id: UUID (String),
  name: String,
  telephone: String,
  photo: String,
  categories: [
    String
  ]
}


