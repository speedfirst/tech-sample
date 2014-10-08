package org.speedfirst.test.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jiankuan on 9/19/14.
 */
public class MemoryMappedFile {

    private static int count = 10 * 1024; // 10KB

    public static void main(String[] args) throws IOException {
        RandomAccessFile memoryMappedFile = new RandomAccessFile("largeFile.txt", "rw");

        MappedByteBuffer out = memoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, count);
        for (int i = 0; i < count; i++) {
            out.put((byte) 'A');
        }
        for (int i = 0; i < 10; i++) {
            System.out.println((char)out.get(i));
        }
    }
}
