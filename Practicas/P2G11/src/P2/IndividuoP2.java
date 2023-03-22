package P2;

import java.util.Random;

import Common.Individuo;
import Common.Genes.Gen;

public class IndividuoP2 extends Individuo<Double,String> {

	public IndividuoP2(int id) {
		super(1, id, 27);
		this.cromosoma.genes= new Gen[this.numGenes];
		
	}

	@Override
	public void createCromosome() {
		boolean included[] = new boolean[this.numGenes+1];
		int city;
		for(int i=0;i<this.numGenes;i++) {
			included[i]=false;
		}
		
		for(int i=0;i<this.numGenes;i++) {
			do{
				city = (int) (Math.random()*(numGenes+1));
			} 
			while(included[city] || city== 25);
			
			//this.cromosoma.genes[i]= new RealGen()
			included[city]=true;
		}
		
	}

	@Override
	public void evaluateSelf() {
		int fitness=0; 
		int city=25;
		for(int i=0;i<this.numGenes;i++) {
		
		}
	}

	@Override
	public boolean mutateSelf(int pos, Random rnd, double probability) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void calculateFenotype() {
		this.fenotype= new String[this.numGenes];
		for(int i=0;i<this.numGenes;i++) {
			int city= (int) this.cromosoma.genes[i].fenotype();
			this.fenotype[i]= city + "-->";
		}
		
	}

}
