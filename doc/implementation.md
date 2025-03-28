# 1. Configuración inicial del proyecto

## 1.1. Crear un proyecto Spring Boot

Primero vamos a crear el proyecto, para esto nos ubicamos en un navegador de internet, luego procedemos a ir a 
la página [Spring Initializr](https://start.spring.io/).

## 1.2. Configurar el proyecto:

Una vez en el formulario, debemos diligenciar la siguiente información:

  * Project: ***Maven***
  * Language: ***Java***
  * Spring Boot: ***3.4.3*** 
  * Project Metadata: 

    | Clave        | Valor                                                               |
    |--------------|---------------------------------------------------------------------|
    | Group        | com.orojas                                                          |
    | Artifact     | finance                                                             |
    | Name         | finance                                                             |
    | Description  | Rest API for managing a small personal financial information system |
    | Package name | com.orojas.finance                                                  |
    | Packaging    | Jar                                                                 |
    | Java         | 17                                                                  |

## 1.3. Agregue las siguientes dependencias:

* Spring Web            Version: 3.4.3
* Spring Security       Version: 3.4.3
* Spring Data JPA       Version: 3.4.3
* MySQL Driver          Version: 9.1.0
* Validation            Version: 3.4.3
* Lombok                Version: 1.18.36
* Spring Boot DevTools  Version: 3.4.3

A continuación podemos ver la imagen de ***Spring Initializr*** ya diligenciada:

<img alt="Spring Initializr" src="./img/creacion_proyecto.png" title="Spring Initializr" width="78%"/>

## 1.4. Descargar


Haz clic en el botón `GENERATE` para descargar el proyecto, el cual está ubicado en la parte inferior del formulario, 
extraer el archivo ***zip*** y abrirlo en tu IDE.

***Spring Initializr*** te ayuda a generar un proyecto ***Spring Boot*** pre-configurado con todas las dependencias 
necesarias, para que no tengas que configurarlas manualmente. Este paso simplifica el proceso de configuración y 
te permite empezar a programar más rápido.

## 1.5. Control de versiones

Configuración inicial de un repositorio local de Git.

``` bash
git init
git add .
git commit -m "Add initial files"
git switch -c develop
git switch -c feat/config
```

# 2. Configuración

## 2.1. Deshabilitar Spring Security

Deshabilitamos Spring Security para permitir el desarrollo de las primeras funciones, logramos esto comentando 
la dependencia en el archivo ***pom.xml***.

Y finalmente sincronizamos los cambios en Maven

``` xml
<!--		TODO  **ORM**  We disabled Spring Security to allow development of the first features. -->
<!--		<dependency>-->
<!--			<groupId>org.springframework.boot</groupId>-->
<!--			<artifactId>spring-boot-starter-security</artifactId>-->
<!--		</dependency>-->
```
## 2.2. Instalación de MapStruct

Instalamos ***MapStruct*** adicionando la dependencia en el archivo pom.xml, ya que ***MapStruct*** y 
***Lombok*** tienen conflictos debemos tener especial cuidado con sus versiones. Y finalmente sincronizamos 
los cambios en Maven.

A continuación los cambios en el archivo ***pom.xml***.

``` xml
    <properties>
        <java.version>17</java.version>
        <org.mapstruct.version>1.6.3</org.mapstruct.version>
        <org.lombok.version>1.18.32</org.lombok.version>
        <org.lombok-mapstruct-binding.version>0.2.0</org.lombok-mapstruct-binding.version>
    </properties>
```

``` xml
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>${org.lombok.version}</version>
        <scope>provided</scope>
    </dependency>
    
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>${org.mapstruct.version}</version>
    </dependency>
```

``` xml
                <annotationProcessorPaths>
                    <path>
                        <groupId>org.projectlombok</groupId>
                        <artifactId>lombok</artifactId>
                        <version>${org.lombok.version}</version>
                    </path>
                
                    <path>
                        <groupId>org.mapstruct</groupId>
                        <artifactId>mapstruct-processor</artifactId>
                        <version>${org.mapstruct.version}</version>
                    </path>
                
                    <path>
                        <groupId>org.projectlombok</groupId>
                        <artifactId>lombok-mapstruct-binding</artifactId>
                        <version>${org.lombok-mapstruct-binding.version}</version>
                    </path>
                </annotationProcessorPaths>
```
