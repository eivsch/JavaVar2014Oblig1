/*

Programutvikling v�r 2014
Obligatorisk Oppgave
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

	 public Bileier finnBileier(String r)
	 {
		 if (f�rste == null)
		   return null;

		 Bileier l�per = f�rste;
	     while(l�per != null)
	 	 {
	 		 if( l�per.finnBil(r) != null)
	 		   return l�per;

	 		 l�per = l�per.neste;
	 	 }
	 	 return null;
	 }

     public String fjernEier(long id)
     {
		 if(f�rste == null)
		   return "Listen er tom";

		 // Sjekker at eieren ikke har registrert noen biler
		 Bileier eier = finnBileier(id);
		 if(!eier.getBilliste().tomListe())
		   return "Bileier " + id + " har fortsatt biler registrert, kan ikke fjernes!";

		 if(f�rste.getId() == id)
		 {
		   f�rste = f�rste.neste;
		   return "Eier " + id + "ble fjernet.";
	     }
	     Bileier l�per = f�rste;
	     while (l�per.neste != null)
	     {
			 if(l�per.neste.getId() == id)
			 {
			   l�per.neste = l�per.neste.neste;
			   return "Eier " + id + " ble fjernet";
		     }
		 }
		 return "Eier " + id + " ble ikke fjernet";
	 }
	 public void eierskifte(String rn, long idGammel, long idNy)
	 {
		 Bileier gammel = finnBileier(idGammel);
		 Bileier ny = finnBileier(idNy);
		 Bil b = gammel.finnBil(rn);
		 gammel.fjernBil(rn);
		 ny.regBil(b);
	 }

	 public String toString()
	 {
		 Bileier l�per = f�rste;
		 String s = "";
		 while (l�per != null)
		 {
			 s += l�per.toString();
			 l�per = l�per.neste;
		 }
		 return s;
	 }
 }