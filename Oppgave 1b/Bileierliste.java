/*

Programutvikling v�r 2014
Obligatorsik Oppgave
Oppgave 1b: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

*/
 public class Bileierliste
 {
	 private Bileier f�rste;

	 public Bileierliste()
	 {
		 f�rste = null;
	 }
	 public void settInnBileier(Bileier ny)
	 {
		 ny.neste = f�rste;
		 f�rste = ny;
	 }
	 public Bileier finnBileier(long id)
	 {
		 // Listen er tom
		 if (f�rste == null)
		   return null;

		 Bileier l�per = f�rste;
		 while (l�per != null)
		 {
			 if (id == l�per.getId())
			   return l�per;

			 l�per = l�per.neste;
		 }
		 return null;
	 }
     public String fjernEier(long id)
     {
		 if(f�rste == null)
		   return "Listen er tom";
		 Bileier slettes = finnBileier(id);
		 if(f�rste.getId() == id)
		 {
		   f�rste = f�rste.neste;
		   return "Eier " + id + "ble fjernet.";

	 }
	 public String toString()
	 {
		 return null;
	 }
 }