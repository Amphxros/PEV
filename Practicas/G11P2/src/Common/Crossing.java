package Common;

public class Crossing {
	
	public enum Type{
		PMX,
		OX, 
		OXVarianteA,
		OXVarianteB,
		CX, 
		ERX, 
		CO,
		Own
	}
	
	public static Cromosoma[] PMXCrossOver(Cromosoma[] population, double probability) {
		return population;
		
	}
	public static Cromosoma[] OXCrossOver(Cromosoma[] population, double probability) {
		return population;
		
	}
	
	public static Cromosoma[] OXVarACrossOver(Cromosoma[] population, double probability) {
		return population;
		
	}
	public static Cromosoma[] OXVarBCrossOver(Cromosoma[] population, double probability) {
		return population;
		
	}
	
	public static Cromosoma[] CXCrossOver(Cromosoma[] population, double probability) {
		return population;
		
	}
	
	public static Cromosoma[] ERXCrossOver(Cromosoma[] population, double probability) {
		return population;
		
	}
	public static Cromosoma[] COCrossOver(Cromosoma[] population, double probability) {
		return population;
		
	}
	
	
}
