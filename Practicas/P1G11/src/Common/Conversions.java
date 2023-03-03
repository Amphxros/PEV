package Common;

import Common.Genes.BooleanGen;
import Common.Genes.Gen;

public class Conversions {
	public static <T> double binaryToDecimal(Cromosoma<T> genes) {
		double decimal=0.0f;
		int index=0;
		for(Gen<T> allele: genes.getCromosome()) {
			if(allele.toString()=="1") {
				decimal+=Math.pow(2,index);
			}
			index++;
		}
		
		
		return decimal;
	}

	public static double BinaryToDecimal(Cromosoma<Boolean> cromosoma) {
		// TODO Auto-generated method stub
		double decimal=0.0f;
		int index=0;
		for(Gen<Boolean> allele: cromosoma.getCromosome()) {
			if(allele.toString()=="1") {
				decimal+=Math.pow(2,index);
			}
			index++;
		}
		
		
		return decimal;
	}
}
