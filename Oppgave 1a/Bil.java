/*

Programutvikling vår 2014
Obligatorisk Oppgave
Oppgave 1a: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/

public class Bil
{
	private int regAr;
	private String regNr, merke, type;
	Bil neste;

	public Bil( String nr, String m, String t, int ar )
	{
		regNr = nr;
		merke = m;
		type = t;
		regAr = ar;
		neste = null;
	}	// end of konstruktør



	public String getRegNr()
	{
		return regNr;
	}	// end of metode getRegNr()



	public String toString()
	{
		return "Regnr: " + regNr +
					 "\nMerke: " + merke +
					 "\nType: " + type +
					 "\nÅrstall: " + regAr + "\n\n";
	}	// end of metode toString()


}	// end of class Bil