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
Evaluar_población(P(t));
}
```
## Esquema General

![image](https://user-images.githubusercontent.com/37449976/217542258-1a6412aa-1ba1-43aa-ae17-9b9fa3c72a56.png)




## Representacion

* Individuos o cromosomas: son las soluciones candidatas codificadas
originalmente como cadenas de bits.

![image](https://user-images.githubusercontent.com/37449976/217577972-d1336c9e-a957-4c6e-be62-10a94ccc022a.png)

* Los cromosomas contienen genes que, normalmente, se encuentran en posiciones
fijas (*locus*) y tienen un determinado valor (*alelo*). 

Un <u>gen</u> es una subsección de un *cromosoma* que (usualmente) codifica el valor de
un parámetro.

![image](https://user-images.githubusercontent.com/37449976/217542848-6bf57a5a-161f-4d00-a0d8-dc357083291d.png)

**<u>Genotipo:</u>** codificación (p.ej, binaria) de los parámetros que representan una solución del problema a resolver.

**<u>Fenotipo:</u>** es la decodificación del cromosoma: el valor obtenido al pasar de la
representación binaria a la usada por la función objetivo

![image](https://user-images.githubusercontent.com/37449976/217578455-f3f69863-3e25-46dd-afc2-4b9f4ab74d83.png)

## Elementos básicos
![image](https://user-images.githubusercontent.com/37449976/217579409-6e2bfaf8-51e4-45b6-af92-8b67729714af.png)

* Individuos: Se denomina individuo a un solo miembro de la población de soluciones potenciales a un problema. Cada individuo es un cromosoma que representa una solución posible al problema a resolver.
* Poblacion: Conjunto de todos los individuos. Normalmente tiene un tamaño fijo y puede tener individuos repetidos

## Funcion de evaluacion *(fitness)*
El <u>fitness</u> es un valor de idoneidad o calidad que se obtiene para cada individuo (es la base para los mecanismos de selección). Puede buscarse la <u>maximización</u> o <u>minimización</u> *fitness*.

## Estructura y notacion del AGS
* **Esquema general**
![image](https://user-images.githubusercontent.com/37449976/217581983-0c78e345-1009-4265-bb2b-b88abbeb4b51.png)

* **Codificacion**
    * Cada individuo consta de m posiciones que son ocupadas por atributos o genes.
    * Los genes se codifican en L= L1+ ….. Lm bits.
    * Si un atributo puede tomar más de dos valores se deberá representar mediante varios bits.
    * Si el j-ésimo gen consta de ***aj*** alelos, entonces se deberá codificar mediante ***Lj= log 2 aj*** bits



**Notacion:**
![image](https://user-images.githubusercontent.com/37449976/217581693-f8be6171-05f4-4782-9a3a-6f36abf62c47.png)


## Operadores basicos
