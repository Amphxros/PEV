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
				
				boolean conflict=false;
				int indA,indB, j;
				
				for(int k=pointB;k>=pointB || k<pointA; k=(k+1)% numGenes) {
					indA=k;
					
					do {
						j = pointA;
						do { // comprobamos si padre1 -> ciudad[i] ya esta en el hijo
							conflict = children[i].genes[j].getAllele() == population[i].genes[pointA].getAllele();
							j++;
						} while (!conflict && j < pointB);
						if (conflict) indA = j-1;
					} while (conflict);
					
					children[i].genes[k].setAllele(population[i].genes[indA].getAllele());

					// hijo 2
					indB = i;
					do {
						j = pointA;
						do {
							conflict = children[i+1].genes[j].getAllele() ==population[i+1].genes[pointA].getAllele();
							j++;
						} while (!conflict && j < pointB);
						if (conflict) indB = j-1;
					} while (conflict);
					children[i+1].genes[k].setAllele(population[i+1].genes[indB].getAllele());
					
				}
				population[i].copy(children[i]);
				population[i+1].copy(children[i+1]);
				i++;
				
			}
			else {
				for(int k=0;k<numGenes;k++) {
					children[i].genes[k].setAllele(population[i].genes[k].getAllele());
				}
				population[i].copy(children[i]);
			}
		}
		
		return children;
		
	}

	public static Cromosoma[] OXCrossOver(Cromosoma[] population, double probability) {
		int numGenes=population[0].getNumGenes();
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
				if(pointB==pointA) {
					pointB=(pointB+1)%numGenes;
				}
				if(pointA<pointB) {
					pointA=pointB;
					pointB=pointAux;
				}
				

				for(int j=0;j<numGenes;j++) {
					children[i].genes[j].setAllele(population[i].genes[j].getAllele());
					children[i+1].genes[j].setAllele(population[i+1].genes[j].getAllele());
				}
				
				for(int j=pointA;j<pointB;j++) {
					children[i].genes[j].setAllele(population[i+1].genes[j].getAllele());
					children[i+1].genes[j].setAllele(population[i].genes[j].getAllele());
				}
				
				boolean conflict=true;
				int indA=pointB;
				int indB=pointB;
				int l=0;
				for(int k=pointB;k>=pointB|| k<pointA;k=(k+1)%numGenes) {
					do {
						l = pointA;
			
						do {
							conflict = children[i].genes[l].getAllele() == population[i].genes[pointA].getAllele();
							l = (l+1) % numGenes;
						} while (!conflict && l != k);
						
						if (conflict)
							indA = (indA+1) % numGenes;
					} while (conflict);
					children[i].genes[k].setAllele(population[i].genes[indA].getAllele());

					
					do {
						l = pointA;
						do {
							conflict = children[i+1].genes[l].getAllele() == population[i+1].genes[pointA].getAllele();
							l = (l+1) % numGenes;
						} while (!conflict && l != k);
						if (conflict) indB = (indB+1) % numGenes;
					} while (conflict);
					children[i+1].genes[k].setAllele(population[i+1].genes[indB].getAllele());
			
				}	
			}	
		 }
		
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
