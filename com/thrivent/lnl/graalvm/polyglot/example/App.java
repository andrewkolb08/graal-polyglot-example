package com.thrivent.lnl.graalvm.polyglot.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App{

    static final Map<String, HelloCaller> callerMap = Map.of("java", new JavaCaller(),
                                                             "python", new PythonCaller(),
                                                             "js", new JsCaller(),
                                                             "c", new CCaller());

    public static void main(String[] args) {
        final String NAME = "Andrew";
        List<String> languages = Arrays.asList(args);

        languages.stream().forEach(language -> {
            HelloCaller helloCaller = callerMap.get(language);
            System.out.println(helloCaller.sayHello(NAME));
        }); 
    }
}