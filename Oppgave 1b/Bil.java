/*

Programutvikling v�r 2014
Obligatorsik Oppgave
Oppgave 1: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

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
	}	// end of konstrukt�r



	public String getRegNr()
	{
		return regNr;
	}	// end of metode getRegNr()



	public String toString()
	{
		return "Regnr: " + regNr +
					 "\nMerke: " + merke +
					 "\nType: " + type +
					 "\n�rstall: " + regAr + "\n\n";
	}	// end of metode toString()


}	// end of class Bil