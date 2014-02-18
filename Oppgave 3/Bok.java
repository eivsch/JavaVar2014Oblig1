//Bok.java

//P� toppen av klassehierarkiet for boktyper.
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
}

class Skolebok extends Bok
{
	private int klassetrinn;
	private String skolefag;

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
}

class Fagbok extends Bok
{
	private String fagomr�de;

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
}





//Klassen har som oppgave � definere det som er felles for de
//forskjellige typene av romaner. Skal ikke instansieres.
abstract class Roman extends Bok
{
	protected String sjanger;

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
}


class NorskRoman extends Roman
{
	private String m�lform;

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
}


class UtenlandskRoman extends Roman
{
	private String spr�k;

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
}
