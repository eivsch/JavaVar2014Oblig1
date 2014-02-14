/*
 *
 *
 *
 */
 public abstract class Bileier
 {
	 private String navn, adresse;
	 Billiste biler;
	 Bileier neste;

	 public Bileier (String navn, String adresse, Billiste biler)
	 {
		 this.navn = navn;
		 this.adresse = adresse;
		 this.biler = biler;
		 neste = null;
	 }
	 public String toString()
	 {
		 String s = "Bileier: " + navn + "\nAdresse: " + adresse;
		 return s;
	 }
 }