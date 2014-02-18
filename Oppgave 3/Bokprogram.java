//Bokprogram.java
import java.awt.event.*;
import javax.swing.*;

public class Bokprogram
{
  public static void main( String[] args )
  {
    Bokarkiv vindu = new Bokarkiv();
    vindu.addWindowListener(
      new WindowAdapter() {
        public void windowClosing( WindowEvent e )
        {

          System.exit( 0 );
        }
      } );
  }


}
