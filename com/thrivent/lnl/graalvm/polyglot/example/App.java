package com.thrivent.lnl.graalvm.polyglot.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {

    static final Map<String, HelloCaller> callerMap = Map.of("java", new JavaCaller(),
                                                             "python", new PythonCaller(),
                                                             "js", new JsCaller(),
                                                             "c", new CCaller());

    public static void main(String[] args) {
        final String NAME = "Andrew";
        Set<String> supportedLanguages = callerMap.keySet();
        List<String> languages = Arrays.asList(args);

        if(!supportedLanguages.containsAll(languages)){
            System.out.println("Unsupported language passed. Supported languages include: " + 
                                        supportedLanguages);
        }
        else{
            languages.stream().forEach(language -> {
                HelloCaller helloCaller = callerMap.get(language);
                System.out.println(helloCaller.sayHello(NAME));
            }); 
        }
    }
}