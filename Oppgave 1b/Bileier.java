/*

Programutvikling v�r 2014
Obligatorisk Oppgave
Oppgave 1b: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

*/
 public abstract class Bileier
 {
	 private String navn, adresse;
	 private Billiste billiste;
	 Bileier neste;

	 public Bileier (String navn, String adresse)
	 {
		 this.navn = navn;
		 this.adresse = adresse;
		 billiste = null;
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
		 String s = "Bileier: " + navn + "\nAdresse: " + adresse;
		 return s;
	 }
 }