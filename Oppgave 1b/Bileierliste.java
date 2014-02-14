/*
 *
 *
 *
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
	 public Person finnPerson(long pn)
	 {
		 // Listen er tom
		 if (første == null)
		   return null;

		 Bileier løper;
		 while (løper != null)
		 {
			 if løper.
	 }
	 public Firma finnFirma(long fn)
	 {
	 }

	 public String toString()
	 {
	 }
 }