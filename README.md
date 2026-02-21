# Práctica: Estructura de Datos (Pila) + Ofuscación + Ingeniería Inversa

## 📌 Objetivo

En esta práctica se desarrollaron dos proyectos dentro del mismo
repositorio aplicando:

-   Gestión de dependencias con Maven
-   Creación e instalación de una librería local
-   Consumo de esa librería desde otro proyecto
-   Implementación manual de una estructura de datos (pila)
-   Validación de expresiones algebraicas
-   Ofuscación reproducible con perfil Maven
-   Ingeniería inversa de un JAR
-   Pruebas funcionales desde consola

------------------------------------------------------------------------

## 📁 Estructura del Repositorio

    /umg.edu.gt.data-structure.stack
    /stackHandler
    /evidencias
    README.md

-   **umg.edu.gt.data-structure.stack** → Librería con la implementación
    manual de la pila.
-   **stackHandler** → Proyecto que consume la librería.
-   **evidencias** → Capturas solicitadas y análisis.
-   **README.md** → Instrucciones de compilación y ejecución.

------------------------------------------------------------------------

## ⚙ Requisitos

-   Java 11
-   Maven 3.x
-   JD-GUI (para ingeniería inversa)

------------------------------------------------------------------------

# 🧱 Parte A -- Dependencia Maven

## 1️⃣ Compilar e instalar la librería

``` bash
cd umg.edu.gt.data-structure.stack/data-structure-stack
mvn clean package
mvn install
```

Esto instala la librería en el repositorio local (\~/.m2/repository).

------------------------------------------------------------------------

## 2️⃣ Compilar el proyecto handler

``` bash
cd stackHandler/stackHandler
mvn clean package
```

------------------------------------------------------------------------

# 🧠 Parte B -- Implementación Funcional

Se implementó manualmente una estructura de datos tipo **pila**, sin
usar `java.util.Stack`.

### Métodos implementados:

-   push
-   pop
-   peek
-   isEmpty
-   getCount
-   length
-   getNodeInit

### Casos de prueba obligatorios:

-   `(a+b) * [c-d]` → `true`
-   `([)]` → `false`

------------------------------------------------------------------------

## ▶ Ejecutar desde consola

``` bash
java -cp "target/stackHandler-1.0-SNAPSHOT.jar;RUTA_A_LA_LIBRERIA_EN_.m2" umg.edu.gt.handler.App
```

Con expresión personalizada:

``` bash
java -cp "target/stackHandler-1.0-SNAPSHOT.jar;RUTA_A_LA_LIBRERIA_EN_.m2" umg.edu.gt.handler.App "([)]"
```

------------------------------------------------------------------------

# 🔐 Parte C -- Ofuscación Reproducible

La ofuscación está configurada mediante un perfil Maven llamado:

    obfuscate

## Generar JAR normal y JAR ofuscado

### Librería:

``` bash
cd umg.edu.gt.data-structure.stack/data-structure-stack
mvn clean package -Pobfuscate
```

### Handler:

``` bash
cd stackHandler/stackHandler
mvn clean package -Pobfuscate
```

Cada proyecto genera:

-   JAR normal
-   JAR ofuscado (-obf.jar)

------------------------------------------------------------------------

# 🔎 Parte D -- Ingeniería Inversa

Se utilizó **JD-GUI** para decompilar el JAR ofuscado.

Resultados observados:

-   Los paquetes fueron renombrados (ejemplo: `A.A.A.A`)
-   Las clases fueron renombradas (ejemplo: `A`)
-   Se perdió claridad estructural
-   La lógica sigue siendo parcialmente comprensible

El análisis detallado se encuentra en:

    /evidencias/06_analisis.txt

------------------------------------------------------------------------

# 🧪 Parte E -- Prueba de Regresión

Se ejecutó el proyecto utilizando la librería ofuscada para confirmar
que el comportamiento no cambió:

``` bash
java -cp "target/stackHandler-1.0-SNAPSHOT.jar;RUTA_AL_JAR_OFUSCADO_LIBRERIA" umg.edu.gt.handler.App "([)]"
```

Resultado esperado:

    ([)] -> false

Se comprobó que el comportamiento del sistema permanece igual antes y
después de la ofuscación.

------------------------------------------------------------------------

## 🔎 Nota sobre la ejecución del JAR

Para la prueba de regresión se utilizó el comando `java -cp` en lugar de
`java -jar`, ya que el proyecto `stackHandler` depende de una librería
externa (`data-structure-stack`).

En Java, cuando un JAR depende de otro artefacto, es necesario incluir
la dependencia en el classpath. Por ello, la ejecución desde consola se
realizó de la siguiente manera:

``` bash
java -cp "target/stackHandler-1.0-SNAPSHOT.jar;RUTA_AL_JAR_OFUSCADO_LIBRERIA" umg.edu.gt.handler.App "([)]"
```

Este procedimiento cumple con el requisito de ejecución desde terminal y
confirma que el comportamiento del sistema no cambia antes y después de
la ofuscación.

------------------------------------------------------------------------

# 📸 Evidencias

La carpeta `/evidencias` contiene:

1.  JAR normal vs JAR ofuscado (handler)
2.  JAR normal vs JAR ofuscado (librería)
3.  Árbol del JAR ofuscado en JD-GUI
4.  Código decompilado del JAR ofuscado
5.  Prueba de regresión desde consola
6.  Análisis técnico escrito

------------------------------------------------------------------------

# ✅ Conclusión

Se logró:

-   Implementar una estructura de datos manual.
-   Integrar correctamente dos proyectos mediante Maven.
-   Configurar una ofuscación reproducible.
-   Realizar ingeniería inversa y analizar su impacto.
-   Validar que la ofuscación no alteró el comportamiento del sistema.
