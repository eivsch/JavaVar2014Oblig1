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
import java.io.*;

public class Listevindu extends JFrame
{
  private JTextField navnFelt, adrFelt, pnrFelt, fnrFelt;
  private JButton regPerson, regFirma;

  private JTextField regNrFelt, merkeFelt, typeFelt, arFelt, pnrFnrFelt;
  private JButton regBilEier;

  private JTextField finnFelt, fjernFelt, fjernEierFelt;
  private JButton finnBil, fjernBil, fjernEier, skrivInfo;

  private JTextField skiftFra, skiftTil, skiftRnr;
  private JButton skiftEier;

  private JTextArea output;

  private Bileierliste bileierliste;
  private Lytter lytter;

  public Listevindu()
  {
    super( "Bil-register" );
    lytter = new Lytter();

    Container c = getContentPane();
    c.setLayout( new FlowLayout() );

    c.add( new JLabel( "**************************** Eierinformasjon ********************************" ) );

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

		c.add( new JLabel( "***************************** Bilinformasjon *********************************" ) );

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

    c.add( new JLabel( "Personnummer/foretaksnummer: " ) );
    pnrFnrFelt = new JTextField( 8 );
    c.add( pnrFnrFelt );

    regBilEier = new JButton( "Registrer bil p� person/firma" );
    regBilEier.addActionListener( lytter );
    c.add( regBilEier );

		c.add( new JLabel( "******************************* Finn / Fjern ***********************************" ) );

		c.add( new JLabel( "Skriv reg.nr: " ) );
		finnFelt = new JTextField( 10 );
    c.add( finnFelt );

    finnBil = new JButton( "         Finn eier         " );
    finnBil.addActionListener( lytter );
    c.add( finnBil );

 		c.add( new JLabel( "Fjern bil (regnr): " ) );
 		fjernFelt = new JTextField( 10 );
		c.add( fjernFelt );

		fjernBil = new JButton( "            Fjern bil            " );
		fjernBil.addActionListener( lytter );
    c.add( fjernBil );

 		c.add( new JLabel( "Fjern eier: " ) );
 		fjernEierFelt = new JTextField( 10 );
		c.add( fjernEierFelt );

		fjernEier = new JButton( "              Fjern eier              " );
		fjernEier.addActionListener( lytter );
    c.add( fjernEier );

    skrivInfo = new JButton( "Skriv ut" );
    skrivInfo.addActionListener( lytter );
    c.add( skrivInfo );

   	c.add( new JLabel( "******************************** Eierskifte ************************************" ) );

		c.add( new JLabel( "Reg.nr: " ) );
 		skiftRnr = new JTextField( 30 );
		c.add( skiftRnr );

		c.add( new JLabel( "Skift fra: " ) );
 		skiftFra = new JTextField( 10 );
		c.add( skiftFra );

		c.add( new JLabel( "Skift til: " ) );
 		skiftTil = new JTextField( 10 );
		c.add( skiftTil );

    skiftEier = new JButton( "Skift eier" );
    skiftEier.addActionListener( lytter );
    c.add( skiftEier );


    output = new JTextArea( 15, 35 );
    output.setEditable( false );
    c.add( new JScrollPane( output ) );

    bileierliste = new Bileierliste();

    setSize( 433, 780 );
    setVisible( true );
    lesFil();
    skrivListe();
  }	// end of konstrukt�r

