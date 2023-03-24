package Common;

public class Gen {
	int allele;//index of the city
	
	public Gen(int allele) {
		this.allele=allele;
	}
	/**
	 * @return the index of the city in {@link CityData} array of cities
	 */
	public int getAllele() {
		return this.allele;
	}
	
	/**
	 * Sets the city in the gen
	 * @param allele
	 */
	public void setAllele(int allele) {
		this.allele=allele;
	}
	
	/**
	 * @return the name of the city that has that index
	 */
	public String getFenotype() {
		return CityData.getName(allele);
	}
	
	
	
}
