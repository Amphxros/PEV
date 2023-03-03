package Common;

import java.util.Arrays;
import java.util.Collections;

public class Selection {

	public enum Type {
		Proporcional, MuestreoUniversalEstoclastico, Truncamiento, TorneoDeterministico, TorneoProbabilistico, Ranking,
		Restos
	}

	//Ruleta
	public static Individuo[] Proporcional(Individuo[] poblacion) {

		// Tamaño de la poblacion
		int size = poblacion.length;

		// Array nuevo con el resultado de seleccion
		Individuo[] seleccion = new Individuo[size];

		// Calcular el fitness total de todos los individuos para poder calcular el
		// fitness ponderado
		double totalFitness = 0;
		for (int i = 0; i < size; i++) {
			totalFitness += poblacion[i].fitness;
		}

		// Calculo probabilidad ponderada
		double probabilidadPonderada[] = new double[size];
		for (int i = 0; i < size; i++) {

			probabilidadPonderada[i] = poblacion[i].fitness/ totalFitness;
		}

		for (int i = 0; i < size; i++) {

			double r = Math.random();

			int c = 0;
			// Buscar el primer elemento del array de probabilidad que no sea mayor que el
			// valor
			// aleatorio
			while (r > probabilidadPonderada[c]) {

				r -= probabilidadPonderada[c];
				c++;
			}

			seleccion[i] = poblacion[c];
		}

		return seleccion;
	}

	public static Individuo[] MuestreoUniversalEstoclastico(Individuo[] poblacion) {

		// Tamaño de la poblacion

		int size = poblacion.length;

		// Array nuevo con el resultado de seleccion
		Individuo[] seleccion = new Individuo[size];

		double offset = 1 / size;

		double r = Math.random() * offset;

		for (int i = 0; i < size; i++) {

			double r2 = r + offset * i;

			int c = 0;
			// Buscar el primer elemento del array de fitness que no mayor que el valor
			// aleatorio
			while (r > poblacion[c].fitness) {

				r -= poblacion[c].fitness;
				c++;
			}

			seleccion[i] = poblacion[c];
		}

		return seleccion;
	}

	private static void quickSort(Individuo[] poblacion, int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(poblacion, begin, end);

			quickSort(poblacion, begin, partitionIndex - 1);
			quickSort(poblacion, partitionIndex + 1, end);
		}
	}

	private static int partition(Individuo[] poblacion, int begin, int end) {
		double pivot = poblacion[end].fitness;
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (poblacion[j].fitness <= pivot) {
				i++;

				Individuo swapTemp = poblacion[i];
				poblacion[i] = poblacion[j];
				poblacion[j] = swapTemp;
			}
		}

		Individuo swapTemp = poblacion[i + 1];
		poblacion[i + 1] = poblacion[end];
		poblacion[end] = swapTemp;

		return i + 1;
	}

	public static Individuo[] Truncamiento(Individuo[] poblacion) {

		float truncamiento = 20;

		Individuo[] ordenado = poblacion.clone();

		// Ordenar
		quickSort(ordenado, 0, ordenado.length);

		Individuo[] seleccion = new Individuo[poblacion.length];
		// Seleccionar el 20% superior 5 veces

		// En el caso de ser impares dejo al elemento del medio una unica vez

		int lastIdx = ordenado.length / 2;

		for (int i = 0; i < lastIdx; i++) {

			seleccion[2 * i] = ordenado[i];
			seleccion[2 * i + 1] = ordenado[i];

		}

		if (ordenado.length % 2 == 1) {

			seleccion[ordenado.length - 1] = ordenado[lastIdx];
		}

		return seleccion;
	}

	public static Individuo[] TorneoDeterministico(Individuo[] poblacion, int k) {

		int size = poblacion.length;

		Individuo[] seleccion = new Individuo[size];

		for (int i = 0; i < size; i++) {

			int[] muestra = new int[k];
			for (int c = 0; i < k; c++) {

				int idx = (int) Math.floor(Math.random() * size);
				muestra[c] = idx;
			}

			// Fase de seleccion
			int seleccionado = muestra[0];
			for (int c = 1; c < k; c++) {

				if (poblacion[muestra[c]].fitness > poblacion[seleccionado].fitness) {
					seleccionado = muestra[c];
				}
			}

			seleccion[i] = poblacion[seleccionado];

		}

		return seleccion;
	}

	public static Individuo[] TorneoProbabilistico(Individuo[] poblacion, int k, double p) {

		int size = poblacion.length;

		Individuo[] seleccion = new Individuo[size];

		for (int i = 0; i < size; i++) {

			int[] muestra = new int[k];
			for (int c = 0; i < k; c++) {

				int idx = (int) Math.floor(Math.random() * size);
				muestra[c] = idx;
			}

			// Fase de seleccion
			int seleccionado = muestra[0];

			if (Math.random() > p) {

				for (int c = 1; c < k; c++) {

					if (poblacion[muestra[c]].fitness > poblacion[seleccionado].fitness) {
						seleccionado = muestra[c];
					}
				}

			} else {

				for (int c = 1; c < k; c++) {

					if (poblacion[muestra[c]].fitness < poblacion[seleccionado].fitness) {
						seleccionado = muestra[c];
					}
				}
			}

			seleccion[i] = poblacion[seleccionado];

		}

		return seleccion;

	}

	public static Individuo[] Ranking(Individuo[] poblacion) {

		return null;
	}

	public static Individuo[] Restos(Individuo[] poblacion) {

		// Tamaño de la poblacion
		int size = poblacion.length;

		// Array nuevo con el resultado de seleccion
		Individuo[] seleccion = new Individuo[size];

		// Calcular el fitness total de todos los individuos para poder calcular el
		// fitness ponderado
		double totalFitness = 0;
		for (int i = 0; i < size; i++) {
			totalFitness += poblacion[i].fitness;
		}

		// Calculo probabilidad ponderada
		double probabilidadPonderada[] = new double[size];
		for (int i = 0; i < size; i++) {

			probabilidadPonderada[i] = poblacion[i].fitness / totalFitness;
		}

		int idx = 0;

		for (int i = 0; i < size; i++) {
			if (probabilidadPonderada[i] * size > 1) {

				seleccion[idx++] = poblacion[i];
			}
		}

		Individuo[] ruleta = Proporcional(poblacion);
		
		for(int i = idx; i < size; i++) {
			
			seleccion[i] = ruleta[i];
		}
		
		
		return seleccion;
	}

}
