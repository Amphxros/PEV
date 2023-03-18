package AGPractica1.Ej1;

import java.util.Random;

import Common.Conversions;
import Common.Cromosoma;
import Common.Individuo;
import Common.Genes.BooleanGen;
import Common.Genes.Gen;

public class IndividuoCalibracion extends Individuo<Boolean,Double>{

	// x1 = 11.625 y x2 = 5.726 x1 [-3.0,12.1] x2 [4.1,5.8]
		private final double minX1=-3.000;
		private final double maxX1=12.100;

		private final double minX2=4.100;
		private final double maxX2=5.800;

		
		private final double[] min= {minX1,minX2};
		private final double[] max= {maxX1,maxX2};
		
	
	public IndividuoCalibracion(double tolerance, int id, int numGenes) {
		super(tolerance, id, numGenes);
		createCromosome();
		calculateFenotype();
		
	}
	
	@Override
	public void createCromosome() {
		for(int i=0;i<this.numGenes;i++) {
			this.cromosoma.genes[i]= new BooleanGen(min[i],max[i],this.tolerance);
		
		}
		this.cromosoma.initCromosome();
		
	}
	@Override
	public void evaluateSelf() {
		// TODO Auto-generated method stub
		calculateFenotype();
		double x1=this.cromosoma.genes[0].fenotype();
		double x2=this.cromosoma.genes[1].fenotype();
		setFitness(f(x1,x2));
		
	}
	
	private double f(double x1, double x2) {
		return 21.5 + x1*Math.sin(4*Math.PI*x1) + x2*Math.sin(20*Math.PI*x2);
	}
	@Override
	public boolean mutateSelf(int pos, Random rnd, double probability) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected void calculateFenotype() {
		// TODO Auto-generated method stub
		this.fenotype= new Double[this.numGenes];
		double x1=this.cromosoma.genes[0].fenotype();
		double x2=this.cromosoma.genes[1].fenotype();
		this.fenotype[0]=x1;
		this.fenotype[1]=x2;
	}
	
}
