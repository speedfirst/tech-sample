package org.speedfirst;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Generate bdb with native db_load api
 */
public class BDBMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        createBDBFromFile();
        createBDBFromPipe();
    }


    private static void createBDBFromFile() throws InterruptedException, IOException {
        String path = ClassLoader.getSystemResource("source.txt").getPath();
        File target = new File("my-test-file.bdb");
        System.out.println("Load " + path + " to BDB " + target.getAbsolutePath());
        String[] cmd = {"/bin/bash", "-c", "cat " + path + " | db_load -T -t hash " + target.getName()};
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        p.getInputStream().close();

    }

    private static void createBDBFromPipe() throws InterruptedException, IOException {
        Map<String, String> pairs = new LinkedHashMap<>();
        pairs.put("key1", "value1");
        pairs.put("key2", "value2");
        pairs.put("key3", "value3");
        pairs.put("key4", "value4");

        File target = new File("my-test-pipeline.bdb");
        System.out.println("Load key/value pairs  to BDB " + target.getAbsolutePath());
        String cmd = "db_load -T -t hash " + target.getName();
        Process p = Runtime.getRuntime().exec(cmd);
        InputStream is = p.getInputStream();
        OutputStream os = p.getOutputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os));

        for (String key: pairs.keySet()) {
            bufferedWriter.write(key + "\n");
            bufferedWriter.write(pairs.get(key) + "\n");
        }
        bufferedWriter.close();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();

    }
}
