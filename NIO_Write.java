package amalitech;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIO_Write {
    public static void main(String[] args) throws IOException {
        // File to write to
        Path path = Paths.get("C:\\Users\\NiiArmahNyamOdasseyT\\Desktop\\JavaUp-main\\nioOutput.txt");

        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        // Open the file channel in read-only mode
        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            // Allocate a byte buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            String data = "This text was read .";
            buffer.put(data.getBytes());

            // Prepare the buffer for writing
            buffer.flip();

            // Write the data from the buffer to the file
            while (buffer.hasRemaining()) {
                channel.write(buffer);
            }
        }
    }
}