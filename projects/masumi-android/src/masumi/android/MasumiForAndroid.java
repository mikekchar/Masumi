package masumi.android;

import masumi.contexts.Masumi;
import android.app.Activity;

public class MasumiForAndroid extends Masumi {

	private Activity mainActivity;
	
	public MasumiForAndroid(Activity anActivity) {
		super(new AndroidFactory());
		mainActivity = anActivity;
	}

	public Activity getMainActivity() {
		return mainActivity;
	}
	
	@Override
	public void exit_system() {
		isRunning = false;
	}

}
