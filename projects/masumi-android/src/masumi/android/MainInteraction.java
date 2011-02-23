package masumi.android;

import android.app.Activity;
import android.widget.TextView;
import masumi.contexts.Main;
import masumi.contexts.Main.Interaction;

public class MainInteraction implements Interaction {

	private Activity mainActivity;
	private Main context;
	private boolean isOpen;
	
	public MainInteraction(Main main) {
		context = main;
		mainActivity = null;
		isOpen = false;
	}
	
	@Override
	public void open() {
		isOpen = true;
		mainActivity = ((MasumiForAndroid)context.getParent()).getMainActivity();
		TextView tv = new TextView(mainActivity);
		tv.setText("Hello, Android");
		mainActivity.setContentView(tv);
	}

	@Override
	public void close() {
		isOpen = false;
	}

	@Override
	public boolean is_open() {
		return isOpen;
	}


}
