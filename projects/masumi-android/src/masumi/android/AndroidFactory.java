package masumi.android;

import masumi.contexts.ExploreProblem;
import masumi.contexts.InteractionFactory;
import masumi.contexts.Main;
import masumi.android.MainInteraction;

public class AndroidFactory extends InteractionFactory {

	public final MasumiActivity activity;
	private int numWidgets;
	
	public AndroidFactory(MasumiActivity anActivity) {
		activity = anActivity;
		numWidgets = 0;
	}
	
	public android.content.Context getApplicationContext() {
		return activity.getApplicationContext();
	}
	
	/**
	 * Creates a new id for an Android view.
	 * Each view in Android requires a unique ID.  Therefore, when the view is created,
	 * do a setId(factory.newId());
	 * 
	 * @return Android ID
	 */
	public int newId() {
		numWidgets = numWidgets + 1;
		return numWidgets;
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
