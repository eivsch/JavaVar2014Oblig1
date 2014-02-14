/*
 *
 *
 *
 */
 public class Firma extends Bileier
 {
	 private long foretaksNr;

	 public Firma (String navn, String adresse, Billiste biler, long foretaksNr)
	 {
		 super(navn, adresse, biler);
		 this.foretaksNr = foretaksNr;
	 }
	 public String toString()
	 {
		 String s = super.toString() + "\nForetaksnummer: " + foretaksNr;
		 return s;
	 }
 }