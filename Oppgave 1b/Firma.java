/*

Programutvikling vår 2014
Obligatorisk Oppgave
Oppgave 1b: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/
 public class Firma extends Bileier
 {
	 private long foretaksNr;

	 public Firma (String navn, String adresse, long foretaksNr)
	 {
		 super(navn, adresse);
		 this.foretaksNr = foretaksNr;
	 }
	 public String toString()
	 {
		 String s = super.toString() + "\nForetaksnummer: " + foretaksNr;
		 return s;
	 }
	 public long getId()
	 {
		 return foretaksNr;
	 }
 }