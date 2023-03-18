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
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createCromosome() {
		for(int i=0;i<this.numGenes;i++) {
			this.cromosoma.genes[i]= new BooleanGen(min,max,this.tolerance);
		
		}
		this.cromosoma.initCromosome();
	}

	@Override
	public void evaluateSelf() {
		// TODO Auto-generated method stub
		calculateFenotype();
		if(this.fenotype.length==dimension) {
			setFitness(f());
		}
	}

	private double f() {
		double fen=0;
		for(int i=0;i<this.fenotype.length; i++) {
			double xi= this.fenotype[i];
			fen+=(Math.pow(xi, 4) - 16*Math.pow(xi, 2) + 5*xi);
		}
		fen*=0.5;
		return fen;
		
	}
	@Override
	public boolean mutateSelf(int pos, Random rnd, double probability) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void calculateFenotype() {
		this.fenotype= new Double[this.numGenes];
		double x1=this.cromosoma.genes[0].fenotype();
		double x2=this.cromosoma.genes[1].fenotype();
		this.fenotype[0]=x1;
		this.fenotype[1]=x2;
		
	}
	
	
	

}
