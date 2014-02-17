//Demonstrerer File-klassen
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.Date;
import java.text.DateFormat;

public class Oppgave2 extends JFrame
{
  private JTextField input;
  private JTextArea output;
  private JButton velg;
  private String filsti = null;
  private Lytter kommandolytter;

  public Oppgave2()
  {
    super("Tester File-klassen");
    kommandolytter = new Lytter();
    Container c = getContentPane();
    c.add( new JLabel( "Viser innhold av valgt tekstfil." ) );
    velg = new JButton( "Velg fil" );
    velg.addActionListener( kommandolytter );
    c.add( velg );
    output = new JTextArea(20, 35);
    output.setEditable(false);
    setLayout( new FlowLayout() );
    c.add(new JScrollPane(output));
    setSize(400, 400);
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
			output.append( navn + " representerer en katalog\n" );

			String[] dir = navn.list();
			output.append("\n\nKatalog inneholder " + dir.length + " elementer:\n");

			for (int i = 0; i < dir.length; i++)
			{
				if( dir[i].endsWith(".java") )
				{
					output.append(dir[i] + " " + tellLinjer(dir[i]) + "\n");
				}
				else
					output.append(dir[i] + "\n");
			}

		}
		else
			output.append( "Navnet " + navn + " representerer en fil\n" );

    output.setCaretPosition(0);
  }

  public int tellLinjer( String filnavn )
  {
    //Åpner tekstfila som skal leses
    try (BufferedReader inntekst =
            new BufferedReader( new FileReader( filnavn )))
    {
      //leser linjer inntil filslutt
      String innlinje = null;
			int ant = 0;
      do
      {
        innlinje = inntekst.readLine(); //leser en linje

        if ( innlinje != null ) //null betyr filslutt
        {
					output.append( innlinje + "\n" );
					ant++;
				}
      } while ( innlinje != null );

      return ant;
    }
    catch ( FileNotFoundException e)
    {
      output.setText("Filproblemer");
      return -1;
    }
    catch ( IOException ioe )
    {
			return -1;
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