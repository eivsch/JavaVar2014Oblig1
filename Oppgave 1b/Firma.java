/*
 *
 *
 *
 */
 public class Firma extends Bileier
 {
	 private long foretaksNr;

	 public Firma (String navn, String adresse, long foretaksNr)
	 {
		 super(navn, adresse);
		 this.foretaksNr = foretaksNr;
	 }
	 public String toString()
	 {
		 String s = super.toString() + "\nForetaksnummer: " + foretaksNr;
		 return s;
	 }
	 public long getForetaksNr()
	 {
		 return foretaksNr;
	 }
 }