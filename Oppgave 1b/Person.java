/*

Programutvikling vår 2014
Obligatorisk Oppgave
Oppgave 1b: Bil-register

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

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
		 String s = super.toString() + "\nPersonnummerr: " + personNr;
		 return s;
	 }
	 public long getId()
	 {
		 return personNr;
	 }
 }