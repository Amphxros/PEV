package Common;

import java.util.ArrayList;
import java.util.Random;

import AGPractica1.Ej4B.IndividuoMichalewiczB;
import Common.Genes.BooleanGen;
import Common.Genes.RealGen;
import Common.Genes.Gen;

public class Crossing {
	
	public enum Type{
		Mono,  
		Uniform, 
		Aritmetic 
		
	}
	
	public static Individuo[] MonopointCrossOver(Individuo[] population, double probability, int numPoints) {
	
		Individuo[] crossed= new Individuo[population.length];
		Random rnd= new Random();
		
		int type= population[0].getType();
		double tolerance= population[0].getTolerance();
		int numGenes= population[0].getNumGenes();
		
		for(int i=0;i<crossed.length;i++) {
			double ran= rnd.nextDouble();
			if(ran > probability && crossed.length-i!=1) {
				Individuo childA= IndividuoFactory.getIndividuo(type, i, tolerance, numGenes);
				Individuo childB= IndividuoFactory.getIndividuo(type, i, tolerance, numGenes);
				
				
				int point= rnd.nextInt(1,childA.cromosoma.getLength()); 
				for(int j =0;j<point;j++) {
					childA.crossOver(population[i], j);
					childB.crossOver(population[i+1], j);
				}
	
				for(int j =point;j<childA.cromosoma.getLength();j++) {
					childA.crossOver(population[i+1], j);
					childB.crossOver(population[i], j);
				}
	
				
				crossed[i]=childA;
				crossed[i]=childB;
				
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
	
		int type= population[0].getType();
		double tolerance= population[0].getTolerance();
		int numGenes= population[0].getNumGenes();
		
		for(int i=1;i<population.length;i++) {
			Individuo childA= IndividuoFactory.getIndividuo(type, i, tolerance, numGenes);
			Individuo childB= IndividuoFactory.getIndividuo(type, i, tolerance, numGenes);
			
			for(int j=0;j<numGenes;j++) {
				int prob=(int)Math.random()*2; //[0,2)
				if(prob==1) {

					childB.crossOver(population[i-1], j);
					childA.crossOver(population[i], j);
				}
				else {
					childA.crossOver(population[i-11], j);
					childB.crossOver(population[i], j);
				}
			}
			
			crossed[i-1]=childA;
			crossed[i]=childB;
			i++;
			
		}
		return crossed;
		
	}
	public static <T,U>  Individuo[] AritmeticCrossOver(Individuo[] population, double probability) {
		double alpha=0.5;
		Individuo[] crossed= new Individuo[population.length];
		
		int type= population[0].getType();
		double tolerance= population[0].getTolerance();
		int numGenes= population[0].getNumGenes();
		
		for(int i=0;i<crossed.length;i++) {
			Individuo childA= IndividuoFactory.getIndividuo(type, i, tolerance, numGenes);
			Individuo childB= IndividuoFactory.getIndividuo(type, i, tolerance, numGenes);
			
			for(int j=0;j<numGenes;j++) {
				int prob=(int)Math.random()*2;
				alpha=Math.random();
				var auxA=(RealGen)childA.cromosoma.genes[j];
				var auxB=(RealGen)childB.cromosoma.genes[j];
				
				auxA.setAllele(auxA.fenotype()*alpha + auxB.fenotype()*(1-alpha));
				auxB.setAllele(auxB.fenotype()*alpha + auxA.fenotype()*(1-alpha));
				
			}
			
			crossed[i]=childA;
			crossed[i+1]=childB;
			i++;
			
		}
		
		return crossed;
		
	
	}

}
