package com.kmarutyan.interview.misc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ImageCache {

    private long cacheMaxSize;
    private long cacheSize = 0;

    HashMap<String, CacheEntry> hashmap = new HashMap<>();
    LinkedList<String> cache = new LinkedList();

    public ImageCache() {
    }

    public CacheEntry downloadFile(String url) {
        try {
            URL iconURL = new URL(url);
            ImageIcon icon = new ImageIcon(iconURL);

            BufferedImage image = ImageIO.read(iconURL);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            InputStream is = iconURL.openStream();
            byte[] b = new byte[2 ^ 16];
            int read = is.read(b);
            while (read > -1) {
                baos.write(b, 0, read);
                read = is.read(b);
            }
            int countInBytes = baos.toByteArray().length;
            CacheEntry entry = new CacheEntry(url, baos.toByteArray(), countInBytes );

            return entry;

        } catch (Exception e) {
            //rethrow as a runtime exception
            throw new RuntimeException(String.format("Error handling image at %s", url), e);

        }
    }
    public CacheEntry getFromCache(String key) {
        if (!hashmap.containsKey(key)) {
            return null;
        }
        CacheEntry e = hashmap.get(key);
        cache.remove(e);
        cache.addLast(e.key);

        return e;
    }

    public void addToCache(CacheEntry e) {
        if(cacheSize + e.size > cacheMaxSize){
            evict(e);
        }
        hashmap.put(e.key, e);
        cache.addLast(e.key);
        cacheSize +=e.size;
    }

    public void evict(CacheEntry e) {
        hashmap.remove(e.key);
        cache.remove(e.key);
        cacheSize -=e.size;
    }



    public void processFile(String file) {
        try {
            Scanner sc = new Scanner(new File(file));

            // read first line and get cache size
            cacheMaxSize= sc.nextLong();
            sc.nextLine();

            //
            int loops= sc.nextInt();
            sc.nextLine();

            for (int loop : IntStream.range(0, 3).toArray()) {
                String url = sc.nextLine();

                CacheEntry entry = getFromCache(url);
                boolean cacheMiss = false;
                if( entry == null){
                    entry= downloadFile(url);
                    addToCache(entry);
                    cacheMiss= true;
                }
                String status = cacheMiss? "DOWNLOADED": "IN_CACHE";
                String msgOut = String.format("%s %s %d", entry.key, status, entry.size);
                System.out.println(msgOut);
            }

            sc.close();
        } catch (Exception e) {
            // rethrow as a unchecked excpetion
            System.out.println(e);
            new RuntimeException(String.format("Error while parsing file %s", e), e);
        }


    }


    public static void main(String... args) {
        if (args.length < 1) {
            System.out.println(String.format("Wrong number of arguments (%d) were passed to program ", args.length));
            System.exit(1);
        }
        String file = args[0];

        ImageCache cache = new ImageCache();
        cache.processFile(file);


    }
}

class CacheEntry {
    String key;
    Object value;
    long size;
    public CacheEntry( String k, Object val, long size) {
        this.key = k;
        this.value = val;
        this.size = size;
    }
}