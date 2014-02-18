/*

Programutvikling v�r 2014
Obligatorsik Oppgave
Oppgave 3

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

*/
import java.io.*;

public abstract class Bok
{
	private String forfatter, tittel;
	private int sideantall;
	private double pris;
  Bok neste;

  public Bok()
  {
	}

	public Bok( String f, String t, int sider, double p )
  {
		forfatter = f;
		tittel = t;
		sideantall = sider;
		pris = p;
                neste = null;
	}

	public String getForfatter()
	{
		return forfatter;
	}


	public String getTittel()
  {
		return tittel;
	}

	public String toString()
  {
		String s = forfatter + "; ";
		s += tittel + "; ";
		s += sideantall + " s., ";
		s += "kr. " + pris;
		return s;
	}

	public boolean lesObjektFraFil( DataInputStream input )
	{
		//Leser verdier fra fil og lagrer dem i de tilh�rende datafeltene.
		try
		{
			forfatter = input.readUTF();
			tittel = input.readUTF();
			sideantall = input.readInt();
			pris = input.readDouble();

			return true;
		}
		catch( IOException ioe )
		{
			System.out.println( "Bok - Problem med lesing fra fil." );
			return false;
		}
	}

	public void skrivObjektTilFil( DataOutputStream output )
	{
		//Skriver datafeltenes verdier til fil.

		try
		{
			output.writeUTF( forfatter );
			output.writeUTF( tittel );
			output.writeInt( sideantall );
			output.writeDouble( pris );
		}
		catch (IOException e)
		{
			System.out.println( "Bok - Filproblem." );
		}
	}


}

class Skolebok extends Bok
{
	private String type;
	private int klassetrinn;
	private String skolefag;

	public Skolebok()
	{
		super();
	}


	public Skolebok( String f, String t,int sider, double p, int kt, String fag )
        {
		super( f, t, sider, p );
		klassetrinn = kt;
		skolefag = fag;
	}

	public String toString()
        {
		String s = super.toString();
		s += "; trinn: " + klassetrinn;
		s += ", " + skolefag;
		return s;
	}

	public boolean lesObjektFraFil( DataInputStream input )
	{
		//Leser verdier fra fil og lagrer dem i de tilh�rende datafeltene.
		try
		{
			if( super.lesObjektFraFil( input ) )
			{
				klassetrinn = input.readInt();
				skolefag = input.readUTF();
				return true;
			}
			else
				return false;
		}
		catch( IOException ioe )
		{
			System.out.println( "Skolebok - Problem med lesing fra fil." );
			return false;
		}

	}

	public void skrivObjektTilFil( DataOutputStream output )
	{
		try
		{
			output.writeUTF( "Skolebok" );
			super.skrivObjektTilFil( output );
			output.writeInt( klassetrinn );
			output.writeUTF( skolefag );
		}
		catch (IOException e)
		{
			System.out.println( "Skolebok - Filproblem." );
		}
	}

}

class Fagbok extends Bok
{
	private String type, fagomr�de;

	public Fagbok()
	{
		super();
	}

	public Fagbok( String f, String t, int sider, double p, String omr )
        {
		super( f, t, sider, p );
		fagomr�de = omr;
	}

	public String toString()
        {
		String s = super.toString();
		s += "; " + fagomr�de;
		return s;
	}

	public boolean lesObjektFraFil( DataInputStream input )
	{
		//Leser verdier fra fil og lagrer dem i de tilh�rende datafeltene.
		try
		{
			if( super.lesObjektFraFil( input ) )
			{
				System.out.println("5");
				fagomr�de = input.readUTF();
				return true;
			}
			else
				return false;
		}
		catch( IOException ioe )
		{
			System.out.println( "Fagbok - Problem med lesing fra fil." );
			return false;
		}

	}

	public void skrivObjektTilFil( DataOutputStream output )
	{
		//Skriver datafeltenes verdier til fil.
		try
		{
			output.writeUTF( "Fagbok" );
			System.out.println("1");
			super.skrivObjektTilFil( output );
			output.writeUTF( fagomr�de );
		}
		catch (IOException e)
		{
			System.out.println( "Fagbok - Filproblem." );
		}
	}

}





//Klassen har som oppgave � definere det som er felles for de
//forskjellige typene av romaner. Skal ikke instansieres.
abstract class Roman extends Bok
{
	protected String sjanger;

	public Roman()
	{
		super();
	}

	protected Roman( String f, String t, int sider, double p, String s )
        {
		super( f, t, sider, p );
		sjanger = s;
	}

	public String toString()
        {
		String s = super.toString();
		s += ". Sjanger: " + sjanger;
		return s;
	}

	public boolean lesObjektFraFil( DataInputStream input )
	{
		//Leser verdier fra fil og lagrer dem i de tilh�rende datafeltene.
		try
		{
			if( super.lesObjektFraFil( input ) )
			{
				sjanger = input.readUTF();
				return true;
			}
			else
				return false;
		}
		catch( IOException ioe )
		{
			System.out.println( "Roman - Problem med lesing fra fil." );
			return false;
		}

	}

	public void skrivObjektTilFil( DataOutputStream output )
	{
		try
		{
			super.skrivObjektTilFil( output );
			output.writeUTF( sjanger );
		}
		catch (IOException e)
		{
			System.out.println( "Roman - Filproblem." );
		}
	}
}


class NorskRoman extends Roman
{
	private String type, m�lform;

	public NorskRoman()
	{
		super();
	}

	public NorskRoman( String f, String t,  int s, double p, String sj, String m )
        {
		super( f,t, s, p, sj );
		m�lform = m;
	}

	public String toString()
        {
		String s = super.toString();
		s += ". " + m�lform;
		return s;
	}

	public boolean lesObjektFraFil( DataInputStream input )
	{
		//Leser verdier fra fil og lagrer dem i de tilh�rende datafeltene.
		try
		{
			if( super.lesObjektFraFil( input ) )
			{
				m�lform = input.readUTF();
				return true;
			}
			else
				return false;
		}
		catch( IOException ioe )
		{
			System.out.println( "NorskRoman - Problem med lesing fra fil." );
			return false;
		}

	}

	public void skrivObjektTilFil( DataOutputStream output )
	{
		try
		{
			output.writeUTF( "NorskRoman" );
			super.skrivObjektTilFil( output );
			output.writeUTF( m�lform );
		}
		catch (IOException e)
		{
			System.out.println( "NorskRoman - Filproblem." );
		}
	}
}


class UtenlandskRoman extends Roman
{
	private String type, spr�k;

	public UtenlandskRoman()
	{
		super();
	}

	public UtenlandskRoman( String f, String t,  int s, double p, String sj, String sp )
        {
		super( f, t, s, p, sj );
		spr�k = sp;
	}

	public String toString() {
		String s = super.toString();
		s += ". " + spr�k;
		return s;
	}

	public boolean lesObjektFraFil( DataInputStream input )
	{
		//Leser verdier fra fil og lagrer dem i de tilh�rende datafeltene.
		try
		{
			if( super.lesObjektFraFil( input ) )
			{
				spr�k = input.readUTF();
				return true;
			}
			else
				return false;
		}
		catch( IOException ioe )
		{
			System.out.println( "UtenlandskRoman - Problem med lesing fra fil." );
			return false;
		}

	}

	public void skrivObjektTilFil( DataOutputStream output )
	{
		try
		{
			output.writeUTF( "UtenlandskRoman" );
			super.skrivObjektTilFil( output );
			output.writeUTF( spr�k );
		}
		catch (IOException e)
		{
			System.out.println( "UtenlandskRoman - Filproblem." );
		}
	}
}
