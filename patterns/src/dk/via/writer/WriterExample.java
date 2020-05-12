package dk.via.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WriterExample {
    public static void main(String[] args) throws Exception {
        FileWriter fileWriter = new FileWriter("C:\\test.txt");
        BufferedWriter bufferedFileWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedFileWriter);
        printWriter.println("Hello");
        printWriter.println(4545);
        // ...
    }
}
