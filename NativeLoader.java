package loader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class NativeLoader {
	
	public static void loadNativeLibrary(String name) throws IOException{
		
		byte[] buffer = new byte[1024];
	    int read = -1;
		
		File temp = File.createTempFile(name, ".dll");
		temp.deleteOnExit();
	
		InputStream inStream = NativeLoader.class.getResourceAsStream("/lib/" + name + ".dll");
	
	    FileOutputStream fOutStream = new FileOutputStream(temp);

	    while((read = inStream.read(buffer)) != -1) {
	        fOutStream.write(buffer, 0, read);
	    }
	    
	    fOutStream.close();
	    inStream.close();

	    System.load(temp.getAbsolutePath());

	}
	
}
