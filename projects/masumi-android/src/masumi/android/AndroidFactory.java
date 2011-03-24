package masumi.android;

import masumi.contexts.ExploreProblem;
import masumi.contexts.InteractionFactory;
import masumi.contexts.Main;
import masumi.android.MainInteraction;

public class AndroidFactory implements InteractionFactory {

	public MasumiActivity activity;
	
	public AndroidFactory(MasumiActivity anActivity) {
		activity = anActivity;
	}
	
	android.content.Context getApplicationContext() {
		return activity.getApplicationContext();
	}
	
	@Override
	public boolean showUI() {
		return activity.showUI();
	}

	@Override
	public Main.Interaction create_interaction(Main context) {
		return new MainInteraction(context, this);
	}

	@Override
	public ExploreProblem.Interaction create_interaction(ExploreProblem context) {
		return new ExploreProblemInteraction(context, this);
	}

}
