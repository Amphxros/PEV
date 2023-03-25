package Common;

import java.util.Random;

public class Crossing {
	
	public enum Type{
		PMX,
		OX, 
		OXVarianteA,
		OXVarianteB,
		CX, 
		ERX, 
		CO,
		Own
	}
	
	public static Cromosoma[] PMXCrossOver(Cromosoma[] population, double probability) {
		
		int numGenes= population[0].getNumGenes();
		Random rnd= new Random();
		
		Cromosoma[] children= new Cromosoma[population.length];
		
		for(int i=0;i<population.length;i++) {
			children[i]=new Cromosoma(numGenes);
		}
		
		for(int i=0;i<population.length;i++) {
			double prob= rnd.nextDouble();
			if(probability>prob) {

				int pointA=rnd.nextInt(0,numGenes);
				int pointB=rnd.nextInt(0,numGenes);
				int pointAux=pointA;
				if(pointA==pointB) {
					pointB=(pointB +1) %numGenes;
				}
				if(pointA>pointB) {
					pointA=pointB;
					pointB=pointAux;
				}
				
				for(int j=0;j<numGenes;j++) {
					children[i].genes[j].setAllele(population[i].genes[j].getAllele());
					children[i+1].genes[j].setAllele(population[i+1].genes[j].getAllele());
				}
				
			}
			else {
				for(int k=0;k<numGenes;k++) {
					children[i].genes[k].setAllele(population[i].genes[k].getAllele());
				}
			}
		}
		
		return children;
		
	}
	public static Cromosoma[] OXCrossOver(Cromosoma[] population, double probability) {
		return population;
		
	}
	
	public static Cromosoma[] OXVarACrossOver(Cromosoma[] population, double probability) {
		return population;
		
	}
	public static Cromosoma[] OXVarBCrossOver(Cromosoma[] population, double probability) {
		return population;
		
	}
	
	public static Cromosoma[] CXCrossOver(Cromosoma[] population, double probability) {
		return population;
		
	}
	
	public static Cromosoma[] ERXCrossOver(Cromosoma[] population, double probability) {
		return population;
		
	}
	public static Cromosoma[] COCrossOver(Cromosoma[] population, double probability) {
		return population;
		
	}
	
	
}
