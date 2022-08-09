package application;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
		//example of bin files are .gif, .png, .wav, etc
		
		String filename = "test.bin";
		File file = new File(filename);
		
		int value = 1;
		byte[] bytes = new byte[2];
		bytes[0] = 2;
		bytes[1] = 3;
		
		try(var dos = new DataOutputStream(new FileOutputStream(file))) {
			dos.writeInt(value);
			dos.write(bytes);

		} catch (FileNotFoundException e) {
			System.err.println("Cannot create: " + file.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Cannot write: " + file.getAbsolutePath());
			e.printStackTrace();
		}
		System.out.println("Written " + file.getAbsolutePath());
		System.out.println("Written " + file.length());
	}

}
