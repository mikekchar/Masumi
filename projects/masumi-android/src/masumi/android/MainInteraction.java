package masumi.android;

import masumi.android.R;
import android.app.Activity;
import masumi.contexts.Context;
import masumi.contexts.InteractionFactory;
import masumi.contexts.Main;
import masumi.contexts.Widget;
import masumi.contexts.Main.Interaction;

public class MainInteraction implements Interaction {

	private Activity mainActivity;
	private Main context;
	private InteractionFactory factory;
	private boolean isOpen;
	
	public MainInteraction(Main main, InteractionFactory aFactory) {
		context = main;
		factory = aFactory;
		mainActivity = null;
		isOpen = false;
	}
	
	public boolean showUI() {
		return factory.showUI();
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

	@Override
	public void add(Context.Interaction anInteraction) {
		getWidget().add(anInteraction.getWidget());
	}

	@Override
	public boolean contains(Context.Interaction anInteraction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Widget getWidget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Context.Interaction anInteraction) {
		getWidget().add(anInteraction.getWidget());
	}

}
