package Common;

import java.util.Random;

public class Mutation {
	public enum Type{
		Uniform,
		NonUniform,
		
	}
	
	public static Individuo[] mutateUniform(Individuo[] population, double probMutation) {
		Individuo[] mutated= new Individuo[population.length];
		Random rnd=new Random();
		for(int i=0;i<mutated.length;i++) {
			double r= rnd.nextDouble();
			mutated[i]= population[i];
			if(r <= probMutation) {
				mutated[i].mutateSelf(i, rnd, probMutation);
			}
		}
		
		return mutated;
	}
	public static Individuo[] mutateNonUniform(Individuo[] population, double probMutation) {
		//FOR NOW ITS EMPTY
		return null;
	}
	
	public static Individuo[] mutateInsert(Individuo[] population, double probMutation) {
		return null;	
	}
	
	public static Individuo[] mutateExchanging(Individuo[] population, double probMutation) {
		return null;	
	}
	
	public static Individuo[] mutateInvert(Individuo[] population, double probMutation) {
		return null;	
	}
	public static Individuo[] mutateHeuristic(Individuo[] population, double probMutation) {
		return null;	
	}
}
