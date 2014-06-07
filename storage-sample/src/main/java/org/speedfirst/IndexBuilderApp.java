package org.speedfirst;

import org.apache.commons.cli.*;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Hello world!
 *
 */
public class IndexBuilderApp {
    public static void main(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("f", true, "indicate the file path");
        options.addOption("h", false, "print usage");

        CommandLineParser parser = new BasicParser();
        CommandLine cmd = parser.parse(options, args);
        if (cmd.hasOption("h")) {
            HelpFormatter helpFormatter = new HelpFormatter();
            helpFormatter.printHelp("build-index", options);
            System.exit(0);
        }
        String a = "abc";
        String md5Str = DigestUtils.md5Hex(a);
        System.out.println(md5Str);
    }
}
