package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

	  public static void main(String[] args) throws IOException {
	        String filename = "D:\\3.1\\3.1\\OOP-LAB\\Lab3\\OthersProjects\\src\\hust\\soict\\dsai\\garbage\\test.txt";
	        byte[] inputBytes = { 0 };
	        long start, end;
	        inputBytes = Files.readAllBytes(Paths.get(filename));
	        start = System.currentTimeMillis();
	        String outputString = "";
	        for(byte b : inputBytes) {
	            outputString += (char)b;
	        }
	        end = System.currentTimeMillis();
	        System.out.println(end - start);
	    }
}