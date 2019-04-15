package com.anna;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.CmdLineException;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        CommandLineArgument values = new CommandLineArgument(args);

        System.out.println(values.name);
        System.out.println(values.directory);
        System.out.println(values.key);
    }

    public void FileSearch (String name, String directory, String key) {
        File wantedDirectory = new File(directory);
        String wantedFile = name;
    }
}
