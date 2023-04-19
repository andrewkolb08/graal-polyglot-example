package com.thrivent.lnl.graalvm.polyglot.example;

public class CCaller extends ForeignLanguageHelloCaller{

    @Override
    protected String getLanguage() {
        return "llvm";
    }

    @Override
    protected String getSourceFileName() {
       return "hello.so";
    }

    @Override
    protected String getHelloMethodName() {
        return "say_hello";
    }
    
}
