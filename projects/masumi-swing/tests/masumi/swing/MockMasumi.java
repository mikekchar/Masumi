package masumi.swing;

import masumi.contexts.Masumi;
import masumi.contexts.InteractionFactory;

/**
 * Mock for Masumi
 * 
 * Masumi exits the system on exit.  Of course we don't want to do that in tests, so
 * we override the method here.
 * 
 * @author Mike Charlton
 *
 */
public class MockMasumi extends MasumiForSwing {
	
	public MockMasumi(InteractionFactory aFactory){
		super(aFactory);
	}
	
	@Override
	public void exit_system() {
		// Don't exit in the tests
	}

}
