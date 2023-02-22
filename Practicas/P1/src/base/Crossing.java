package base;

import java.util.ArrayList;

public class Crossing {
	public enum Type{
		Mono, Multiple, Uniform
	}
	public <T> void MonopointCrossOver(ArrayList<Individuo<T>> population, int crossOverPoint) {
	
		Individuo<T> parentA;
		Individuo<T> parentB;
		Individuo<T>childA;
		Individuo<T> childB;
		
		int nGenes = population.get(0).getCromosomeLength();
		double tolerancia = population.get(0).getTolerance();
		int idFuncion = population.get(0).getID();
		int selected[] = new int[population.size()]; 
		int n = 0;
		
		/*
		 * // first part: A to childA and B to childB
		 
		for(int i=0;i<crossOverPoint; i++) {
			//cross children
			childA.crossOver(parentA, i);
			childB.crossOver(parentB, i);
		}
		
		//second part:  A to childB and B to childA
		for(int j=crossOverPoint; j< parentA.getCromosomes().size(); j++) {
			childA.crossOver(parentB, j);
			childB.crossOver(parentA, j);
		}
		
		*/
		//childA.setFitness(childA.evaluateSelf());
		//childB.setFitness(childB.evaluateSelf());
		
	}
	public <T> void MultiPointCrossOver() {
		
	}
	public <T> void UniformCrossOver(Individuo<T>[] population, int tam, double probability) {
		Individuo<T> childA, childB;
		double prob;
		int numSelect=0;
		int selected[]= new int[tam];
		
		for (int i=0;i<tam;i++) {
			prob=Math.random();
			if(prob<probability) {
				selected[numSelect]=i;
				numSelect++;
			}
		}
		
		
		if(numSelect%2!=0) numSelect--;
		
		for(int i=0;i<numSelect;i++) {
			//child A= ...
			//child B= ...
			prob = (int) Math.random() * 2;
			if(prob==1) {
				//childA.crossOver(population[numSelected[i]], j);
				//childB.crossOver(population[numSelected[i+1]],j);
				
			}
			else {
				//childB.crossOver(population[numSelected[i]], j);
				//childA.crossOver(population[numSelected[i+1]],j);
			}
		}
	}
}
