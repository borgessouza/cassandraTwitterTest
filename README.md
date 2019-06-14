# Cassandra Twitter

Projeto desenvolvido com integração ao banco de dados cassandra e twitter.



### Built With
* [Spring](https://spring.io/)  The Java Framework
* [Maven](https://maven.apache.org/) - Dependency Management

#### Authors

* **Cassiano Souza** - *Initial work* - [borgessouza](https://github.com/borgessouza)


### Prerequisites

* [Java 8](https://www.java.com)
* [Twitter Access Tokens](https://developer.twitter.com/en/docs/basics/authentication/guides/access-tokens.html)

### Executing 
```
mvn spring-boot:run
```

### API Documentation
***Search Tag***
----
* **URL:** twitter/tagSearch/{tag}

* **Method:** GET

*  **URL Params**
   <br>`tag=[String]`

* **Success Response:**
  * **Code:** 200 <br />

**Carregar Dados**
----
* **URL:** twitter/carregar

* **Method:** GET

* **Success Response:**
  * **Code:** 200 <br />
  
**Amostragem de Usuário por seguidores**
  ----
  * **URL:** twitter/user/tag
  
  * **Method:** GET
  
  * **Success Response:**
    * **Code:** 200 <br />
      **Content:** 
    ```json
    [
        {
        "userName": "marcelogfx",
        "followers": 261
        },
        {
        "userName": "Zaz91448252",
        "followers": 7
        },
        {
        "userName": "cactus24noticia",
        "followers": 18695
        },
        {
        "userName": "DomenicoMazzil5",
        "followers": 1814
        },
        {
        "userName": "Maelkan7",
        "followers": 1806
    }
    ]    
    ```
    
**Amostragem de Tags**
  ----
  * **URL:** twitter/lang
  
  * **Method:** GET
  
  * **Success Response:**
    * **Code:** 200 <br />
    **Content:** 
  ```json
      [
        {
          "total": "19",
          "tagName": "#brasil"
        },
        {
        "total": "5",
        "tagName": "#neymar"
        }
      ]  
 ```
       
**Amostragem de datas**
  ----
  * **URL:** twitter/data 
  
  * **Method:** GET
  
  * **Success Response:**
    * **Code:** 200 <br />
    **Content:** 
  ```json
    [
      {
          "total": "19",
          "tagName": "23"
      },
      {
          "total": "28",
          "tagName": "0"
      },
      {
          "total": "2",
          "tagName": "22"
      },
      {
          "total": "24",
          "tagName": "21"
      }
    ]
    
  ```