package masumi.android;

import masumi.contexts.ExploreProblem;
import masumi.contexts.InteractionFactory;
import masumi.contexts.Main;
import masumi.contexts.ExploreProblem.Interaction;
import masumi.android.MainInteraction;

public class AndroidFactory implements InteractionFactory {

	@Override
	public boolean showUI() {
		return true;
	}

	@Override
	public Main.Interaction create_interaction(Main context) {
		return new MainInteraction(context, this);
	}

	@Override
	public Interaction create_interaction(ExploreProblem context) {
		// TODO Auto-generated method stub
		return null;
	}

}
