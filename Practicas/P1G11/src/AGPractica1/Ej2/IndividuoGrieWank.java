package AGPractica1.Ej2;

import java.util.Random;

import Common.Conversions;
import Common.Cromosoma;
import Common.Individuo;
import Common.Genes.BooleanGen;

public class IndividuoGrieWank extends Individuo<Boolean, Double>{

	final double min = -600.0;
	final double max = 600.0;
	final int dimension=2;
	
	public IndividuoGrieWank(double tolerance, int id, int numGenes) {
		super(tolerance, id, numGenes);
		
		this.fenotype= new Double[dimension];
		final int tamGenes = this.tamGen(tolerance, min, max);

		Random rnd= new Random();
		this.cromosoma= new Cromosoma(tamGenes);
		for(int i=0;i<this.cromosoma.getLength();i++) {
			BooleanGen g= new BooleanGen(rnd.nextBoolean());
			this.cromosoma.setGen(g, i);	
		}
		calculateFenotype();
		
	}

	@Override
	protected boolean mutateSelf(int pos, Random rnd, double probability) {
		if(rnd.nextDouble()<probability) {
			this.cromosoma.setGen(new BooleanGen(rnd.nextBoolean()), pos);
			return true;
		}
		return false;
	}

	@Override
	protected void calculateFenotype() {
		fenotype= new Double[dimension];
		for(int i=0;i<fenotype.length;i++) {
			fenotype[i]= min + (max - min) * (Conversions.binaryToDecimal(this.cromosoma)/this.getCromosomeArraySize()) -1;
		}
	}

	/**
	 *  Calculate the fitness in this case f(x)= ∑ (xi^2 /4000)  - ∏(cos (xi/√i)) +1 
	 */
	@Override
	public void evaluateSelf() {

		final double fitness_;	

		if(dimension==this.fenotype.length) {
			double first=0, second=0; 
			for(int i=0; i<dimension;i++) {
				first+=Math.pow(fenotype[i],2)/4000; //âˆ‘ (xi^2 /4000) 
				second+=Math.cos(fenotype[i]/Math.sqrt(i + 1)); // âˆ�(cos (xi/âˆši)) 
			}
			
			fitness_=first - second;
			setFitness(fitness_);	
		}
		else {
			fitness_=Double.MIN_VALUE;
			setFitness(fitness_);		
			System.out.println("Ejer 2: Wrong fitness params.");
			
		}
		
	}



}
