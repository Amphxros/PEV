package Common;

import java.util.ArrayList;
import java.util.Random;

public class Mutation {
	public enum Type{
		Insert, 
		Exchange, 
		Invert, 
		Heuristic
	}
	public static Cromosoma[] mutateInserting(Cromosoma[] population, double probMutation) {
		int numGenes= population[0].getNumGenes();
		Random rnd= new Random();
		for(int i=0;i<population.length;i++) {
			boolean mut=false;
			for(int j=1;j<numGenes;j++) {
				double prob= rnd.nextDouble();
				if(probMutation>prob) {
					int genAux=population[i].genes[j].getAllele();
					int position=rnd.nextInt(0,j);
					for(int k=j;k>position;k--) {
						population[i].genes[k].setAllele(population[i].genes[k-1].getAllele());
					}
					population[i].genes[position].setAllele(genAux);
					mut=true;
				}
			}
			if(mut)
				population[i].evaluateSelf();
			
		}
		
		return population;
	}
	public static Cromosoma[] mutateExchanging(Cromosoma[] population, double probMutation) {
		int numGenes= population[0].getNumGenes();
		Random rnd= new Random();
		for(int i=0;i<population.length;i++) {
			double prob=rnd.nextDouble();
			boolean mut=false;
			if(probMutation>prob) {
				int posA=rnd.nextInt(0,numGenes);
				int posB=rnd.nextInt(0,numGenes);
				if(posA==posB) {
					posB=(posB+1)%numGenes;
				}
				
				int cityAux=population[i].genes[posA].getAllele();
				population[i].genes[posA].setAllele(population[i].genes[posB].getAllele());
				population[i].genes[posB].setAllele(cityAux);
				mut=true;
			}
			if(mut)
				population[i].evaluateSelf();
			
		}
		
		return population;
	}
	
	static int indPermutacion;
	public static Cromosoma[] mutateInvert(Cromosoma[] population, double probMutation) {
		int numGenes= population[0].getNumGenes();
		Random rnd= new Random();
		for(int i=0;i<population.length;i++) {
			double prob=rnd.nextDouble();
			boolean mut=false;
			if(probMutation>prob) {
				int puntA = (int) (Math.random()*numGenes); 
				int puntB = (int) (Math.random()*numGenes); 
				int puntAux = puntA;
				if (puntA > puntB){
					puntA = puntB;
					puntB = puntAux;
				}
				
				int mit = (puntB+puntA)/2;
				for (int j = puntA; j <= mit; j++){
					int genAux = population[i].genes[puntB].getAllele();
					population[i].genes[puntB].setAllele(population[i].genes[j].getAllele());
					population[i].genes[j].setAllele(genAux);
					puntB--;
				}
				mut = true;
			}
			if(mut)
				population[i].evaluateSelf();
			
		}
		
		return population;
	}
	
