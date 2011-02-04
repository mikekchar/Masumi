package masumi.swing;

import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import masumi.contexts.Main;
/*
 * This is the main window for the application.
 */
public class MainInteraction implements Main.Interaction {

	private JFrame frame;
	private Main context;
	public ImageIcon icon;
	
	/**
	 * A Mediator to get events from the JFrame
	 * 
	 * @author Mike Charlton
	 *
	 */
	private class FrameMediator extends WindowAdapter {
		private MainInteraction interaction;
		
		FrameMediator(MainInteraction theInteraction) {
			interaction = theInteraction;
		}
		
		/**
		 * The windowClosing event simply requests that the interaction close
		 */
		@Override
		public void windowClosing(WindowEvent arg0) {
			interaction.request_closure();
		}
		
	}

	public MainInteraction(Main aContext) {
		frame = new JFrame();
		context = aContext;
		icon = null;
	}
	
	/**
	 * Open the Main window frame.
	 */
	public void open() {
		frame.setSize(300,400);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new FrameMediator(this));
		frame.setTitle("Masumi");
		URL url = getClass().getResource("resources/icon.png");
		icon = new ImageIcon(url);
		frame.setIconImage(icon.getImage());
		frame.setVisible(true); 
	}
	
	public Image get_icon_image() {
		return frame.getIconImage();
	}
	
	/**
	 * Actually close the window.
	 */
	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}

	/**
	 * Returns true if the frame is visible.
	 */
	public boolean is_open() {
		return frame.isShowing();
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
}
