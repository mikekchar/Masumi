package masumi.contexts;

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
	
	protected boolean isRunning;
	
	protected Masumi(InteractionFactory aFactory) {
		super(aFactory);
		isRunning = false;
		aFactory.loadStrings();
	}

    /**
     * Returns the version information for this application.
     * @return the version
     */
    public String version() {
        return Masumi.class.getPackage().getImplementationVersion();
    }
	
	/*
	 * Creates a new MainContext.  This can be overridden to setup the context before entering it.
	 */
    Context create_main_context(InteractionFactory factory) {
	    return new Main(factory);
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
    protected void exit_system() {
		System.exit(0);
	}

	/*
	 * Returns true if Masumi is currently running.
	 */
	public boolean is_running() {
		return isRunning;
	}
	
	/**
	 * Masumi has no interaction so it returns null
	 */
	@Override
	public Interaction create_interaction() {
		return null;
	}

}
