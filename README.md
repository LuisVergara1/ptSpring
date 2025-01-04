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
- **Producción (VPS)**: [https://api.tudominio.com](https://api.tudominio.com)

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
