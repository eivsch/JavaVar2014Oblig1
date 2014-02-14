/*

Programutvikling vår 2014
Obligatorisk Oppgave
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

		 // Sjekker at eieren ikke har registrert noen biler
		 Bileier eier = finnBileier(id);
		 if(!eier.getBilliste().tomListe())
		   return "Bileier " + id + " har fortsatt biler registrert, kan ikke fjernes!";

		 if(første.getId() == id)
		 {
		   første = første.neste;
		   return "Eier " + id + "ble fjernet.";
	     }
	     Bileier løper = første;
	     while (løper.neste != null)
	     {
			 if(løper.neste.getId() == id)
			 {
			   løper.neste = løper.neste.neste;
			   return "Eier " + id + " ble fjernet";
		     }
		 }
		 return "Eier " + id + " ble ikke fjernet";
	 }

	 public String toString()
	 {
		 return null;
	 }
 }