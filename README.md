# Prueba Tecnica Springboot

## Extras
### De forma Personal Levante la Aplicacion para su realizar Pruebas y un Front pequeño para mas control
***URL Front*** : https://pt.luisvergara.dev
***URL OpenApi*** : https://ptb.luisvergara.dev/swagger-ui/index.html#/

## Ejecutar Aplicacion

### 1. Clonamos nuestro Repositorio 
```bash
git clone https://github.com/LuisVergara1/ptSpring.git
```
### 2. Configuracion de Variables
#### Buscamos las Variables de entorno en el archivo ***application.properties***

```bash
#URL de nuestra Base de Datos
spring.data.mongodb.uri=mongodb://usuario:contraseña@UrlBaseDatos:Puerto/BaseDeDatos?authSource=admin

# Configuración para NASA API
#API Key para acceder a la API
nasa.api.key=DEMO_KEY
#URL de la API de la NASA
nasa.api.url=https://api.nasa.gov/planetary/apod

#Variable WebConfig
cors.allowedOrigins = *

#URL Documentacion Swagger
url = https://ptb.luisvergara.dev
```

### 3. Ejecutamos nuestra Aplicacion


# EndPoint
El backend está accesible en el siguiente dominio público:
- **OpenApi** : [https://ptb.luisvergara.dev/swagger-ui/index.html#/](https://ptb.luisvergara.dev/swagger-ui/index.html#/)
- **URL API**: [https://ptb.luisvergara.dev/api/product](https://ptb.luisvergara.dev/api/product)

## Crear Productos
***URL*** : https://ptb.luisvergara.dev/api/product/create
```json
{
  "productId": "string",
  "name": "string",
  "description": "string",
  "price": 0,
  "stock": 0
}
```
### Si el Producto se Crea correctamente se recibirá un json 
##### codigo 200
![Correcto](https://github.com/user-attachments/assets/85b1bf74-2609-4af5-aa67-d6d42659ff72)

### Si el Producto no se puede Crear tendremos los errores obtenidos  
##### Codigo 400 
![Incorrecto](https://github.com/user-attachments/assets/c7b9e058-f8b1-4b2d-80d7-3f408c78c053)


### Si ingresamos un Codigo repetido
##### Codigo 400
![Repetido](https://github.com/user-attachments/assets/58bc4118-f328-46cc-aca9-f34292f5d731)

## Listar Productos
***URL*** : https://ptb.luisvergara.dev/api/product/all

### Si no existen Productos 
#### Codigo 400
![ListarFall](https://github.com/user-attachments/assets/797ed99b-7aa6-448f-9452-e2bb2526dba5)

### Si existen Productos
#### Codigo 200
![ListarOk](https://github.com/user-attachments/assets/67cfd104-a31f-40d0-9a96-d595dd636d0b)

## Actualizar Productos
***URL*** : https://ptb.luisvergara.dev/api/product/update/{productId}
```json
{
  "name": "string",
  "description": "string",
  "price": 0,
  "stock": 0
}
```
### Si el Id del Producto a modificar no existe
#### Codigo 400
![ModFall](https://github.com/user-attachments/assets/a59fd621-dd68-4e79-af93-3f7856509b4c)

### Si no se envian datos modificados 
#### Codigo 400
![ModnoExist](https://github.com/user-attachments/assets/ab99690d-0e53-453c-b19e-2703d73a158c)

### Si se modifica Correctamente
#### Codigo 200
![ModOk](https://github.com/user-attachments/assets/9d696b4f-45e0-4892-8246-21cbeb0ddc07)

## Listar 1 Producto
***URL*** : https://ptb.luisvergara.dev/api/product/find/{productId}
### Si existe el Producto
#### Codigo 200
![findOk](https://github.com/user-attachments/assets/c164e1ee-4dd7-4b02-a72c-030555bd1225)

### Si el Producto no existe
#### Codigo 400
![findFail](https://github.com/user-attachments/assets/5e7b3a71-ea92-449d-85a2-f71c86231838)

## Eliminar Productos
***URL*** : https://ptb.luisvergara.dev/api/product/delete/{productId}

### Si se elimina el Producto correctamente
#### Codigo 200
![DeleteOk](https://github.com/user-attachments/assets/73b0e57d-febb-4cb8-bed8-4f36d5f305f0)

### Si el Producto no existe
#### Codigo 400
![DeleteFall](https://github.com/user-attachments/assets/6fc5b541-d64e-4d65-80fd-ae60cf037a64)

## Api Externa
***URL*** : https://ptb.luisvergara.dev/api/nasa/apod

![ExternalApi](https://github.com/user-attachments/assets/0f9cdd0c-cafe-4d03-a911-92abf8866fa4)


# Docker

## Construir Imagen
### Crear un archivo DockerFile en el proyecto

```bash
# Utiliza una imagen base de Eclipse Temurin JRE 17
FROM eclipse-temurin:17-jre

# Copia el archivo JAR compilado al contenedor
COPY target/*.jar app.jar

# Expone el puerto en el que la aplicación se ejecuta
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

### Crear Contenedor 
```bash
docker build -t -t nombre-imagen:tag .
```
### Iniciar Contenedor
```bash
docker run -p 8080:8080 --name backend-container nombre-imagen:tag
```

# DockerCompose
### Inclui un archivo Docker Compose para levantar tanto la Api como la Base de Datos 
### El proyecto esta en mi dockerHub 
```bash
version: '3.8'

services:
  mongodb:
    image: mongo:4.4
    container_name: mongodb-container
    ports:
      - "27017:27017"
    environment:
      MONGO_INITDB_ROOT_USERNAME: admin
      MONGO_INITDB_ROOT_PASSWORD: admin123
    volumes:
      - mongo-data:/data/db

  app:
    image: lvergara1/pruebatecnica:v1
    container_name: app-container
    ports:
      - "8080:8080"
    environment:
      MONGODB_URI: mongodb://admin:admin123@mongodb:27017/BaseDatos?authSource=admin
      NASA_API_KEY: DEMO_KEY
      NASA_API_URL: https://api.nasa.gov/planetary/apod
      CORS_ALLOWED_ORIGINS: "*"
      DOC_SWAGGER: http://ptb.luisvergara.dev/swagger-ui.html
    depends_on:
      - mongodb
    networks:
      - app-network

volumes:
  mongo-data:

networks:
  app-network:
    driver: bridge

```

