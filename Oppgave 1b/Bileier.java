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

 public abstract class Bileier implements Serializable
 {
	 private String navn, adresse;
	 private Billiste billiste;
	 Bileier neste;

	 public Bileier (String navn, String adresse)
	 {
		 this.navn = navn;
		 this.adresse = adresse;
		 billiste = new Billiste();
		 neste = null;
	 }

	 // setter inn ny bil i bileiers liste
	 public void regBil(Bil ny)
	 {
		 billiste.settInnNy(ny);
	 }
	 public String fjernBil(String rn)
	 {
		 if (billiste.fjern(rn))
		   return "Bil med registreringsnummer " + rn + " ble fjernet.";
		 return "Ingen bil ble fjernet";
	 }
	 public Bil finnBil(String r)
	 {
		 if (billiste.finn(r) == null)
		   return null;
		 return billiste.finn(r);
	 }
	 public Billiste getBilliste()
	 {
		 return billiste;
	 }
	 // Redefineres i subklasser
     public long getId()
     {
		 return -1;
	 }
	 public String toString()
	 {
		 String s = "Bileier: " + navn + "\nAdresse: " + adresse + "\nBiler:\n------\n";
		 s +=billiste.toString() + "**********************************";
		 return s;
	 }
 }