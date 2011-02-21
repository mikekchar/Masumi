package masumi.swing;

import masumi.contexts.Context;
import masumi.contexts.InteractionFactory;
import masumi.contexts.Main;
import masumi.swing.SwingFactory;

/**
 * Masumi is the main application.
 * Although Masumi is a Context it really only exists to choose the correct Main Context and InteractionFactory.
 * From there it enters the Main Context and has no functionality until it exits.
 * You can test to see if Masumi is running (has not exited the Main Context yet) by calling
 * is_running().
 * 
 * @author Mike Charlton
 *
 */
public class Masumi extends Context {
	
	private boolean isRunning;

	
	public Masumi(InteractionFactory aFactory) {
		super(aFactory);
		isRunning = false;
	}

    /**
     * Returns the version information for this application.
     */
    public String version() {
        return Masumi.class.getPackage().getImplementationVersion();
    }
	
	/*
	 * Creates a new MainContext.  This can be overridden in the tests to allow for mocks.
	 */
	public Context create_main_context(InteractionFactory factory) {
		Context context = new Main(factory);
		return context;
	}
	
	/*
	 * Creates a new main context and enters it.  Returns the context it created.
	 */
	public Context run() {
		Context context = create_main_context(factory);
		isRunning = true;
		context.enter(this);
		return context;
	}
	
	/*
	 * This will be called by the main context when it exits.  This is called by Context.exit()
	 * so if you want to do anything before exiting in the Main Context you must do it before
	 * calling super().
	 */
	@Override
	public void exit() {
		isRunning = false;
		exit_system();
	}

	/*
	 * Quits everything.  This method can be over ridden in the tests to ensure that
	 * the application actually quits, without actually quitting the application.
	 */
	public void exit_system() {
		System.exit(0);
	}

	/*
	 * Returns true if Masumi is currently running.
	 */
	public boolean is_running() {
		return isRunning;
	}
	
	/**
	 * Starts up Masumi using the normal Main Context and the SwingFactory for Swing style widgets.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Masumi masumi = new Masumi(new SwingFactory());

		masumi.run();
	}

	/**
	 * Masumi has no interaction so it returns null
	 */
	@Override
	public Interaction create_interaction() {
		return null;
	}

}
