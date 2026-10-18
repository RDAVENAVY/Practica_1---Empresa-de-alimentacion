<p align="center">
PATTO | Empresa de alimentación
<p align="center">
  Gestión de empresa, clientes y empleados mediante XML
</p>

## Descripción
El proyecto consiste en gestionar la información de una empresa de alimentación, sus clientes y sus empleados.
La práctica reúne conceptos de programación orientada a objetos, organización del código mediante el patrón Modelo‑Vista‑Controlador (MVC) y persistencia de datos en archivos XML utilizando JAXB.
  
## Tecnologías utilizadas

| Tecnología | Uso en el proyecto |
|---|---|
| Java 17 | Lenguaje de programación |
| Maven | Configuración del proyecto y dependencias |
| XML | Almacenamiento de los datos |
| JAXB | Vinculación entre documentos XML y objetos Java |
| Git / GitHub | Control de versiones y colaboración |

## Organización del código

Las clases Java se encuentran en el paquete `com.trabajo` y distribuyen las responsabilidades de la aplicación:

| Clase o archivo | Responsabilidad |
|---|---|
| `Empresa.java` | Representa la empresa y contiene sus datos y colecciones de clientes y empleados. |
| `Cliente.java` | Define los atributos de un cliente. |
| `Empleado.java` | Define los atributos de un empleado. |
| `Manipulador.java` | Gestiona las operaciones sobre los datos almacenados en XML. |
| `Vista.java` | Presenta el menú y la información por consola, y recoge los datos introducidos. |
| `Controlador.java` | Coordina la interacción entre la vista y el modelo. |
| `Main.java` | Contiene el punto de entrada de la aplicación y pone en marcha sus componentes. |
| `proyecto.xml` | Archivo XML con los datos iniciales de la empresa, clientes y empleados. |
| `pom.xml` | Define la configuración de Maven y las dependencias. |

---

## Estructura del repositorio

```text
Practica_1---Empresa-de-alimentacion/
├── practica_1/
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/
│   │               └── trabajo/
│   │                   ├── Cliente.java
│   │                   ├── Controlador.java
│   │                   ├── Empleado.java
│   │                   ├── Empresa.java
│   │                   ├── Main.java
│   │                   ├── Manipulador.java
│   │                   └── Vista.java
│   ├── .gitignore
│   ├── pom.xml
│   └── proyecto.xml
└── README.md
```
                        
## Persistencia de datos
La información de la empresa se almacena en practica_1/proyecto.xml. Las clases del modelo representan los datos en Java y JAXB permite vincular esos objetos con la estructura XML.

## Trabajo colaborativo
El desarrollo se gestiona mediante Git y GitHub, utilizando ramas para organizar el trabajo y facilitar la integración de las distintas partes de la práctica.
