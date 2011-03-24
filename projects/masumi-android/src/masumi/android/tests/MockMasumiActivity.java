package masumi.android.tests;

import masumi.android.MasumiActivity;
import masumi.contexts.Main;

public class MockMasumiActivity extends MasumiActivity {

	/**
	 * Normally this would run masumi, but this leads to having the UI constructed
	 * in the wrong thread in the tests.  Thus we need to get rid of it here and
	 * run it by hand in the setup. 
	 */
	@Override
	public void run() {
		// Do nothing.  Masumi will be run by the tests.
	}
	
	/**
	 * We can't show the UI in the test code.  This will return false.
	 */
	@Override
	public boolean showUI() {
		return false;
	}
	
	public Main runMasumi() {
		mainContext = (Main)(masumi.run());	
		return mainContext;
	}
}
