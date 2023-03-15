package AGPractica1.Ej3;

import java.util.Random;

import Common.Conversions;
import Common.Cromosoma;
import Common.Individuo;
import Common.Genes.BooleanGen;

public class IndividuoStyblinskiTang extends Individuo<Boolean, Double>{

	final double min=-5;
	final double max=5;
	final int dimension=2;
	
	public IndividuoStyblinskiTang(double tolerance, int id, int numGenes) {
		super(tolerance, id, numGenes);
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		fenotype= new Double[dimension];
		for(int i=0;i<fenotype.length;i++) {
			fenotype[i]= min + (max - min) * (Conversions.binaryToDecimal(this.cromosoma)/this.getCromosomeArraySize()) -1;
		}
				
	}

	/**
	 * Calculate the fitness in this case f(x)= 0.5*∑(xi^4 - 16xi^2 + 5*xi)
	 */
	@Override
	public void evaluateSelf() {
		// TODO Auto-generated method stub
		final double fitness_; //new fitness
		if (fenotype.length == dimension) {
			
			double sum=0.0;
			for(int i=0;i<dimension;i++) {
				sum+= (Math.pow(fenotype[i],4)) - (16*Math.pow(fenotype[i], 2)) + 5*fenotype[i];
			}
			sum*=0.5;
			
			fitness_=sum;
		
		}
		else {
			fitness_=Double.MIN_VALUE;
			System.out.println("Ejer 3: Wrong fitness params.");
		}
		
		setFitness(fitness_);
	}

}
