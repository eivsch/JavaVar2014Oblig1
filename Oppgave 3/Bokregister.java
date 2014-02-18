/*

Programutvikling v�r 2014
Obligatorsik Oppgave
Oppgave 3

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

*/
import javax.swing.JTextArea;
import java.io.*;

public class Bokregister
{
  private Bok f�rste;

  //registrerer et bokobjekt
  public void settInnForrest( Bok ny )  // sortert
  { if(ny == null) return;
    ny.neste = f�rste;
    f�rste = ny;
  }
  public void settInn( Bok ny )
	{
    if( ny == null ) return;

    if( f�rste == null ) // tom liste:
    {
      f�rste = ny;
      return;
    }
					// objektet skal inn forrest:
    if( ( ny.getForfatter().compareToIgnoreCase( f�rste.getForfatter() ) == 0 &&
          ny.getTittel().compareTo( f�rste.getTittel() ) < 0 )
		 || ( ny.getForfatter().compareTo( f�rste.getForfatter() ) < 0 ) )
    {
	    settInnForrest( ny );
      return;
    }

    Bok l�per = f�rste;
    while( l�per.neste != null )
    {
      if( ( ny.getForfatter().compareTo(l�per.neste.getForfatter() ) == 0 &&
            ny.getTittel().compareTo(l�per.neste.getTittel() ) < 0 )
       || ( ny.getForfatter().compareTo(l�per.neste.getForfatter() ) < 0 ) )
      {
        ny.neste = l�per.neste;
        l�per.neste = ny;
					  return;
      }
      else
        l�per = l�per.neste;
    }
   // setter inn boka sist i lista.
    l�per.neste = ny;
  }

  public void skrivBokTilFil( DataOutputStream output )
  {
    if ( f�rste == null )
      return;
    else
    {
      Bok l�per = f�rste;
      while ( l�per != null )
      {
        l�per.skrivObjektTilFil( output );
        l�per = l�per.neste;
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
					System.out.println(type);

					if( type.equals( "Skolebok" ) )
					{
						Skolebok temp = new Skolebok();
						if( temp.lesObjektFraFil(input) )
							settInn( temp );
					}
					else if( type.equals( "Fagbok" ) )
					{
						System.out.println("3");
						Fagbok temp = new Fagbok();
						if( temp.lesObjektFraFil(input) )
						{
							System.out.println("4");
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
				System.out.println( "slutt p� fil" );
			}
			catch( IOException ioe )
			{
				System.out.println( "Bokregister.java - Filproblemer" );
			}
    }


  //utskrift av innhold i bokliste
  public void skrivListe( JTextArea b�ker )
  {
    if ( f�rste == null )
      b�ker.append( "Ingen b�ker registrert." );
    else
    {
      b�ker.setText( "" );
      Bok l�per = f�rste;
      while ( l�per != null )
      {
        b�ker.append( l�per.toString() + "\n" );
        l�per = l�per.neste;
      }
    }
  }
}



