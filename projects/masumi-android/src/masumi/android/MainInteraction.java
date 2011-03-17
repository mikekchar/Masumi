package masumi.android;

import masumi.android.R;
import android.app.Activity;
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
		mainActivity.setContentView(R.layout.main);
	}

	@Override
	public void close() {
		isOpen = false;
	}

	@Override
	public boolean is_open() {
		return isOpen;
	}
	
	public void request_closure() {
		context.exit();
	}


}
