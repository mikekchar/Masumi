package masumi.swing.mocks;

import masumi.swing.SwingFactory;

public class MockSwingFactory extends SwingFactory {

	@Override
	public boolean showUI() {
		return false;
	}
}
