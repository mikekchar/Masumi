package masumi.android;

import masumi.contexts.Main;
import android.app.Activity;
import android.os.Bundle;

public class MasumiActivity extends Activity {
	/** Called when the activity is first created. */
	
	public MasumiForAndroid masumi;
	public Main mainContext;
	
	public MasumiActivity() {
		super();
		masumi = new MasumiForAndroid(this);
		mainContext = null;
	}
	
	/**
	 * Run masumi
	 * 
	 * This is removed from the onCreate method because we have to override
	 * it in the tests.  If we don't, the UI ends up being created in the setup thread
	 * and tested in the testing thread (which crashes).
	 */
	public void run() {
		mainContext = (Main)(masumi.run());		
	}
	
	/**
	 * We can't show the UI in the tests.  This will return false in the test Mock
	 * 
	 * @return true if we should show the UI
	 */
	public boolean showUI() {
		return true;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        	run();
	}
}