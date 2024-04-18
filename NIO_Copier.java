package amalitech;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIO_Copier {
    public static void main(String[] args) throws IOException {
        // File to read from
        Path sourcePath = Paths.get("C:\\Users\\NiiArmahNyamOdasseyT\\Desktop\\JavaUp-main\\data.txt");

        // File to write to
        Path destinationPath = Paths.get("C:\\Users\\NiiArmahNyamOdasseyT\\Desktop\\JavaUp-main\\copy.txt");

        // Create the destination file if it doesn't exist
        if (!Files.exists(destinationPath)) {
            Files.createFile(destinationPath);
        }

        // Open the source file channel in read mode
        try (FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
             // Open the destination file channel in write mode
             FileChannel destinationChannel = FileChannel.open(destinationPath, StandardOpenOption.WRITE)) {

            // Allocate a byte buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Read the data from the source file into the buffer and write it to the destination file
            while (sourceChannel.read(buffer) > 0) {
                // Prepare the buffer for writing
                buffer.flip();

                // Write the data from the buffer to the destination file
                while (buffer.hasRemaining()) {
                    destinationChannel.write(buffer);
                }

                // Prepare the buffer for the next read operation
                buffer.clear();
            }
        }
    }
}