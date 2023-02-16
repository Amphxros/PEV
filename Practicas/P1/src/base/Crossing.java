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
		for(int j=crossOverPoint; j< parentA.getCromosomes().length; j++) {
			childA.crossOver(parentB, j);
			childB.crossOver(parentA, j);
		}
		
	}
	public void MultiPointCrossOver() {
		
	}
	public void UniformCrossOver() {
		
	}
}
