# Challenge Conversor de Monedas

Este proyecto es una aplicación de consola en Java que permite convertir montos monetarios a distintas monedas. La aplicación interactúa con una API externa para obtener las tasas de cambio en tiempo real y realizar conversiones precisas.

### 📌 Características

- Conversión de USD a algunas monedas latinoamericanas y viceversa.
- Manejo de errores en la entrada de datos.
- Obtención dinámica de tasas de cambio mediante consulta a una API REST.
- Interfaz sencilla en consola con menú interactivo.
- Resultados mostrados con formato y redondeo apropiado.

### 🖥️ Tecnologías utilizadas

**Java:** Lenguaje de programación orientado a objetos, robusto y ampliamente utilizado para aplicaciones de escritorio y servidor.

**Biblioteca Gson:** Biblioteca de Google para convertir objetos Java a JSON y viceversa, facilitando el manejo de datos recibidos de APIs REST.

**API ExchangeRate-API**: Servicio web que proporciona tasas de cambio actualizadas y confiables mediante endpoints REST.

### 📜 Instalación y uso

Clona el repositorio desde la consola:

```
git clone https://github.com/lisaforero/challengeConversorMonedas.git
```

Después de clonar el repositorio, navega hasta la carpeta del proyecto:

```
cd challengeConversorMonedas
```

Abre el proyecto por ejemplo en IntelliJ IDEA e importa la biblioteca Gson:

Ve a la página oficial de Gson en Maven Central (https://search.maven.org/artifact/com.google.code.gson/gson), descarga por ejemplo la versión ```gson-2.13.1.jar```, ahora para importar la biblioteca sigue estos pasos:
- Haz clic derecho sobre la carpeta del proyecto en el panel izquierdo.
- Selecciona "Project Structure" del menú.
- En la ventana que se abre, en "Modules", ve a la pestaña "Dependencies".
- Haz clic en el signo "+" en la esquina inferior izquierda y elige "JARS or Directories".
- Busca el archivo JAR donde lo hayas guardado después de su descarga, en el cuadro de búsqueda.
- Selecciona el archivo JAR que desees utilizar.
- Haz clic en "OK" para cerrar la ventana.

Ahora ejecuta la clase principal `ConversorMoneda` que contiene el método main() y abre el menú interactivo en la consola.

### 🌐 API de tasas de cambio

Este proyecto utiliza la API de ExchangeRate-API (https://www.exchangerate-api.com/) para obtener las tasas de cambio actualizadas.

La consulta se realiza a endpoints del tipo:

```https://v6.exchangerate-api.com/v6/YOUR_API_KEY/latest/USD```

(donde YOUR_API_KEY es la clave que obtienes al registrarte gratis en el servicio).

### 🛠 Personalización

- Puedes agregar más monedas modificando el menú y llamando al método `convertirMoneda` con los códigos ISO correspondientes.
- Para mayor precisión en el manejo de valores monetarios, se recomienda usar la clase BigDecimal.
