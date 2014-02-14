/*
 *
 *
 *
 */
 public abstract class Bileier
 {
	 private String navn, adresse;
	 private Billiste biler;
	 Bileier neste;

	 public Bileier (String navn, String adresse)
	 {
		 this.navn = navn;
		 this.adresse = adresse;
		 biler = null;
		 neste = null;
	 }

	 // setter inn ny bil i bileiers liste
	 public void regBil(Bil ny)
	 {
		 biler.settInnNy(ny);
	 }
	 public String fjernBil(String rn)
	 {
		 if (biler.fjern(rn))
		   return "Bil med registreringsnummer " + rn + " ble fjernet.";
		 return "Ingen bil ble fjernet";
	 }

	 public String toString()
	 {
		 String s = "Bileier: " + navn + "\nAdresse: " + adresse;
		 return s;
	 }
 }