package com.thrivent.lnl.graalvm.polyglot.example;

public class JavaCaller implements HelloCaller{
    public String sayHello(String name){
        return "Hello, " + name + ", from the world of Java!";
    }
}
