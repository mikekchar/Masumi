package masumi.android.tests;

import android.test.ActivityInstrumentationTestCase2;
import masumi.android.MainInteraction;
import masumi.android.MasumiForAndroid;
import masumi.contexts.Main;

/**
 * Implements a context in which to test Masumi.
 * 
 * @author Mike Charlton
 *
 */
public class Story extends ActivityInstrumentationTestCase2<MockMasumiActivity> {

	protected Main mainContext;
	protected MainInteraction mainInteraction;
	private MockMasumiActivity activity;
	
	public Story() {
		super("masumi.android", MockMasumiActivity.class);
		activity = null;
		mainContext = null;
		mainInteraction = null;
	}

	
	/**
	 * Run Masumi.  Usually this will be run by the setUp methods in the concrete classes.
	 */
    void runMasumi() {
		mainContext = activity.runMasumi();
	}
	
	/**
	 * Masumi will be started on setUp and the Main Context will be entered.
	 * @throws java.lang.Exception
	 */
	@Override
	public void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
		runMasumi();
		mainInteraction = (MainInteraction)(mainContext.getInteraction());
	}
	
	/**
	 * Make sure that Masumi has properly exited.
	 */
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		if ((mainContext != null) && (mainContext.is_entered())) {
			mainContext.exit();
		}
		mainContext = null;
		mainInteraction = null;
		activity = null;
	}

	protected MasumiForAndroid getMasumi() {
		return activity.masumi;
	}
}