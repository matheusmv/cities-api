# cities-api

API Rest de consulta de cidades do Brasil

 - Spring Web
 - Spring Data JPA
 - PostgreSQL

### Obter todos os países registrados na base de dados

 - GET http://localhost:8080/countries?page=0&linesPerPage=24&direction=ASC&orderBy=portugueseName

    Parâmetros     | Opções
    ---------------|---------------
    page           | index
    linesPerPage   | quantidade de objetos
    direction      | ASC / DESC
    orderBy        | atributo do objeto

### Obter um país registrado na base de dados através do id

 - GET http://localhost:8080/countries/{id}

### Obter todos os estados registrados na base de dados

 - GET http://localhost:8080/states?page=0&linesPerPage=24&direction=ASC&orderBy=name

    Parâmetros     | Opções
    ---------------|---------------
    page           | index
    linesPerPage   | quantidade de objetos
    direction      | ASC / DESC
    orderBy        | atributo do objeto

### Obter um estado registrado na base de dados através do id

 - GET http://localhost:8080/states/{id}

### Obter todos as cidades registradas na base de dados

 - GET http://localhost:8080/cities?page=0&linesPerPage=24&direction=ASC&orderBy=name

    Parâmetros     | Opções
    ---------------|---------------
    page           | index
    linesPerPage   | quantidade de objetos
    direction      | ASC / DESC
    orderBy        | atributo do objeto

### Obter uma cidade registrada na base de dados através do id

 - GET http://localhost:8080/cities/{id}

### Obter a distância em metros entre duas cidades

 - GET http://localhost:8080/distances/by-cube?from={id}&to={id}

    Parâmetros     | Opções
    ---------------|---------------
    from           | {id}
    to             | {id}

### Obter a distância em milhas entre duas cidades

 - GET http://localhost:8080/distances/by-points?from={id}&to={id}

    Parâmetros     | Opções
    ---------------|---------------
    from           | {id}
    to             | {id}
