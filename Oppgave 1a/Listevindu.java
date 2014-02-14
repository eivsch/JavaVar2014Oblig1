/*

Programutvikling vår 2014
Obligatorsik Oppgave
Oppgave 1: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Listevindu extends JFrame
{
  private JTextField regNrFelt, merkeFelt, typeFelt, arFelt, finnFelt, fjernFelt;
  private JTextArea output;
  private JButton settInn, finnBil, fjernBil, skrivInfo;
  private Billiste billiste;
  private Lytter lytter;

  public Listevindu()
  {
    super( "Bil-register" );
    lytter = new Lytter();

    Container c = getContentPane();
    c.setLayout( new FlowLayout() );

    c.add( new JLabel( "Registreringsnummer: " ) );
    regNrFelt = new JTextField( 10 );
    c.add( regNrFelt );

    c.add( new JLabel( "Bilmerke: " ) );
    merkeFelt = new JTextField( 10 );
    c.add( merkeFelt );

    c.add( new JLabel( "Biltype: " ) );
    typeFelt = new JTextField( 10 );
    c.add( typeFelt );

    c.add( new JLabel( "Årstall: " ) );
    arFelt = new JTextField( 10 );
    c.add( arFelt );

    settInn = new JButton( "Registrer bil" );
    settInn.addActionListener( lytter );
    c.add( settInn );

		c.add( new JLabel( "Finn bil (regnr): " ) );
		finnFelt = new JTextField( 10 );
    finnFelt.addActionListener( lytter );
    c.add( finnFelt );

    finnBil = new JButton( "Finn bil" );
    finnBil.addActionListener( lytter );
    c.add( finnBil );

 		c.add( new JLabel( "Fjern bil (regnr): " ) );
 		fjernFelt = new JTextField( 10 );
		fjernFelt.addActionListener( lytter );
		c.add( fjernFelt );

		fjernBil = new JButton( "Fjern bil" );
		fjernBil.addActionListener( lytter );
    c.add( fjernBil );

    skrivInfo = new JButton( "Skriv ut" );
    skrivInfo.addActionListener( lytter );
    c.add( skrivInfo );

    c.add( new JLabel( "Liste:" ) );
    output = new JTextArea( 10, 45 );
    output.setEditable( false );
    c.add( new JScrollPane( output ) );

    billiste = new Billiste();

    setSize( 550, 400 );
    setVisible( true );
  }	// end of konstruktør



  public void settInnNy()
  {
		if( regNrFelt.getText() == null || merkeFelt.getText() == null ||
				typeFelt.getText() == null || arFelt.getText() == null )
		{
			JOptionPane.showMessageDialog( null, "Du må fylle ut alle feltene",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			return;
		}

    int r = Integer.parseInt( regNrFelt.getText() );
    String m = merkeFelt.getText();
    String t = typeFelt.getText();
    int a = Integer.parseInt( arFelt.getText() );

		Bil b = new Bil( r, m, t, a );
    billiste.settInnNy( b );
    regNrFelt.setText( "" );

    output.setText( "Bil med reg.nr. " + r + " registrert" );
  }	// end of metode settInnNy()



  public void finnBil()
  {
		if( finnFelt.getText() == null )
		{
			JOptionPane.showMessageDialog( null, "Du må fylle skrive reg.nr.",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			return;
		}

    int f = Integer.parseInt( finnFelt.getText() );

    Bil b = billiste.finn( f );
    finnFelt.setText( "" );

    output.setText( b.toString() );
  }	// end of metode finnBil()



  public void fjernBil()
  {
		if( fjernFelt.getText() == null )
		{
			JOptionPane.showMessageDialog( null, "Du må fylle skrive reg.nr.",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			return;
		}

		fjernFelt.setText( "" );

    int f = Integer.parseInt( fjernFelt.getText() );

    if( billiste.fjern(f) )
    	output.setText( "Bil med reg.nr. " + f + " fjernet" );
    else
    	output.setText( "Bil med reg.nr. " + f + " finnes ikke" );
  }	// end of metode fjernBil()



	public void skrivListe()
	{
		utskrift = billiste.listeInfo();

		if( utskrift == null )
			output.setText( "Ingen bil registrert" );
		else
			output.setText( utskrift );

  }	// end of metode skrivListe()


  private class Lytter implements ActionListener
  {
    public void actionPerformed( ActionEvent e )
    {
      if ( e.getSource() == settInn )
      {
        settInnNy();
      }
      else if ( e.getSource() == finnBil || e.getSource() == finnFelt )
      {
				finnBil();
      }
      else if ( e.getSource() == fjernBil || e.getSource() == fjernFelt )
      {

      }
      else if ( e.getSource() == skrivInfo )
      {

      }
    }	// end of metode actionPerformed()
  }	// end of inner class Lytter
}	// end of class Listevindu