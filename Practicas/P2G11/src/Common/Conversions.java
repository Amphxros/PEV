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

}

