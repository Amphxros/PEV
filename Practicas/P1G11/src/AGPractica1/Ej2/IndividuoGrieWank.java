package AGPractica1.Ej2;

import java.util.Random;

import Common.Conversions;
import Common.Cromosoma;
import Common.Individuo;
import Common.Genes.BooleanGen;

public class IndividuoGrieWank extends Individuo<Boolean>{

	final double min = -600.0;
	final double max = 600.0;
	final int dimension=2;
	
	public IndividuoGrieWank(double tolerance, int id, int numGenes) {
		super(tolerance, id, numGenes);
		final int tamGenes = this.calculateGenSize(tolerance, min, max);
		
		fenotype= new double[dimension];
		this.cromosoma= new Cromosoma(numGenes);
		
		Random rnd= new Random();
	
		for(int i=0;i<numGenes;i++) {
			BooleanGen g= new BooleanGen(rnd.nextBoolean());
			//System.out.print(g.toString());
			this.cromosoma.setGen(g, i);	
		}
		
	}

	@Override
	protected boolean mutateSelf(int pos, Random rnd, double mutation_chance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void calculateFenotype() {
		fenotype= new double[this.getCromosomeArraySize()];
		for(int i=0;i<fenotype.length;i++) {
			fenotype[i]= min + (max - min) * (Conversions.binaryToDecimal(this.cromosoma)/this.getCromosomeArraySize()) -1;
		}
	}

	/**
	 * Calculate the fitness in this case f(x)= ∑ (xi^2 /4000)  - ∏(cos (xi/√i)) +1 
	 */
	@Override
	public void evaluateSelf() {
		final double fitness_;	
		if(fenotype.length==dimension) {
			double first=0, second=0; 
			for(int i=0; i<dimension;i++) {
				first+=Math.pow(fenotype[i],2)/4000; //∑ (xi^2 /4000) 
				second+=Math.cos(fenotype[i]/Math.sqrt(i)); // ∏(cos (xi/√i)) 
			}
			
			fitness_=first - second + 1;
		}
		else {
			fitness_=Double.MIN_VALUE;
			setFitness(fitness_);		
		}
		System.out.println("Ejer 2: Wrong fitness params.");
		
	}

	@Override
	public boolean maximize() {
		// TODO Auto-generated method stub
		return false;
	}

}
