package AGPractica1.Ej1;

import java.util.Random;

import Common.Conversions;
import Common.Cromosoma;
import Common.Individuo;
import Common.Genes.BooleanGen;
import Common.Genes.Gen;

public class IndividuoCalibracion extends Individuo<Boolean, Double>{

	// x1 = 11.625 y x2 = 5.726 x1∈ [-3.0,12.1] x2∈ [4.1,5.8]
	private final double minX1=-3.000;
	private final double maxX1=12.100;

	private final double minX2=4.100;
	private final double maxX2=5.800;
	
	private int tamX1 = 0;
	private int tamX2 = 0;
	
	public IndividuoCalibracion(double tolerance, int id, int numGenes) {
		super(tolerance, id, numGenes);
		// TODO Auto-generated constructor stub
		tamX1 =this.tamGen(this.tolerance, minX1, maxX1);
		tamX2 =this.tamGen(this.tolerance, minX2, maxX2);
		
		this.cromosoma= new Cromosoma(tamX1 + tamX2);
		
		Random rnd= new Random();
		
		for(int i = 0 ;i<  tamX1 + tamX2;i++) {
			BooleanGen g= new BooleanGen(rnd.nextBoolean());
			this.cromosoma.setGen(g, i);
		}
		
		calculateFenotype();
		

	
	}

	
	/**
	 * /**
	 * Calculate the fitness in this case f(x,y)= 21.5 + x*sen(4πx)+ y*sen(20πy)
	 */
	@Override
	public void evaluateSelf() {
		final double fitness_;
		if (fenotype.length == 2) {
			double x1= fenotype[0];
			double x2= fenotype[1];
			
			
			fitness_=(21.5 + x1*Math.sin(4*Math.PI*x1)) + x2*Math.sin(20*Math.PI*x2); //f(x1 , x2) = 21.5 + x1.sin(4π x1)+x2.sin(20π x2)
			
		}
		else {
			fitness_=Double.MIN_VALUE;
			System.out.println("Ejer 1: Wrong fitness params.");
		}
		
		setFitness(fitness_);
		
	}



	/**
	 * 
	 */
	@Override
	protected boolean mutateSelf(int pos, Random rnd, double probability) {
		if(rnd.nextDouble()<probability) {
			this.cromosoma.setGen(new BooleanGen(rnd.nextBoolean()), pos);
			return true;
		}
		return false;
	}

	/**
	 * 
	 */
	@Override
	protected void calculateFenotype() {
		// TODO Auto-generated method stub
		this.fenotype= new Double[2];
		Cromosoma cromosome1 = new Cromosoma(tamX1);
		Cromosoma cromosome2 = new Cromosoma(tamX2);
		
		for(int i = 0; i < tamX1; i++) {
			
			
			cromosome1.setGen(this.cromosoma.getGen(i), i);
		}
		
		for(int i = 0; i < tamX2; i++) {
			cromosome2.setGen(this.cromosoma.getGen(i + tamX1), i);
		}
		
		
		fenotype[0]= minX1 + (maxX1 - minX1) *(Conversions.binaryToDecimal(cromosome1)) / (Math.pow(2, tamX1) - 1);
		fenotype[1]= minX2 + (maxX2 - minX2) *(Conversions.binaryToDecimal(cromosome2))/ (Math.pow(2, tamX2) - 1);
	}

}
