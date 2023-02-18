package base;

public class Crossing {
	public enum Type{
		Mono, Multiple, Uniform
	}
	public <T> void MonopointCrossOver(Individuo<T> parentA, Individuo<T> parentB, Individuo<T>childA, Individuo<T> childB, int crossOverPoint) {
		// first part: A to childA and B to childB
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
			
		}
	}
}
