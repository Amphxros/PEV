package Common;

import java.util.ArrayList;
import java.util.Random;

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
					//TODO swap genes here
					childA.crossOver(childB, j);
					childB.crossOver(childA, j);
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
	public static <T> void MultiPointCrossOver() {
		
	}
	public static <T> Individuo[] UniformCrossOver(Individuo<T>[] population, double probability) {
		Individuo[] crossed= new Individuo[population.length];
		
		return crossed;
		
	}
}
