/*

Programutvikling v�r 2014
Obligatorisk Oppgave
Oppgave 1b: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

*/
 public class Person extends Bileier
 {
	 private long personNr;

	 public Person(String navn, String adresse, long personNr)
	 {
		 super(navn, adresse);
		 this.personNr = personNr;
	 }
	 public String toString()
	 {
		 String s = "\nPersonnummer: " + personNr + "\n" + super.toString();
		 return s;
	 }
	 public long getId()
	 {
		 return personNr;
	 }
 }