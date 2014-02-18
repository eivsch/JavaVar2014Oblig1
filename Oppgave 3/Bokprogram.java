/*

Programutvikling vår 2014
Obligatorsik Oppgave
Oppgave 3

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/

import java.awt.event.*;
import javax.swing.*;

public class Bokprogram
{
  public static void main( String[] args )
  {
    final Bokarkiv vindu = new Bokarkiv();
    vindu.addWindowListener(
      new WindowAdapter() {
        public void windowClosing( WindowEvent e )
        {
					vindu.skrivTilFil( "arkiv.data" );
          System.exit( 0 );
        }
      } );
  }


}
