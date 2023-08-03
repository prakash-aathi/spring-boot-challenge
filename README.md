# spring-boot-challenge-1

## how to run

1, clone these repo 
```
git clone https://github.com/prakash-aathi/spring-boot-challenge.git
```
2, Open a terminal and navigate to the project root directory

 3, Build the project
```
mvn clean install
```
4,run the application
```
mvn spring-boot:run 
```

## Api enpoints

### Add a New Item
- **URL**: `/api/v1/items`
- **HTTP Method**: POST
- **Request Body**:
```
{
 "name": "laptop",
 "description": "on the self"
}
```
- Response: HTTP 201 Created

### get a intem by id
- **URL**: `/api/v1/items/{id}`
- **HTTP Method**: GET
- Response: HTTP 200 OK with JSON or HTTP 404 Not Found
  ```
  {
  "id": 1,
  "name": "laptop",
  "description": "on self"
  }
  ```
