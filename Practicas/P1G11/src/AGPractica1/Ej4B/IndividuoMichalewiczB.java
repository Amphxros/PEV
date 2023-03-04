package AGPractica1.Ej4B;

import java.util.Random;

import Common.Cromosoma;
import Common.Individuo;
import Common.Genes.RealGen;

public class IndividuoMichalewiczB extends Individuo<Double>{

	private final int dimension;
	private double min=0;
	private double max=Math.PI;
	private double m=10;
	
	public IndividuoMichalewiczB(double tolerance, int id, int numGenes,int dimension) {
		super(tolerance, id, numGenes);
		this.dimension=dimension;
		Random rnd= new Random();
		this.numGenes=1;
		this.cromosoma= new Cromosoma(this.numGenes); //cada gen es un nº real
	
		for(int i=0;i<numGenes;i++) {
			RealGen r=new RealGen(rnd.nextDouble(min, max));
			this.cromosoma.setGen(r, i);
			
		}
	}

	@Override
	protected boolean mutateSelf(int pos, Random rnd, double probability) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Calculates the fenotype but in this case fenotype=allele
	 */
	@Override
	protected void calculateFenotype() {
		// TODO Auto-generated method stub
		fenotype= new double[this.numGenes];
		fenotype[0]=this.cromosoma.getGen(0).getAllele(); 
	}

	@Override
	public void evaluateSelf() {
		
		double fitness=Math.sin(fenotype[0]*Math.sin(Math.pow(Math.pow(fenotype[0],2),2*m)));
		setFitness(fitness);
	}

}
