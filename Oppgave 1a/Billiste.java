/*

Programutvikling vår 2014
Obligatorisk Oppgave
Oppgave 1a: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/

public class Billiste
{
	private Bil første;


	public Billiste()
	{
		første = null;

	}	// end of konstruktør



	public void settInnNy( Bil ny )
	{
    ny.neste = første;
    første = ny;
	}	// end of metode settInnNy()



	public Bil finn( String r )
	{
		if( første == null )
			return null;

		Bil løper = første;

		while( løper != null )
		{
			if( løper.getRegNr().equals(r) )
				return løper;

			//if( løper == null )
			//	return null;

		  løper = løper.neste;
	 	}
		return null;
	}	// end of metode finn()



	public boolean fjern( String r )
	{
		if ( tomListe() ) //tom liste
		{
			return false;
		}

		//hvis vi skal fjerne den første
    if (første.getRegNr().equals(r) ){
			første = første.neste;
			return true;
		}

   	Bil løper = første;

		while( løper.neste != null )
		{
			if( løper.neste.getRegNr().equals(r) )
			{
				løper.neste = løper.neste.neste;
				return true;
			}
			løper = løper.neste;
		}
		return false;
	}	// end of metode fjern()



	public boolean tomListe()
	{
		if (første == null)
			return true;
		else
			return false;
	}	// end of metode tomListe()



	public String listeInfo()
	{
		String utskrift = "";

		if ( tomListe() )
			return "Tom liste";
		else
		{
			Bil løper = første;
			while ( løper != null)
			{
			 utskrift += løper.toString();
			 løper = løper.neste;
			}
			utskrift += "\n\n";

			return utskrift;
		}


	}	// end of metode listeInfo()


}	// end of class Billiste