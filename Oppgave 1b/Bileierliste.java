/*

Programutvikling v�r 2014
Obligatorisk Oppgave
Oppgave 1b: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

*/
 import java.io.*;

 public class Bileierliste implements Serializable
 {
	 private Bileier f�rste;

	 public Bileierliste()
	 {
		 f�rste = null;
	 }

	 public String settInnBileier(Bileier ny, long id)
	 {
		 if(finnBileier(id) != null)
		   return "Eier " + id + " er allerede registrert";

		 ny.neste = f�rste;
		 f�rste = ny;
		 return "Eier " + id + " er registrert";
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
		   return "Eier " + id + " ble fjernet.";
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

	 public String eierskifte(String rn, long idGammel, long idNy)
	 {
		 Bileier gammel = finnBileier(idGammel);
		 Bileier ny = finnBileier(idNy);
		 if(gammel == null || ny == null)
		   return "Finner ikke eier.";

		 Bil b = gammel.finnBil(rn);
		   if(b == null)
		     return "Finner ikke bil.";

		 gammel.fjernBil(rn);
		 ny.regBil(b);
		 return "Eierskifte registrert";
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