package com.anna;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;


public class CommandLineArgument {
    @Option(name="-d")
    public String directory;
    public String key;

    @Argument()
    public String name;

    public CommandLineArgument(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

