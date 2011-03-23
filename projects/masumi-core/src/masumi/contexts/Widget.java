package masumi.contexts;

/**
 * A Widget  represents the main UI container for an Interaction.
 * The main reason for having a Widget is simply to abstract the
 * layout of UI components.  When an Interaction is opened, it's
 * UI must be added to the container of it's parent.  Thus each
 * Interaction has exactly one Widget that must be able to
 * contain other widgets.  Exactly how they are laid out is
 * dependent upon the action Interaction.
 * 
 * @author mike
 *
 */
public interface Widget {
	public void add(Widget aWidget);
	public void remove(Widget aWidget);
}
