package masumi.android;

import masumi.contexts.Masumi;

public class MasumiForAndroid extends Masumi {

	public MasumiForAndroid(MasumiActivity anActivity) {
		super(new AndroidFactory(anActivity));
	}

	@Override
	public void exit_system() {
		isRunning = false;
	}

}
