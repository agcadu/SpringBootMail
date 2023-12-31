![Encabezado del Proyecto](./header.png)

# SpringBootMail

## Descripción

SpringBootMail es una aplicación construida con Java 17, Spring Boot 3 y Maven. Esta aplicación permite enviar correos electrónicos a través de dos métodos POST distintos, uno de ellos con la capacidad de adjuntar archivos.

## Beneficios

1. **Automatización de envíos:** Permite integrarse con otros sistemas para enviar correos de forma automatizada.
2. **Flexibilidad:** Provee dos métodos diferentes de enviar correos (JSON y form-data) para adaptarse a diversas necesidades.
3. **Adjunto de archivos:** Facilita el envío de correos con archivos adjuntos.
4. **Dockerización:** La aplicación está dockerizada, lo que facilita su despliegue y garantiza que funcione en cualquier entorno que soporte Docker.
5. **Seguridad:** Al usar las prácticas recomendadas, se garantiza la seguridad de la información de acceso al correo.

## Endpoints

1. **Enviar correo con JSON:**
    - URL: http://localhost:8080/v1/sendMail
    - Método: POST
    - Parámetros:
        - `toUser`: Correo del destinatario
        - `subject`: Asunto del correo
        - `message`: Mensaje del correo

2. **Enviar correo con archivo adjunto (form-data):**
    - URL: http://localhost:8080/v1/sendMailFile
    - Método: POST
    - Parámetros:
        - `toUser`: Correo del destinatario
        - `subject`: Asunto del correo
        - `message`: Mensaje del correo
        - `file`: Archivo adjunto

## Requisitos

1. Java 17 instalado.
2. Docker y Docker Compose instalados.
3. Una cuenta de Gmail.
4. Contraseña de aplicación generada para Gmail (instrucciones a continuación).

### Generar una contraseña segura para una aplicación en Gmail

Para mantener tu cuenta segura cuando accedes a través de aplicaciones de terceros, es recomendable generar una contraseña específica de la aplicación:

1. Ve a tu cuenta de [Google](https://myaccount.google.com/).
2. En la sección de "Seguridad", busca "Contraseñas de aplicaciones".
3. Haz clic en "Contraseñas de aplicaciones".
4. En la parte inferior, elige la aplicación (Otra) pon el nombre "Spring Boot App" y haz clic en "Generar".
5. Copia la contraseña de 16 caracteres en el lugar donde la necesitas.
6. Haz clic en "Listo".

## Pasos para iniciar la aplicación con Docker

1. **Clonar el repositorio:**
   ```
   git clone https://github.com/agcadu/SpringBootMail.git
   ```

2. **Navegar al directorio:**
   ```
   cd SpringBootMail
   ```

3. **Configurar las variables de entorno:** Modifica el archivo `docker-compose.yml` y actualiza las variables `EMAIL_SENDER` y `EMAIL_PASSWORD` con tu correo de Gmail y la contraseña de aplicación generada.

4. **Iniciar el contenedor:**
   ```
   docker compose up
   ```

5. Una vez que el contenedor esté corriendo, la aplicación estará disponible en `http://localhost:8080/`.

## Colección Postman

Para probar la aplicación, se proporciona una colección Postman: `ApplicationEmail.postman_collection.json`. Importa esta colección en Postman y introduce los emails de los destinatarios para comenzar a realizar pruebas.

---

