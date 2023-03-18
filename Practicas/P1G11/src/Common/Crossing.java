package Common;

import java.util.ArrayList;
import java.util.Random;

import Common.Genes.BooleanGen;
import Common.Genes.Gen;

public class Crossing {
	
	public enum Type{
		Mono, Multiple, Uniform, Aritmetic, Linear, Geometric, SBX
	}
	
	public static Individuo[] MonopointCrossOver(Individuo[] population, double probability, int numPoints) {
	
		Individuo[] crossed= new Individuo[population.length];
		Random rnd= new Random();
		
		//int numGenes= population[0].get
		for(int i=0;i<population.length;i++) {
			double prob= rnd.nextDouble();
			
			if(prob>=probability && i<population.length - 1) {
				Individuo childA= population[i];
				Individuo childB= population[i + 1];
				
				int length= childA.cromosoma.getLength();
				double aux= 1 + rnd.nextDouble()*(length-2);
				int point=(int)aux;
				
				for(int j=point;j<length;j++) {
					//swap genes
					BooleanGen genA= (BooleanGen)(childA.cromosoma.genes[j]);
					var alleleA=genA.getAlelle(j);
					
					BooleanGen genB= (BooleanGen)(childB.cromosoma.genes[j]);
					var alleleB=genB.getAlelle(j);
					if(alleleA)
						genB.insert(1, j);
					else
						genB.insert(0, j);
					
					
					if(alleleB)
						genA.insert(1, j);
					else
						genA.insert(0, j);
					
					
					
					
				}
				//set the crossed ones;
				crossed[i+1]=childB;
				i++;
			}
			else {
				crossed[i]=population[i];
			}
		}
	
		return crossed;
	}
	public static <T> void MultiPointCrossOver(Individuo[] population, double probability, int numPoints) {
		
	}
	public static <T,U> Individuo[] UniformCrossOver(Individuo[] population, double probability) {
		Individuo[] crossed= new Individuo[population.length];
		for(int i=0;i<crossed.length;i++) {
			var childA= population[i];
			var childB=population[i + 1];
			Random rnd= new Random();
			for(int j=0;j<childA.cromosoma.getLength();i++) { //CHANGE IT
				double rand=rnd.nextDouble();
				if(rand<probability) {
					
					BooleanGen genA= (BooleanGen)(childA.cromosoma.genes[j]);
					var alleleA=genA.getAlelle(j);
					
					BooleanGen genB= (BooleanGen)(childB.cromosoma.genes[j]);
					var alleleB=genB.getAlelle(j);
					if(alleleA)
						genB.insert(1, j);
					else
						genB.insert(0, j);
					
					
					if(alleleB)
						genA.insert(1, j);
					else
						genA.insert(0, j);
					
				}
			}
			
			crossed[i]=childA;
			crossed[i+1]=childB;
			i++;
		}
		return crossed;
		
	}
	public static <T,U> Individuo[] AritmeticCrossOver(Individuo[] population, double probability) {
		return population;
	}

}
