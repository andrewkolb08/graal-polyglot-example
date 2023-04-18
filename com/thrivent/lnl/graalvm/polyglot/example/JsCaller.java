package com.thrivent.lnl.graalvm.polyglot.example;

public class JsCaller extends ForeignLanguageHelloCaller{

    @Override
    protected String getLanguage() {
        return "js";
    }

    @Override
    protected String getSourceFileName() {
       return "hello.js";
    }

    @Override
    protected String getHelloMethodName() {
        return "sayHello";
    }
    
}
