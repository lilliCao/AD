package aufgabenblatt10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class FileGenerator {

	// constructor
	public FileGenerator(int n, String filename) {
		//fileGen(n, filename);
		fileGenDub(n, filename);
	}

	private void fileGen(int number, String filename) {
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < number; i++) {
			try {
				String tmp = this.randomIP() + "--" + this.randomDATA() + " \n";
				writer.write(tmp);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void fileGenDub(int number, String filename) {
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < number; i++) {
			try {
				String tmp = this.randomIP() + "--" + this.randomDATA() + " \n";
				for (int j = 0; j < (int) (Math.random() * 5); j++) {
					writer.write(tmp);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String randomIP() {
		String ip = "";
		for (int i = 0; i < 4; i++) {
			ip += String.valueOf((int) (Math.random() * 255)) + ".";
		}
		return ip.substring(0, ip.length() - 1);
	}

	private String randomDATA() {
		String data = "";
		String[] start = { "GET", "SYN", "ACK", "NO INFOR", "PAKET LOST", "GET INFOR", "SEND" };
		String[] middle = { "IP", "HOST", "PORT", "LOCAL HOST", "NAME", "USER ID", "SERVER ID" };
		String[] end = { "WAITING", "FINISHED", "STARTING", "PAUSE", "WAITING FOR SERVER", "WAITING FOR CLIENT",
				"CONNECTION LOST" };
		data = start[(int) (Math.random() * 7)] + " " + middle[(int) (Math.random() * 7)] + " " + ":"
				+ end[(int) (Math.random() * 7)];
		return data;
	}

	public static void main(String[] args) {
		String filename = "/home/tali/Desktop/hello.txt";
		FileGenerator test = new FileGenerator(10, filename);
		System.out.println(test.randomIP());
		System.out.println(test.randomDATA());

	}
}
