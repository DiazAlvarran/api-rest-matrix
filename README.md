# API REST MATRIZ

Se ha creado un api rest para manipular una matriz cuadrada y rotarla 90 grados

## Docker 🚀

Ejecutar el siguiente comando para ejecutarlo desde dockerhub.

docker run -it --rm -p 9000:9000 jorgevda/api-rest-interseguro:1.0


## Ejecutando las pruebas ⚙️

Si lo ejecuta desde su máquina local con el comando de docker, utilizar los siguientes datos con algún cliente rest:

url: localhost:9000/interseguro/api/rest/matrix/rotate

body (json): 

Ejemplo 1:
{
    "matrix": [
        [1, 2],
        [3, 4]
    ]
}

Ejemplo 2:
{
    "matrix": [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
}

## Construido con 🛠️

Spring Boot y programación reactiva (RxJava).

## Autores ✒️

* **Jorge Diaz**