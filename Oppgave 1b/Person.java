/*
 *
 *
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
	 public long getPersonNr()
	 {
		 return personNr;
	 }
 }