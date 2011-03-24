package masumi.swing;

import java.awt.Image;
import masumi.contexts.Context;
import masumi.contexts.InteractionFactory;
import masumi.contexts.Main;
import masumi.contexts.Widget;
import masumi.swing.widgets.MainWindow;

/*
 * This is the main window for the application.
 */
public class MainInteraction implements Main.Interaction {

	public Main context;
	private InteractionFactory factory;
	private boolean isOpen;
	private MainWindow widget;
	

	public MainInteraction(Main aContext, InteractionFactory aFactory) {
		factory = aFactory;
		context = aContext;
		isOpen = false;
		widget = new MainWindow(this);
	}
	
	public boolean showUI() {
		return factory.showUI();
	}

	/**
	 * Open the Main window frame.
	 */
	public void open() {
		isOpen = true;
	}
	
	public Image get_icon_image() {
		return widget.getIconImage();
	}
	
	/**
	 * Actually close the window.
	 */
	public void close() {
		widget.setVisible(false);
		widget.dispose();
		isOpen = false;
	}

	/**
	 * Returns true if the frame is visible.
	 */
	public boolean is_open() {
		return isOpen;
	}

	/**
	 * Request that the interaction close
	 * This is called by the widget itself.  You mustn't close the interaction directly here because
	 * the Context needs to dispose of the interaction.  So we ask the Context to exit which
	 * will close the Interaction.
	 */
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
		widget.validate();
	}
}
