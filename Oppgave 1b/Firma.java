/*

Programutvikling vår 2014
Obligatorisk Oppgave
Oppgave 1b: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/
 import java.io.*;

 public class Firma extends Bileier implements Serializable
 {
	 private long foretaksNr;

	 public Firma (String navn, String adresse, long foretaksNr)
	 {
		 super(navn, adresse);
		 this.foretaksNr = foretaksNr;
	 }
	 public String toString()
	 {
		 String s = "\nForetaksnummer: " + foretaksNr + "\n" + super.toString();
		 return s;
	 }
	 public long getId()
	 {
		 return foretaksNr;
	 }
 }