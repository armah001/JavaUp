package amalitech;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

public class NIO {
    public static void main(String[] args) throws IOException {
        // File to read from
        File file = new File("C:\\Users\\NiiArmahNyamOdasseyT\\Desktop\\JavaUp-main\\data.txt");

        // Open the file channel in read-only mode
        try (FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.READ)) {
            // Allocate a byte buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int bytesRead;
            do {
                //read data into the buffer
                bytesRead = channel.read(buffer);

                // Process the read data
                if (bytesRead > 0) {
                    // Handle data processing here
                    System.out.println(new String(buffer.array(), 0, bytesRead));
                    buffer.clear(); // Prepare the buffer for the next read operation
                }
            } while (bytesRead > 0); // Continue reading until EOF
        }

    }
}