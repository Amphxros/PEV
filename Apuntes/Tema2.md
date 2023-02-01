###  Tema 2 AGs: Estructura y componentes básicos
### Indice 
* Definición
* Esquema general
* Representación
    * Individuos
    * Población
* Función de evaluación
* Estructura y notación del AGS
* Operadores básicos:
    * Selección
    * Reproducción
    * Reemplazo



## Definicion
**Los Algoritmos Genéticos ocupan un lugar central en la Computación Evolutiva**
-  **Completos**: reunen las ideas fundamentales de la Computación Evolutiva.
- **Flexibles**: pueden adoptar con facilidad nuevas técnicas y combinarse con otros métodos.
- **Generales** no requieren conocimiento específico sobre la aplicación y pueden incorporar conocimiento específico con facilidad.
**Implementación sencilla.**
**Muy utilizados.**

Los AGs tradicionales son métodos de búsqueda:
 -Ciega: no disponen de ningún conocimiento específico del problema, de manera
que la búsqueda se basa exclusivamente en los valores de la función objetivo.
-  Codificada: no trabajan directamente sobre el dominio del problema, sino sobre
representaciones de sus elementos.
-  Múltiple: procesan simultáneamente un conjunto de candidatos.
- Estocástica referida tanto a las fases de selección como a las de transformación.
```java
t=0;
//Generar poblacion inicial(P(t));
//Evaluar población(P(t));
while (t<Num_max_gen) y no CondTermina() {
t++;
Poblacion(t) = Selección(P(t-1));
Reproducción(P(t));
Mutacion(P(t));
Evaluar_población(P(t));
}`
```
## Esquema General
## Representacion
### Individuos
### Poblacion
## Funcion de evaluacion
## Estructura y notacion del AGS
## Operadores basicos
