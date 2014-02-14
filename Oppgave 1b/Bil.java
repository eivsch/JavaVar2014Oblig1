/*

Programutvikling vår 2014
Obligatorsik Oppgave
Oppgave 1: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/

public class Bil
{
	private int regNr, regAr;
	private String merke, type;
	private Bil neste;

	public Bil( int nr, String m, String t, int ar )
	{
		regNr = nr;
		merke = m;
		type = t;
		regAr = ar;
		neste = null;
	}	// end of konstruktør



	public int getRegNr()
	{
		return regNr;
	}	// end of metode getRegNr()



	public String toString()
	{
		return "Regnr: " + regNr +
					 "\nMerke: " + merke +
					 "\nType: " + type +
					 "\nÅrstall: " + regAr + "\n";
	}	// end of metode toString()


}	// end of class Bil