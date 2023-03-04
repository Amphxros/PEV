package Common;

import java.util.ArrayList;
import java.util.Random;

import Common.Genes.Gen;

public class Crossing {
	
	public enum Type{
		Mono, Multiple, Uniform, Aritmetic, Linear, Geometric, SBX
	}
	
	public static <T> Individuo[] MonopointCrossOver(Individuo[] population, double probability, int numPoints) {
	
		Individuo[] crossed= new Individuo[population.length];
		Random rnd= new Random();
		
		for(int i=0;i<population.length;i++) {
			double prob= rnd.nextDouble();
			
			if(prob>=probability && i<population.length - 1) {
				Individuo childA= population[i];
				Individuo childB= population[i + 1];
				
				int length= childA.getCromosomeArraySize();
				double aux= 1 + rnd.nextDouble()*(length-2);
				int point=(int)aux;
				
				for(int j=point;j<length;j++) {
					//swap genes
					var genA= (Gen<T>)childA.getCromosomes().getGen(j);
					var auxA=genA.getAllele();
					
					var genB= (Gen<T>)childB.getCromosomes().getGen(j);
					var auxB=genB.getAllele();
					
					genA.setAllele(auxB);
					genB.setAllele(auxA);
					
					
					
				}
				//set the crossed ones
				crossed[i]=childA;
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
	public static <T> Individuo[] UniformCrossOver(Individuo<T>[] population, double probability) {
		Individuo[] crossed= new Individuo[population.length];
		for(int i=0;i<crossed.length;i++) {
			var childA= population[i];
			var childB=population[i + 1];
			Random rnd= new Random();
			for(int j=0;j<childA.getCromosomeArraySize();i++) {
				double rand=rnd.nextDouble();
				if(rand<probability) {
					var genA= (Gen<T>)childA.getCromosomes().getGen(j);
					var auxA=genA.getAllele();
					
					var genB= (Gen<T>)childB.getCromosomes().getGen(j);
					var auxB=genB.getAllele();
					
					genA.setAllele(auxB);
					genB.setAllele(auxA);
					
				}
			}
			
			crossed[i]=childA;
			crossed[i+1]=childB;
			i++;
		}
		return crossed;
		
	}
	public static <T> Individuo[] AritmeticCrossOver(Individuo<T>[] population, double probability) {
		return population;
	}

}
