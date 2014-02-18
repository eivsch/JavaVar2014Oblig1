/*

Programutvikling vår 2014
Obligatorsik Oppgave
Oppgave 2

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Oppgave2 extends JFrame
{
  private JTextField input;
  private JTextArea output;
  private JButton velg;
  private String filsti = null;
  private Lytter lytter;

  public Oppgave2()
  {
    super("Oppgave 2 - Innlesning av fil/katalog");
    lytter = new Lytter();
    Container c = getContentPane();
    c.add( new JLabel( "Viser informasjon om valgt fil eller katalog" ) );
    velg = new JButton( "Velg fil/katalog" );
    velg.addActionListener( lytter );
    c.add( velg );
    output = new JTextArea(25, 45);
    output.setEditable(false);
    setLayout( new FlowLayout() );
    c.add(new JScrollPane(output));
    setSize(600, 500);
    setVisible(true);
  }

  public String velgFil()
  {
    final JFileChooser filvelger = new JFileChooser( new File( "." ) );

		// vi kan velge katalog eller fil:
		filvelger.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES );

    int resultat = filvelger.showOpenDialog( this );

    if ( resultat == JFileChooser.APPROVE_OPTION )
    {  //bruker har klikket på Open-knappen
      File fil = filvelger.getSelectedFile();
      return fil.getPath();
    }
    else //bruker har klikket på Cancel-knappen eller lukkeknappen
      return null;
  }


  public void sjekkFil(String fil)
  {
    output.setText("");
    File navn = new File(fil);

		if( navn.isDirectory() )
		{
			output.append( "Navnet\n" + navn + "\nrepresenterer en katalog\n" );

			String[] dir = navn.list();
			output.append("\nKatalog inneholder " + dir.length + " elementer:\n");
			output.append( "\nKodelinjer\tFilnavn\n----------------------------------\n" );
            int total = 0;
            int antJavaFiler = 0;
			for (int i = 0; i < dir.length; i++)
			{
				if( dir[i].endsWith(".java") )
				{
					String temp = fil + "/" + dir[i];
					output.append( tellLinjer(temp) + "\t" + dir[i] + "\n" );
					total += tellLinjer(temp);
					antJavaFiler++;
				}
				else
					output.append("\t" + dir[i] + "\n");
			}
            output.append("\n----------------------------------\n" +
                  total + "\tantall kodelinjer i " + antJavaFiler + " .java filer: " );
		}
		else
		{
			String nyFil = skrivTilFil( fil );
			output.append( "Navnet\n" + navn + "\nrepresenterer en fil\n" );
			output.append( "Ny fil " + nyFil + " er opprettet og den inneholder:\n\n" );
			visFil( nyFil );

		}

    output.setCaretPosition(0);
  }


  public int tellLinjer( String filnavn )
  {
    try (BufferedReader inntekst =
            new BufferedReader( new FileReader( filnavn )))
    {
      String innlinje = null;
			int ant = 0;
      do
      {
        innlinje = inntekst.readLine();

        if ( innlinje != null )
        {
					ant++;
				}
      } while ( innlinje != null );

      return ant;
    }
    catch ( FileNotFoundException e)
    {
      output.setText("Finner ikke fil " + filnavn);
      return -1;
    }
    catch ( IOException ioe )
    {
      output.setText("Filproblemer");
      return -1;
		}

  }



	public String skrivTilFil( String filnavn )
	{
		File f = null;
		boolean okfil = false;

		do
		{
			JFileChooser filvelger = new JFileChooser();
			filvelger.setCurrentDirectory( new File( "." ) );
			int resultat = filvelger.showSaveDialog( null );

			if ( resultat == JFileChooser.APPROVE_OPTION )
			{
				f = filvelger.getSelectedFile();
				if ( !f.exists() )
					okfil = true;
				else
					JOptionPane.showMessageDialog( null,
							"Fila eksisterer allerede!\n" +
							"Du må velge et annet navn.",
							"Advarsel", JOptionPane.WARNING_MESSAGE );
			}
			else
			{
				JOptionPane.showMessageDialog( null,
						"Du har ikke valgt utfil!\n" +
						"Programmet vil bli avsluttet.",
						"Advarsel", JOptionPane.WARNING_MESSAGE );
				System.exit( 0 );
			}
		} while ( !okfil );
		//åpner fil det skal leses fra og fil det skal skrives til

		try (BufferedReader in = new BufferedReader( new FileReader( filnavn ));
				 PrintWriter out = new PrintWriter( new FileWriter( f.getPath() )))
		{
			String innlinje = null;
			int linjenummer = 1;

			do
			{
				innlinje = in.readLine();
				out.println( linjenummer++ + " " + innlinje + "\n" );

			}while( innlinje != null );

			return f.getName();
		}
		catch ( FileNotFoundException fnfe )
		{
			System.out.println( "Finner ikke fil det skal leses fra." );
			return null;
		}
		catch ( IOException ioe )
		{
			System.out.println( "Problem med fillesing eller skriving." );
			return null;
		}
	}


	public void visFil( String filnavn )
	{
		try (BufferedReader in = new BufferedReader( new FileReader( filnavn )))
		{

			do
			{
				output.append( in.readLine() + "\n" );

			}while( in.readLine() != null );

		}
		catch ( FileNotFoundException fnfe )
		{
			System.out.println( "Finner ikke fil det skal leses fra." );
		}
		catch ( IOException ioe )
		{
			System.out.println( "Problem med fillesing eller skriving." );
		}
	}


  private class Lytter implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
     if ( e.getSource() == velg )
        filsti = velgFil();
        sjekkFil( filsti );
    }
  }

	  public static void main( String args[] )
	  {
	      Oppgave2 f = new Oppgave2();
	      f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	  }
}