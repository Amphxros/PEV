package Common;

import AGPractica1.Ej1.IndividuoCalibracion;
import AGPractica1.Ej2.IndividuoGrieWank;
import AGPractica1.Ej3.IndividuoStyblinskiTang;
import AGPractica1.Ej4A.IndividuoMichalewiczA;
import AGPractica1.Ej4B.IndividuoMichalewiczB;

/**
 * Factoria de individuos
 * @author Amph
 *
 */
public class IndividuoFactory {
	
	/**
	 * 
	 * @param typeFunction number of exercise
	 * @param idFuncion position in the poblation array
	 * @param tolerance 
	 * @param nGenes
	 * @return a new concrete Individual based of the function
	 */
	public static Individuo getIndividuo(int typeFunction,int idFuncion, double tolerance, int nGenes){
	
		switch(typeFunction) {
		case 1:
			return new IndividuoCalibracion(tolerance, idFuncion, nGenes);
		case 2: 
			return new IndividuoGrieWank(tolerance, idFuncion, nGenes);
		case 3: 
			return new IndividuoStyblinskiTang(tolerance, idFuncion, nGenes);
		case 4: 
			return new IndividuoMichalewiczA(tolerance, idFuncion, nGenes,2);
		case 5: 
			return new IndividuoMichalewiczB(tolerance, idFuncion, nGenes);
		
		}
		return null;
		
	}
}
