package Common;

public class Selection {

	public enum Type {
		Proporcional, MuestreoUniversalEstoclastico, Truncamiento, TorneoDeterministico, TorneoProbabilistico, Ranking, Restos
	}

	public static Individuo[] Proporcional(Individuo[] poblacion, double[] fitness) {

		// Tamaño de la poblacion
		int size = poblacion.length;

		// Array nuevo con el resultado de seleccion
		Individuo[] seleccion = new Individuo[size];

		// Calcular el fitness total de todos los individuos para poder calcular el
		// fitness ponderado
		double totalFitness = 0;
		for (int i = 0; i < size; i++) {
			totalFitness += fitness[i];
		}

		// Calculo probabilidad ponderada
		double probabilidadPonderada[] = new double[size];
		for (int i = 0; i < size; i++) {

			probabilidadPonderada[i] = fitness[i] / totalFitness;
		}

		for (int i = 0; i < size; i++) {

			double r = Math.random();

			int c = 0;
			// Buscar el primer elemento del array de fitness que no mayor que el valor
			// aleatorio
			while (r > fitness[c]) {

				r -= fitness[c];
				c++;
			}

			seleccion[i] = poblacion[c];
		}

		return seleccion;
	}

	public static Individuo[] MuestreoUniversalEstoclastico(Individuo[] poblacion, double[] fitness) {

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
			while (r > fitness[c]) {

				r -= fitness[c];
				c++;
			}

			seleccion[i] = poblacion[c];
		}

		return seleccion;
	}

	public static Individuo[] Truncamiento(Individuo[] poblacion, double[] fitness) {

		return null;
	}

	public static Individuo[] TorneoDeterministico(Individuo[] poblacion, double[] fitness, int k) {

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

				if (fitness[muestra[c]] > fitness[seleccionado]) {
					seleccionado = muestra[c];
				}
			}

			seleccion[i] = poblacion[seleccionado];

		}

		return seleccion;
	}

	public static Individuo[] TorneoProbabilistico(Individuo[] poblacion, double[] fitness, int k, double p) {

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

					if (fitness[muestra[c]] > fitness[seleccionado]) {
						seleccionado = muestra[c];
					}
				}

			} else {

				for (int c = 1; c < k; c++) {

					if (fitness[muestra[c]] < fitness[seleccionado]) {
						seleccionado = muestra[c];
					}
				}
			}

			seleccion[i] = poblacion[seleccionado];

		}

		return seleccion;

	}

	public static Individuo[] Ranking(Individuo[] poblacion, double[] fitness) {

		return null;
	}

	public static Individuo[] Restos(Individuo[] poblacion, double[] fitness) {

		return null;
	}

}