  private void lesFil()
  {
	  try(ObjectInputStream innfil = new ObjectInputStream(new FileInputStream("bileierliste.data"))){
	      bileierliste = (Bileierliste) innfil.readObject();
	  }
	  catch(ClassNotFoundException cnfe){
		  output.setText(cnfe.getMessage());
		  output.append("\nOppretter tom bileierliste.\n");
		  bileierliste = new Bileierliste();
	  }
	  catch(FileNotFoundException fne){
		  output.setText("Finner ikke fil, Oppretter tom bileierliste.\n");
		  bileierliste = new Bileierliste();
	  }
	  catch(IOException e){
		  output.setText("Feil ved fillesing, oppretter tom bileierliste\n");
		  bileierliste = new Bileierliste();
      }
  }
    public void skrivTilFil(){
        try(ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream("bileierliste.data"))){
            utfil.writeObject(bileierliste);
        }
        catch(NotSerializableException nse){
            output.setText("Objektet er ikke serialisert");
        }
        catch(IOException e){
            output.setText("Problem med utskrift");
        }
    }

  public void regBilEier()
  {
		if( regNrFelt.getText().equals( "" ) || merkeFelt.getText().equals( "" ) ||
		    typeFelt.getText().equals( "" ) || arFelt.getText().equals( "" ) ||
		    pnrFnrFelt.getText().equals( "" ) )
		{
			JOptionPane.showMessageDialog( null, "Du m� fylle ut personnummer, registreringsnummer, bilmerke, biltype og �rstall",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			return;
		}

		Long pnrFnr = Long.parseLong( pnrFnrFelt.getText() );

    String r = regNrFelt.getText();
    String m = merkeFelt.getText();
    String t = typeFelt.getText();
    int ar = Integer.parseInt( arFelt.getText() );

		Bil b = new Bil( r, m, t, ar );

    if( bileierliste.finnBileier( pnrFnr ) == null )
		{
			output.setText( "Finner ikke personnummer " + pnrFnr );
			return;
		}

		Bileier eier = bileierliste.finnBileier( pnrFnr );

		eier.regBil( b );

		if( eier instanceof Person )
    	output.setText( "Bil med registreringsnummer " + r + " registrert p� personnummer " + pnrFnr );
    else
			output.setText( "Bil med registreringsnummer " + r + " registrert p� foretaksnummer " + pnrFnr );

		pnrFnrFelt.setText( "" );
		regNrFelt.setText( "" );
		merkeFelt.setText( "" );
		typeFelt.setText( "" );
		arFelt.setText( "" );
  }	// end of metode regBilPerson()


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
    output.setCaretPosition(0);
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

		output.setCaretPosition(0);

  }	// end of metode skrivListe()



	public void nyPerson()
	{
		if( navnFelt.getText().equals("") || adrFelt.getText().equals("") || pnrFelt.getText().equals("") )
		{
			JOptionPane.showMessageDialog( null, "Du m� fylle ut navn, adresse og personnummer",
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
			JOptionPane.showMessageDialog( null, "Du m� fylle ut navn, adresse og foretaksnummer",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			return;
		}

    String navn = navnFelt.getText();
		String adr = adrFelt.getText();
		Long fnr = Long.parseLong( fnrFelt.getText() );

		Firma f = new Firma( navn, adr, fnr );

		bileierliste.settInnBileier( f );

		output.setText( "Nytt firma registrert" );
		navnFelt.setText( "" );
		adrFelt.setText( "" );
		pnrFelt.setText( "" );
		fnrFelt.setText( "" );
	}	// end of metode nyFirma()


	public void skiftEier()
	{
		if( skiftRnr.getText().equals("") || skiftFra.getText().equals("") || skiftTil.getText().equals("") )
		{
			JOptionPane.showMessageDialog( null, "Du m� fylle ut registreringsnummer og personnummer/foretaksnummer",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			return;
		}

		String rnr = skiftRnr.getText();
		Long fraNr = Long.parseLong( skiftFra.getText() );
		Long tilNr = Long.parseLong( skiftTil.getText() );

		output.setText( bileierliste.eierskifte(rnr, fraNr, tilNr) );

		skiftRnr.setText( "" );
		skiftFra.setText( "" );
		skiftTil.setText( "" );
	}



  private class Lytter implements ActionListener
  {
    public void actionPerformed( ActionEvent e )
    {
      try
      {
				if ( e.getSource() == regBilEier )
				{
					regBilEier();
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
				else if( e.getSource() == skiftEier )
				{
					skiftEier();
				}
			}
			catch( NumberFormatException nfe )
			{
				JOptionPane.showMessageDialog( null, "�rstall, personnummer og foretaksnummer skal v�re et heltall",
																		 "Feil", JOptionPane.ERROR_MESSAGE );
			}
    }	// end of metode actionPerformed()
  }	// end of inner class Lytter
}	// end of class Listevindu