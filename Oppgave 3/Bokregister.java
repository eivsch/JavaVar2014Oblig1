import javax.swing.JTextArea;

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



