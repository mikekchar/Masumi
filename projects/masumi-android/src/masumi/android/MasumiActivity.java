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
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        
		mainContext = (Main)(masumi.run());
	}
}