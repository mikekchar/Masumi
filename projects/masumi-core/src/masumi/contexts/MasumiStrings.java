package masumi.contexts;

import java.util.ListResourceBundle;

public class MasumiStrings extends ListResourceBundle {

	private final static Object[][] contents = {
		{ "exploreProblem", "Type here to explore a problem." }		
	};
	
	protected Object[][] getContents() {
		return contents;
	}

}
