package Frontend;

import java.awt.Desktop;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Logger;

public class Help {

	public void helpURL() throws Exception
	{
		Desktop d= Desktop.getDesktop();
		d.browse(new URI("https://en.wikipedia.org/wiki/Rules_of_chess"));
	}

	
}
