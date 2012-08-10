package misc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.*;
import java.util.Properties;

/**
 * @author Yauhen Dubrouka
 */
public class PropertiesApp {

	public static final String KEY = "app.key";

	final private Properties properties;
	final Path workPropPath;

	public PropertiesApp() throws IOException {
		final String propFileName = PropertiesApp.class.getSimpleName() + ".properties";
		this.workPropPath = Paths.get("work", propFileName);
		Files.copy(Paths.get("resources", propFileName), workPropPath, StandardCopyOption.REPLACE_EXISTING);

		this.properties = new Properties();
		try (InputStream inStream = Files.newInputStream(this.workPropPath)) {
			this.properties.load(inStream);
		}
	}

	public void run() {
		System.out.println("app.key=" + properties.getProperty(KEY));
		properties.setProperty(KEY, "UPDATED");
		System.out.println("app.key=" + properties.getProperty(KEY));
		try (OutputStream out = Files.newOutputStream(this.workPropPath, StandardOpenOption.TRUNCATE_EXISTING)) {
			properties.store(out, "updated");
		} catch (IOException e) {
			System.err.println("Cannot save: " + e.getMessage());;
		}
	}

	public static void main(String[] args) throws IOException{
		new PropertiesApp().run();
	}
}
