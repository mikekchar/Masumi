package masumi.android;

import masumi.android.widgets.MainWindow;
import masumi.contexts.Context;
import masumi.contexts.Main;
import masumi.contexts.Widget;
import masumi.contexts.Main.Interaction;

public class MainInteraction implements Interaction {

	private final Main context;
	public final AndroidFactory factory;
	private MainWindow widget;
	private boolean isOpen;
	
	public MainInteraction(Main main, AndroidFactory aFactory) {
		context = main;
		factory = aFactory;
		isOpen = false;
		widget = null;
	}
	
	@Override
	public void open() {
		isOpen = true;
		widget = new MainWindow(this);
		if (factory.showUI()) {
			factory.activity.setContentView(widget);
		}
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
		return getWidget().contains(anInteraction.getWidget());
	}

	@Override
	public Widget getWidget() {
		return widget;
	}

	@Override
	public void remove(Context.Interaction anInteraction) {
		getWidget().remove(anInteraction.getWidget());
	}

	@Override
	public void update() {
		// Nothing to do here.
	}

}
