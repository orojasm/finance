# Control de versiones del proyecto

## 1. Definiciones

### 1.1.  Estrategia de Ramificación - **Gitflow**

* La rama ***master*** siempre tiene que estar estable.
* En la rama ***develop*** se acumunlas los cambios que todad via no van a producción.
* Para cada nueva característica o funcionalidad se debe crear una rama nueva desde ***develop***, esta rama se nombrara así como ***feat/<name_feature***> y una vez completada la tarea se hace merge con la rama ***develop***.
* Las ramas de lanzamiento o **release** se crean a partir de la rama de ***develop***, cuando se considera que las características están listas para su lanzamiento.
* Revisión de código antes de integrar con el código principal.
* Utilización de ***Pull requests*** para revisar y aprobar los cambios antes de la integración
* Integración continua ***CI*** con el código principal, con la posibilidad de realizar múltiples integraciones al día.
* Uso de versiones etiquetadas para identificar versiones estables y de producción.
* Para los Hotfix se crean ramas desde ***main*** y se vuelve a hacer merge a la rama ***main*** cuando se haya realizado la corrección.

## 1.2. Semantic version

## 2.1. Inicializando Git

``` bash
git config --global user.name orojas
git config --global user.email orojas.molina@gmail.com 
git config --global branch -M main

git init
git add .
git commit -m "Add initial files"

git branch -M main
git remote add origin https://ghp_oJiCToLpbIkCQ5ODWOxPcjLqurSbOc0x@github.com/orojasm/finance.git
git push -u origin main
git switch -c develop
git push origin develop

```

## 2.2. Implementación de una ***feature***

### 2.2.1. Feature Initialization

Definimos la rama en LOCAL

``` shell
git switch develop
git switch -c feat/config
```

### 2.2.2. Making the changes

Se crean nuevos artefactos y se modifican algumos de los existente, debemos 
realizar commits de acuerdo al avance de la implementacion. Una ves terminamos 
la facilida o caracteristica, debemos realizamos el ultimo commit.

``` shell
git add .
git commit
```

### 2.2.3. Aplicar el cambio a la rama ***develop***

* ***Push feature***: En `local`, Subimos la rama feature a Github

``` shell
git push origin feat/config
```

* ***Pull Request a develop***: En `GitHub` Solicitamos el Pull request para 
hacer merge con la rama develop

* ***Aceptamos el Pull request***: En `GitHub` Revicamos el codigo y aceptamos 
el Pull request y una vez aplicado el cambio borramos la rama feature.

* ***Pull de la rama develop***: En `Local` descargamos la rama develop y 
procedemos a borrar la rama feature de local.

``` shell
git switch develop
git pull origin develop
git branch -d feat/config
```