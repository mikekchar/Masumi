package masumi.swing;
import masumi.contexts.Masumi;
import masumi.swing.SwingFactory;

/**
 * This is the Swing version of the main application.
 * 
 * @author Mike Charlton
 *
 */
public class MasumiForSwing extends Masumi {
	
	public MasumiForSwing() {
		super(new SwingFactory());
	}

	/**
	 * Starts up Masumi using the normal Main Context and the SwingFactory for Swing style widgets.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Masumi masumi = new MasumiForSwing();

		masumi.run();
	}
}
