package Common;

import java.util.Random;

public class Mutation {
	public enum Type{
		Uniform, NonUniform
	}
	
	public Individuo[] mutateUniform(Individuo[] population, double probMutation) {
		Individuo[] mutated= new Individuo[population.length];
		Random rnd=new Random();
		for(int i=0;i<mutated.length;i++) {
			double r= rnd.nextDouble();
			mutated[i]= population[i];
			if(r <= probMutation) {
				mutated[i].mutate(rnd, probMutation);
			}
		}
		
		return mutated;
	}
	void mutateNonUniform() {
		
	}
}
