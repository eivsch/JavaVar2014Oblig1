import javax.swing.JTextArea;

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



