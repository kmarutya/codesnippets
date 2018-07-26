package com.kmarutyan.interview.io;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.WRITE;
import static java.nio.file.StandardOpenOption.READ;

//import static java.nio.file.AccessMode.WRITE;
//import static java.nio.file.AccessMode.READ;


public class RamAccess {

    public static void readFile(String path){

        Path file = Paths.get(path);
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        try(FileChannel fc = (FileChannel.open(file, READ,WRITE))){

            // Read the first 12
            // bytes of the file.
            int nread;
            do {

                nread = fc.read(byteBuffer);
                System.out.println(nread);

                String s = new String(byteBuffer.array(), "ASCII");

                System.out.println(s);
                byteBuffer.flip();
//                System.exit(0);
            } while (nread != -1 );

        } catch (IOException x) {
            System.out.println("I/O Exception: " + x);
        }
    }

    public static void main(String... args){
        /**
         * Returns the current size of this channel's file.
         *
         * @return  The current size of this channel's file,
         *          measured in bytes
         *
         * @throws  ClosedChannelException
         *          If this channel is closed
         *
         * @throws  IOException
         *          If some other I/O error occurs
         */
        String path = "data/samples/sample.txt";
        readFile(path);

    }
}
