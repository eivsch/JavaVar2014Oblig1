/*

Programutvikling vår 2014
Obligatorsik Oppgave
Oppgave 3

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/
import javax.swing.JTextArea;
import java.io.*;

public class Bokregister
{
  private Bok første;

  //registrerer et bokobjekt
  public void settInnForrest( Bok ny )  // sortert
  { if(ny == null) return;
    ny.neste = første;
    første = ny;
  }
  public void settInn( Bok ny )
	{
    if( ny == null ) return;

    if( første == null ) // tom liste:
    {
      første = ny;
      return;
    }
					// objektet skal inn forrest:
    if( ( ny.getForfatter().compareToIgnoreCase( første.getForfatter() ) == 0 &&
          ny.getTittel().compareTo( første.getTittel() ) < 0 )
		 || ( ny.getForfatter().compareTo( første.getForfatter() ) < 0 ) )
    {
	    settInnForrest( ny );
      return;
    }

    Bok løper = første;
    while( løper.neste != null )
    {
      if( ( ny.getForfatter().compareTo(løper.neste.getForfatter() ) == 0 &&
            ny.getTittel().compareTo(løper.neste.getTittel() ) < 0 )
       || ( ny.getForfatter().compareTo(løper.neste.getForfatter() ) < 0 ) )
      {
        ny.neste = løper.neste;
        løper.neste = ny;
					  return;
      }
      else
        løper = løper.neste;
    }
   // setter inn boka sist i lista.
    løper.neste = ny;
  }

  public void skrivBokTilFil( DataOutputStream output )
  {
    if ( første == null )
      return;
    else
    {
      Bok løper = første;
      while ( løper != null )
      {
        løper.skrivObjektTilFil( output );
        løper = løper.neste;
      }
    }
	}

	public void lesBokFraFil( DataInputStream input )
	{
      try
			{
				while ( true )
				{
					String type = input.readUTF();

					if( type.equals( "Skolebok" ) )
					{
						Skolebok temp = new Skolebok();
						if( temp.lesObjektFraFil(input) )
							settInn( temp );
					}
					else if( type.equals( "Fagbok" ) )
					{
						Fagbok temp = new Fagbok();
						if( temp.lesObjektFraFil(input) )
						{
							settInn( temp );
						}
					}
					else if( type.equals( "NorskRoman" ) )
					{
						NorskRoman temp = new NorskRoman();
						if( temp.lesObjektFraFil(input) )
							settInn( temp );
					}
					else if( type.equals( "UtenlandskRoman" ) )
					{
						UtenlandskRoman temp = new UtenlandskRoman();
						if( temp.lesObjektFraFil(input) )
							settInn( temp );
					}
				}
			}
			catch( FileNotFoundException fnfe )
			{
				System.out.println( "Bokregister.java - finner ikke fil " );
			}
			catch( EOFException eofe )
			{
				System.out.println( "slutt på fil" );
			}
			catch( IOException ioe )
			{
				System.out.println( "Bokregister.java - Filproblemer" );
			}
    }


  //utskrift av innhold i bokliste
  public void skrivListe( JTextArea bøker )
  {
    if ( første == null )
      bøker.append( "Ingen bøker registrert." );
    else
    {
      bøker.setText( "" );
      Bok løper = første;
      while ( løper != null )
      {
        bøker.append( løper.toString() + "\n" );
        løper = løper.neste;
      }
    }
  }
}



