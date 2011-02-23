package masumi.android;

import masumi.contexts.InteractionFactory;
import masumi.contexts.Main;
import masumi.android.MainInteraction;

public class AndroidFactory implements InteractionFactory {

	@Override
	public boolean showUI() {
		return true;
	}

	@Override
	public Main.Interaction create_interaction(Main context) {
		return new MainInteraction(context);
	}

}
