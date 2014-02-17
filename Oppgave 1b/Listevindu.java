/*

Programutvikling v�r 2014
Obligatorsik Oppgave
Oppgave 1b: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Listevindu extends JFrame
{
  private JTextField navnFelt, adrFelt, pnrFelt, fnrFelt;
  private JButton regPerson, regFirma;

  private JTextField regNrFelt, merkeFelt, typeFelt, arFelt, finnFelt, fjernFelt, fjernEierFelt;
  private JTextArea output;
  private JButton regBilPerson, regBilFirma, finnBil, fjernBil, fjernEier, skrivInfo;
  private Bileierliste bileierliste;
  private Lytter lytter;

  public Listevindu()
  {
    super( "Bil-register" );
    lytter = new Lytter();

    Container c = getContentPane();
    c.setLayout( new FlowLayout() );

    c.add( new JLabel( "Navn: " ) );
    navnFelt = new JTextField( 12 );
    c.add( navnFelt );

    c.add( new JLabel( "Adresse: " ) );
    adrFelt = new JTextField( 15 );
    c.add( adrFelt );

    c.add( new JLabel( "Personnummer: " ) );
    pnrFelt = new JTextField( 8 );
    c.add( pnrFelt );

		c.add( new JLabel( "Foretaksnummer: " ) );
		fnrFelt = new JTextField( 6 );
    c.add( fnrFelt );

    regPerson = new JButton( "Registrer person" );
    regPerson.addActionListener( lytter );
    c.add( regPerson );

    regFirma = new JButton( "Registrer firma" );
    regFirma.addActionListener( lytter );
    c.add( regFirma );

		c.add( new JLabel( "******************************************************************************" ) );

    c.add( new JLabel( "Bilmerke: " ) );
    merkeFelt = new JTextField( 10 );
    c.add( merkeFelt );

    c.add( new JLabel( "Biltype: " ) );
    typeFelt = new JTextField( 10 );
    c.add( typeFelt );

    c.add( new JLabel( "Registreringsnummer: " ) );
    regNrFelt = new JTextField( 6 );
    c.add( regNrFelt );

    c.add( new JLabel( "�rstall: " ) );
    arFelt = new JTextField( 5 );
    c.add( arFelt );


    regBilPerson = new JButton( "Registrer bil p� person" );
    regBilPerson.addActionListener( lytter );
    c.add( regBilPerson );

    regBilFirma = new JButton( "Registrer bil p� firma" );
    regBilFirma.addActionListener( lytter );
    c.add( regBilFirma );

		c.add( new JLabel( "******************************************************************************" ) );

		c.add( new JLabel( "Finn bil (regnr): " ) );
		finnFelt = new JTextField( 10 );
    finnFelt.addActionListener( lytter );
    c.add( finnFelt );

    finnBil = new JButton( "         Finn bil         " );
    finnBil.addActionListener( lytter );
    c.add( finnBil );

 		c.add( new JLabel( "Fjern bil (regnr): " ) );
 		fjernFelt = new JTextField( 10 );
		fjernFelt.addActionListener( lytter );
		c.add( fjernFelt );

		fjernBil = new JButton( "            Fjern bil            " );
		fjernBil.addActionListener( lytter );
    c.add( fjernBil );

 		c.add( new JLabel( "Fjern eier: " ) );
 		fjernEierFelt = new JTextField( 10 );
		fjernEierFelt.addActionListener( lytter );
		c.add( fjernEierFelt );

		fjernEier = new JButton( "              Fjern eier              " );
		fjernEier.addActionListener( lytter );
    c.add( fjernEier );

    skrivInfo = new JButton( "Skriv ut" );
    skrivInfo.addActionListener( lytter );
    c.add( skrivInfo );


    output = new JTextArea( 15, 35 );
    output.setEditable( false );
    c.add( new JScrollPane( output ) );

    bileierliste = new Bileierliste();

    setSize( 433, 640 );
    setVisible( true );
  }	// end of konstrukt�r



  public void regBilPerson()
  {
		if( regPerson.getText() == null || regNrFelt.getText() == null || merkeFelt.getText() == null ||
				typeFelt.getText() == null || arFelt.getText() == null )
		{
			JOptionPane.showMessageDialog( null, "Du m� fylle ut personnummer, registreringsnummer, bilmerke, biltype og �rstall",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			return;
		}

		Long pnr = Long.parseLong( pnrFelt.getText() );

    String r = regNrFelt.getText();
    String m = merkeFelt.getText();
    String t = typeFelt.getText();
    int ar = Integer.parseInt( arFelt.getText() );

		Bil b = new Bil( r, m, t, ar );

    if( bileierliste.finnBileier( pnr ) == null )
		{
			output.setText( "Finner ikke personnummer " + pnr );
			return;
		}

		bileierliste.finnBileier( pnr ).regBil( b );

    output.setText( "Bil med reg.nr. " + r + " registrert p� personnummer " + pnr );

		pnrFelt.setText( "" );
		regNrFelt.setText( "" );
		merkeFelt.setText( "" );
		typeFelt.setText( "" );
		arFelt.setText( "" );
  }	// end of metode regBilPerson()



  public void regBilFirma()
  {
		if( regFirma.getText() == null || regNrFelt.getText() == null || merkeFelt.getText() == null ||
				typeFelt.getText() == null || arFelt.getText() == null )
		{
			JOptionPane.showMessageDialog( null, "Du m� fylle ut foretaksnummer, registreringsnummer, bilmerke, biltype og �rstall",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			return;
		}

		Long fnr = Long.parseLong( fnrFelt.getText() );

    String r = regNrFelt.getText();
    String m = merkeFelt.getText();
    String t = typeFelt.getText();
    int ar = Integer.parseInt( arFelt.getText() );

		Bil b = new Bil( r, m, t, ar );

    if( bileierliste.finnBileier( fnr ) == null )
		{
			output.setText( "Finner ikke foretaksnummer " + fnr );
			return;
		}

		bileierliste.finnBileier( fnr ).regBil( b );

    output.setText( "Bil med reg.nr. " + r + " registrert p� foretaksnummer " + fnr );

		fnrFelt.setText( "" );
		regNrFelt.setText( "" );
		merkeFelt.setText( "" );
		typeFelt.setText( "" );
		arFelt.setText( "" );
  }	// end of metode regBilFirma()





  public void finnBileierInfo()
  {
		if( finnFelt.getText().equals("") )
		{
			JOptionPane.showMessageDialog( null, "Du m� fylle skrive reg.nr.",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			return;
		}

    String f = finnFelt.getText();


    Bileier b = bileierliste.finnBileier( f );

		if( b == null )
			output.setText( "Finner ikke bil med reg.nr. " + f);
		else
    	output.setText( b.toString() );

    finnFelt.setText( "" );
  }	// end of metode finnBil()




  public void fjernBil()
  {
		if( fjernFelt.getText().equals("") )
		{
			JOptionPane.showMessageDialog( null, "Du m� fylle ut reg.nr.",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			return;
		}

    String f = fjernFelt.getText();

		output.setText( bileierliste.finnBileier(f).fjernBil(f) );

		fjernFelt.setText( "" );
  }	// end of metode fjernBil()




	public void fjernEier()
	{
		if( fjernEierFelt.getText().equals("") )
		{
			JOptionPane.showMessageDialog( null, "Du m� fylle ut personnummer eller foretaksnummer",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			return;
		}

		Long nr = Long.parseLong( fjernEierFelt.getText() );

		output.setText( bileierliste.fjernEier(nr) );

	}	// end of metode fjernEier()




	public void skrivListe()
	{
		String utskrift = bileierliste.toString();

		if( utskrift == "" )
			output.setText( "Ingen bileier registrert" );
		else
			output.setText( utskrift );

  }	// end of metode skrivListe()



	public void nyPerson()
	{
		if( navnFelt.getText().equals("") || adrFelt.getText().equals("") || pnrFelt.getText().equals("") )
		{
			JOptionPane.showMessageDialog( null, "Du m� fylle ut navn, adresse og personnumer",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			return;
		}

    String navn = navnFelt.getText();
		String adr = adrFelt.getText();
		Long pnr = Long.parseLong( pnrFelt.getText() );

		Person p = new Person( navn, adr, pnr );

		bileierliste.settInnBileier( p );

		output.setText( "Ny person registrert" );
		navnFelt.setText( "" );
		adrFelt.setText( "" );
		pnrFelt.setText( "" );
		fnrFelt.setText( "" );
	}	// end of metode nyPerson()



	public void nyFirma()
	{
		if( navnFelt.getText().equals("") || adrFelt.getText().equals("") || fnrFelt.getText().equals("") )
		{
			JOptionPane.showMessageDialog( null, "Du m� fylle ut navn, adresse og foretaksnumer",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			return;
		}

    String navn = navnFelt.getText();
		String adr = adrFelt.getText();
		Long fnr = Long.parseLong( fnrFelt.getText() );

		Firma f = new Firma( navn, adr, fnr );

		bileierliste.settInnBileier( f );

		output.setText( "Nytt firma registrert" );

	}	// end of metode nyFirma()



  private class Lytter implements ActionListener
  {
    public void actionPerformed( ActionEvent e )
    {
      //try
      //{
				if ( e.getSource() == regBilPerson )
				{
					regBilPerson();
				}
				else if ( e.getSource() == regBilFirma )
				{
					regBilFirma();
				}
				else if ( e.getSource() == finnBil || e.getSource() == finnFelt )
				{
					finnBileierInfo();
				}
				else if ( e.getSource() == fjernBil || e.getSource() == fjernFelt )
				{
					fjernBil();
				}
				else if ( e.getSource() == fjernEier )
				{
					fjernEier();
				}
				else if ( e.getSource() == skrivInfo )
				{
					skrivListe();
				}
				else if( e.getSource() == regPerson )
				{
					nyPerson();
				}
				else if( e.getSource() == regFirma )
				{
					nyFirma();
				}
			//}
			//catch( NumberFormatException nfe )
			//{
			//	JOptionPane.showMessageDialog( null, "�rstall, personnummer og foretaksnummer skal v�re et heltall",
			//															 "Feil", JOptionPane.ERROR_MESSAGE );
			//}
    }	// end of metode actionPerformed()
  }	// end of inner class Lytter
}	// end of class Listevindu