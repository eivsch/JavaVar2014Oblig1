/*
 *
 *
 *
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
	 public Person finnPerson(long pn)
	 {
		 // Listen er tom
		 if (f�rste == null)
		   return null;

		 Bileier l�per;
		 while (l�per != null)
		 {
			 if l�per.
	 }
	 public Firma finnFirma(long fn)
	 {
	 }

	 public String toString()
	 {
	 }
 }