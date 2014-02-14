/*
 *
 *
 */
 public class Person extends Bileier
 {
	 private long personNr;

	 public Person(String navn, String adresse, Billiste biler, long personNr)
	 {
		 super(navn, adresse, biler);
		 this.personNr = personNr;
	 }
	 public String toString()
	 {
		 String s = super.toString() + "\nPersonnummerr: " + personNr;
		 return s;
	 }
 }