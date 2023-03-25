package Common;

public class Selection {
	public enum Type {
		Proporcional,
		MuestreoUniversalEstoclastico,
		Truncamiento,
		TorneoDeterministico,
		TorneoProbabilistico,
		Ranking,
		Restos
	}
	
	
	static double[] ProbabilidadPonderada(Cromosoma[] poblacion) {
		int size = poblacion.length;
		double totalFitness = 0;
		for (int i = 0; i < size; i++) {
			totalFitness += poblacion[i].getFitness();
		}

		// Calculo probabilidad ponderada
		double probabilidadPonderada[] = new double[size];
		for (int i = 0; i < size; i++) {

			probabilidadPonderada[i] = poblacion[i].getFitness()/ totalFitness;
		}
		
		return probabilidadPonderada;
	}
	
	//Ruleta
	public static Cromosoma[] Proporcional(Cromosoma[] poblacion) {

		// Tamaño de la poblacion
		int size = poblacion.length;

		// Array nuevo con el resultado de seleccion
		Cromosoma[] seleccion = new Cromosoma[size];

		// Calculo probabilidad ponderada
		double probabilidadPonderada[] = ProbabilidadPonderada(poblacion);		

		for (int i = 0; i < size; i++) {

			double r = Math.random();
			int c = 0;
			// Buscar el primer elemento del array de probabilidad que no sea mayor que el valor aleatorio
			while (r > probabilidadPonderada[c]) {
				r -= probabilidadPonderada[c];
				c++;
			}

			seleccion[i] = poblacion[c];
		}

		return seleccion;
	}

	public static Cromosoma[] MuestreoUniversalEstoclastico(Cromosoma[] poblacion) {

		// Tamaño de la poblacion

		int size = poblacion.length;

		// Array nuevo con el resultado de seleccion
		Cromosoma[] seleccion = new Cromosoma[size];

		double offset = 1.0 / size;

		var probabilidadPonderada = ProbabilidadPonderada(poblacion);
		
		//Se calcula un numero aleatorio entre el 0 y el offset
		double r = Math.random() * offset;

		for (int i = 0; i < size; i++) {

			double r2 = r + offset * i;

			int c = 0;
			// Buscar el primer elemento del array de fitness que no mayor que el valor
			// aleatorio
			while (r2 > probabilidadPonderada[c]) {

				r2 -= probabilidadPonderada[c];
				c++;
			}

			seleccion[i] = poblacion[c];
		}

		return seleccion;
	}

	public static void quickSort(Cromosoma[] poblacion, int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(poblacion, begin, end);

			quickSort(poblacion, begin, partitionIndex - 1);
			quickSort(poblacion, partitionIndex + 1, end);
		}
	}

	private static int partition(Cromosoma[] poblacion, int begin, int end) {
		double pivot = poblacion[end].getFitness();
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (poblacion[j].getFitness() > pivot) {
				i++;

				Cromosoma swapTemp = poblacion[i];
				poblacion[i] = poblacion[j];
				poblacion[j] = swapTemp;
			}
		}

		Cromosoma swapTemp = poblacion[i + 1];
		poblacion[i + 1] = poblacion[end];
		poblacion[end] = swapTemp;

		return i + 1;
	}

	public static Cromosoma[] Truncamiento(Cromosoma[] poblacion) {

		float truncamiento = 20;

		Cromosoma[] ordenado = poblacion.clone();

		// Ordenar
		quickSort(ordenado, 0, ordenado.length - 1);

		Cromosoma[] seleccion = new Cromosoma[poblacion.length];
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

	public static Cromosoma[] TorneoDeterministico(Cromosoma[] poblacion, int k) {

		int size = poblacion.length;

		Cromosoma[] seleccion = new Cromosoma[size];

		for (int i = 0; i < size; i++) {

			int[] muestra = new int[k];
			for (int c = 0; c < k; c++) {

				int idx = (int) Math.floor(Math.random() * size);
				muestra[c] = idx;
			}

			// Fase de seleccion
			int seleccionado = muestra[0];
			for (int c = 1; c < k; c++) {

				if (poblacion[muestra[c]].getFitness() > poblacion[seleccionado].getFitness()) {
					seleccionado = muestra[c];
				}
			}

			seleccion[i] = poblacion[seleccionado];

		}

		return seleccion;
	}

	public static Cromosoma[] TorneoProbabilistico(Cromosoma[] poblacion, int k, double p) {

		int size = poblacion.length;

		Cromosoma[] seleccion = new Cromosoma[size];

		for (int i = 0; i < size; i++) {

			int[] muestra = new int[k];
			for (int c = 0; c < k; c++) {

				int idx = (int) Math.floor(Math.random() * size);
				muestra[c] = idx;
			}

			// Fase de seleccion
			int seleccionado = muestra[0];

			if (Math.random() > p) {

				for (int c = 1; c < k; c++) {

					if (poblacion[muestra[c]].getFitness() > poblacion[seleccionado].getFitness()) {
						seleccionado = muestra[c];
					}
				}

			} else {

				for (int c = 1; c < k; c++) {

					if (poblacion[muestra[c]].getFitness()< poblacion[seleccionado].getFitness()) {
						seleccionado = muestra[c];
					}
				}
			}

			seleccion[i] = poblacion[seleccionado];

		}

		return seleccion;

	}

	public static Cromosoma[] Ranking(Cromosoma[] poblacion) {

		return null;
	}

	public static Cromosoma[] Restos(Cromosoma[] poblacion) {

		// Tamaño de la poblacion
		int size = poblacion.length;

		// Array nuevo con el resultado de seleccion
		Cromosoma[] seleccion = new Cromosoma[size];
		
		var probabilidadPonderada = ProbabilidadPonderada(poblacion);
		
		int idx = 0;

		for (int i = 0; i < size; i++) {
			if (probabilidadPonderada[i] * size > 1) {

				seleccion[idx++] = poblacion[i];
			}
		}

		Cromosoma[] ruleta = Proporcional(poblacion);
		
		for(int i = idx; i < size; i++) {
			
			seleccion[i] = ruleta[i];
		}
		
		
		return seleccion;
	}

	
	
}
