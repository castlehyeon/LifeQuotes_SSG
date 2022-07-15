package com.ll.LifeQuotes_SSG;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Util {
    public static void saveToFile(String path, String body) {
        try(RandomAccessFile stream = new RandomAccessFile(path, "rw");
            FileChannel channel = stream.getChannel()){
            byte[] strBytes = body.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
            buffer.put(strBytes);
            buffer.flip();
            channel.write(buffer);
//            stream.close();
//            channel.close();
            //구문생략하는 방법->해당 객체를 try로 빼내면 된다.: try with resources 사용
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mkdir(String path) {
        File dir = new File(path);
        dir.mkdir();
    }

    public static String readFromFile(String path) {
        try (RandomAccessFile reader = new RandomAccessFile(path, "r")){
            String line = reader.readLine();
            return new String(line.getBytes("iso-8859-1"), "utf-8");
            //reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
