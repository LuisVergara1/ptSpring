# Prueba Tecnica Springboot

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


## EndPoint
El backend está accesible en el siguiente dominio público:
- **OpenApi** : [https://ptb.luisvergara.dev/swagger-ui/index.html#/](https://ptb.luisvergara.dev/swagger-ui/index.html#/)
- **URL API**: [https://ptb.luisvergara.dev/api/product](https://ptb.luisvergara.dev/api/product)

### Crear Productos
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
#### Si el Producto se Crea correctamente se resivira un json con el codigo 200
![Correcto](https://github.com/user-attachments/assets/85b1bf74-2609-4af5-aa67-d6d42659ff72)

#### Si el Producto no se puede Crear Tendremos un Codigo 400 junto los errores obtenidos
![Incorrecto](https://github.com/user-attachments/assets/c7b9e058-f8b1-4b2d-80d7-3f408c78c053)


### Si ingresamos un Codigo repetido Obtendremos un Codigo 400
![Repetido](https://github.com/user-attachments/assets/58bc4118-f328-46cc-aca9-f34292f5d731)

### Listar Productos
***URL*** : https://ptb.luisvergara.dev/api/product/all

#### Si no existen Productos Tendremos un Codigo 400
![ListarFall](https://github.com/user-attachments/assets/797ed99b-7aa6-448f-9452-e2bb2526dba5)

### Si existen Productos
![ListarOk](https://github.com/user-attachments/assets/67cfd104-a31f-40d0-9a96-d595dd636d0b)



