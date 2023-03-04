package AGPractica1.Ej4A;

import java.util.Random;

import Common.Conversions;
import Common.Cromosoma;
import Common.Individuo;
import Common.Genes.BooleanGen;

public class IndividuoMichalewiczA extends Individuo<Boolean> {
	final double min=0;
	final double max=Math.PI;
	final int dimension;
	final int m=10;
	
	public IndividuoMichalewiczA(double tolerance, int id, int numGenes,int dimension) {
		super(tolerance, id, numGenes);
		this.dimension=dimension;
		
		final int tam=this.tamGen(tolerance, min, max);
		
		Random rnd= new Random();
		this.fenotype= new double[this.numGenes];
		this.cromosoma= new Cromosoma(tam);
		for(int i=0;i<this.cromosoma.getLength();i++) {
			BooleanGen g= new BooleanGen(rnd.nextBoolean());
			this.cromosoma.setGen(g, i);	
		}
		calculateFenotype();
		
	}

	protected boolean mutateSelf(int pos, Random rnd, double probability) {
		if(rnd.nextDouble()<probability) {
			this.cromosoma.setGen(new BooleanGen(rnd.nextBoolean()), pos);
			return true;
		}
		return false;
	}

	@Override
	protected void calculateFenotype() {
		fenotype= new double[this.numGenes];
		for(int i=0;i<fenotype.length;i++) {
			fenotype[i]= min + (max - min) * (Conversions.binaryToDecimal(this.cromosoma)/this.getCromosomeArraySize()) -1;
		}
		
	}

	@Override
	public void evaluateSelf() {
		final double fitness_;
		if(fenotype.length==this.numGenes) {
			fitness_=0;
			double pi=Math.PI;
			for(int i=0;i<fenotype.length;i++) {
				double aux=Math.pow(fenotype[i], 2)/pi;
				fitness+=Math.sin(fenotype[i])*Math.sin(Math.pow(aux,2*m));
			}
			
			this.setFitness(-fitness_);
		}
		else {
			fitness_= Double.MIN_VALUE;
			this.setFitness(fitness_);
			System.out.println("Ejer 4: Wrong fitness params.");
			
		}
		
	}



}
