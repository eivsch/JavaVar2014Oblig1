/*

Programutvikling v�r 2014
Obligatorsik Oppgave
Oppgave 1a: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

*/

public class Billiste
{
	private Bil f�rste;


	public Billiste()
	{
		f�rste = null;

	}	// end of konstrukt�r



	public void settInnNy( Bil ny )
	{
    ny.neste = f�rste;
    f�rste = ny;
	}	// end of metode settInnNy()



	public Bil finn( String r )
	{
		if( f�rste == null )
			return null;

		Bil l�per = f�rste;

		while( l�per != null )
		{
			if( l�per.getRegNr().equals(r) )
				return l�per;

			//if( l�per == null )
			//	return null;

		  l�per = l�per.neste;
	 	}
		return null;
	}	// end of metode finn()



	public boolean fjern( String r )
	{
		if ( tomListe() ) //tom liste
		{
			System.out.println("1");
			return false;
		}

		//hvis vi skal fjerne den f�rste
    if (f�rste.getRegNr().equals(r) ){
			System.out.println("2");
			f�rste = f�rste.neste;
			return true;
		}

   	Bil l�per = f�rste;

		while( l�per.neste != null )
		{
			System.out.println("3");
			if( l�per.neste.getRegNr().equals(r) )
			{
				System.out.println("4");
				l�per.neste = l�per.neste.neste;
				return true;
			}
			System.out.println("5");
			l�per = l�per.neste;
		}
System.out.println("6");
		return false;
	}	// end of metode fjern()



	public boolean tomListe()
	{
		if (f�rste == null)
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
			Bil l�per = f�rste;
			while ( l�per != null)
			{
			 utskrift += l�per.toString();
			 l�per = l�per.neste;
			}
			utskrift += "\n\n";

			return utskrift;
		}


	}	// end of metode listeInfo()


}	// end of class Billiste