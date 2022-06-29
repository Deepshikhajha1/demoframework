package screen;

import script.BaseScript;
import util.PropertyReader;

public class BaseScreen extends BaseScript {

	public void launchHome() {
		getDriverObject().get(PropertyReader.getInstance().getProperty("url"));
	}

}
