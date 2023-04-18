package com.thrivent.lnl.graalvm.polyglot.example;

import java.io.IOException;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

public abstract class ForeignLanguageHelloCaller implements HelloCaller {
    private Value foreignFunction;

    protected ForeignLanguageHelloCaller() {
        Context context = Context.newBuilder()
                .allowAllAccess(true)
                .build();

        Source source;
        try {
            source = Source.newBuilder(getLanguage(), this.getClass().getResource(getSourceFileName())).build();
        } catch (IOException e) {
            throw new RuntimeException("Failed to setup " + getLanguage() + " context.", e);
        }
        context.eval(source);
        this.foreignFunction = context.getBindings(getLanguage()).getMember(getHelloMethodName());
    }

    public String sayHello(String name) {
        Value output = foreignFunction.execute(name);
        return output.asString();
    }

    protected abstract String getLanguage();
    protected abstract String getSourceFileName();
    protected abstract String getHelloMethodName();
}