	public static Cromosoma[] mutateHeuristic(Cromosoma[] population, double probMutation) {
	
		boolean mut, rep;
		Random rnd= new Random();
		
		int N = 3;
		int numPermutaciones = Utils.factorial(N);
		int numGenes = population[0].getNumGenes();
		int mejorHeuristica;
		
		ArrayList<Integer> ciudadesSelec = new ArrayList<Integer>(); // N citys
		ArrayList<Integer> posicionesSelec = new ArrayList<Integer>(); // N positions
		Gen[] mejorPermutacion = new Gen[numGenes], permutacion;
		ArrayList<Gen[]> perms = new ArrayList<Gen[]>();

		for (int i = 0; i < population.length; i++) {
			mut = false;
			double prob= rnd.nextDouble();
			if (probMutation>prob) {
				mut = true;
				permutacion = new Gen[numGenes];
				
				for (int k = 0; k < numGenes; k++)
					permutacion[k] = new Gen(population[i].genes[k].getAllele());
				
				for (int j = 0; j < numPermutaciones; j++) { // inicializa el arrayList donde guardamos todas las permutaciones
					perms.add(new Gen[numGenes]);
					for (int k = 0; k < numGenes; k++)
						perms.get(j)[k] = new Gen(population[i].genes[k].getAllele());
				}
				
				int city, pos;
				for (int j = 0; j < N; j++) { // Selecciona las n ciudades a modificar. Sin repeticiones.
					do { // guarda la ciudad en ciudadesSelec
						rep = false;
						city = (int) (Math.random()*numGenes+1);
						rep = city == 25; // si la ciudad es madrid(25) entonces la descartamos
						for (int k = 0; k < j && !rep; k++) rep = city == ciudadesSelec.get(k);
					} while (rep);
					ciudadesSelec.add(city);

					// guarda la posicion de la ciudadSel(j) en posicionesSelec
					pos = 0;
					while (ciudadesSelec.get(j) != population[i].genes[pos].getAllele())
						pos++;
					posicionesSelec.add(pos);
					
					// quita las ciudades seleccionadas de las futuras permutaciones. para facilitar la comprobacion en contiene(...)
					for (int k = 0; k < numPermutaciones; k++)
						perms.get(k)[posicionesSelec.get(j)] = new Gen(-1);
					permutacion[posicionesSelec.get(j)] = new Gen(-1);
				}
				
				int indPermutacion = 0;
				permutate(population[i].genes, permutacion, ciudadesSelec, posicionesSelec, perms, N, N); // Rellena el arrayList con todas las posibles permutaciones
				
				// Busca la mejor permutacion de las generadas
				mejorPermutacion = perms.get(0);
				mejorHeuristica = calculateHeuristic(mejorPermutacion, ciudadesSelec, N);
				for (int j = 1; j < indPermutacion; j++) {
					if (calculateHeuristic(perms.get(j), ciudadesSelec, N) < mejorHeuristica) {
						mejorPermutacion = perms.get(j);
						mejorHeuristica = calculateHeuristic(mejorPermutacion, ciudadesSelec, N);
					}
				}
				
				population[i].genes = mejorPermutacion;
				
				if (mut) {
					population[i].evaluateSelf();
					for (int j = 0; j < N; j++) {
						ciudadesSelec.remove(0);
						posicionesSelec.remove(0);
					}
					for (int j = 0; j < numPermutaciones; j++)
						perms.remove(0);
				}
			}
		}
		return population;

	}
	
	private static void permutate(Gen[] genes, Gen[] perm, 
			ArrayList<Integer> citys, ArrayList<Integer> positions, ArrayList<Gen[]> perms, 
			int N, int k) {
		if (k == 0) {
			for (int i = 0; i < genes.length; i++)
				perms.get(indPermutacion)[i].setAllele(perm[i].getAllele());
			indPermutacion++;
		}
		else {
			int city;
			for (int j = 0; j < N; j++) {
				city = citys.get(j);
				if (!contains(perm, city)) {
					perm[positions.get(k-1)] = new Gen(citys.get(j));
					permutate(genes, perm, citys, positions, perms, N, k-1);
				}
			}
			perm[positions.get(k-1)] = new Gen(-1);
		}
	}
	
	/**
	 * @param perms all the combinations
	 * @param citys selected citys
	 * @param N num of citys
	 * @return the distance between all of them (heuristics)
	 */
	private static int calculateHeuristic(Gen[] perms, ArrayList<Integer> citys, int N) {
		int h = 0;
		for (int i = 0; i < perms.length; i++) {
			if (citys.contains(perms[i].getAllele())) {
				if (i > 0) h += CityData.getDistance(perms[i].getAllele(), perms[i-1].getAllele());
				if (i < perms.length-1) 
					h += CityData.getDistance(perms[i].getAllele(), perms[i+1].getAllele());
			}
		}
		return h;
	}
	
	private static boolean contains(Gen[] genes, int ciudad) {
		for (int i = 0; i < genes.length; i++)
			if (genes[i].getAllele() == ciudad)
				return true;
		return false;
	}
	
	
	public static Cromosoma[] mutateOwn(Cromosoma[] population, double probMutation) {
		int numGenes= population[0].getNumGenes();
		Random rnd= new Random();
		for(int i=0;i<population.length;i++) {
			double prob=rnd.nextDouble();
			boolean mut=false;
			if(probMutation>prob) {
				
			}
		}
		return population;
		
	}
	
}
