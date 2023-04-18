package com.thrivent.lnl.graalvm.polyglot.example;

public class PythonCaller extends ForeignLanguageHelloCaller {

    @Override
    protected String getLanguage() {
        return "python";
    }

    @Override
    protected String getSourceFileName() {
        return "hello.py";
    }

    @Override
    protected String getHelloMethodName() {
        return "say_hello";
    }
    
}
