/*

Programutvikling vår 2014
Obligatorsik Oppgave
Oppgave 1b: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

*/
 public class Bileierliste
 {
	 private Bileier første;

	 public Bileierliste()
	 {
		 første = null;
	 }
	 public void settInnBileier(Bileier ny)
	 {
		 ny.neste = første;
		 første = ny;
	 }
	 public Bileier finnBileier(long id)
	 {
		 // Listen er tom
		 if (første == null)
		   return null;

		 Bileier løper = første;
		 while (løper != null)
		 {
			 if (id == løper.getId())
			   return løper;

			 løper = løper.neste;
		 }
		 return null;
	 }
     public String fjernEier(long id)
     {
		 if(første == null)
		   return "Listen er tom";
		 Bileier slettes = finnBileier(id);
		 if(første.getId() == id)
		 {
		   første = første.neste;
		   return "Eier " + id + "ble fjernet.";

	 }
	 public String toString()
	 {
		 return null;
	 }
 }