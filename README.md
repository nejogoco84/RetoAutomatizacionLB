# Restapiexample

Automatización de pruebas con Serenity Rest para probar los servicios expuestos en http://dummy.restapiexample.com/

Esta automatización consta de 4 escenarios de pruebas, con los cuales se realizan validaciones a las operaciones expuestas (Get, Get con parametro, delete y post)

# Herramientas utilizadas.

•    Java JDK 1.8
•    Gherkin
•    Cucumber
•    Gradle
•    Serenity BDD
•    Serenity Rest

# Ejecución:

Ejecute las siguientes tareas en la raíz del proyecto principal a través del símbolo del sistema:

gradle clean test aggregate -info

El reporte se podra ver en:

target/site/serenity/index.html

Autor

Néstor González Contreras