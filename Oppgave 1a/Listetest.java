/*

Programutvikling vår 2014
Obligatorsik Oppgave
Oppgave 1: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/

import java.awt.event.*;

public class Listetest
{
  public static void main( String[] args )
  {
    Listevindu vindu = new Listevindu();
    //final for å kunne gjøre aksess på lokal variabel fra anonym indre klasse
  	vindu.addWindowListener(
  			new WindowAdapter() {
  				public void windowClosing( WindowEvent e )
  				{
  					System.exit( 0 );
  				}
  			} );
  	}
}
