# GraalVM Polyglot Example
_An example of running multiple languages and calling them within Java_

Note, this guide assumes you have JAVA_HOME set to point to a Graal JDK.  Example using SDKMAN!:
```bash
sdk use java 22.3.r19-grl 
```

## Compile the application (Java & Native)
```bash
javac -d target com/thrivent/lnl/graalvm/polyglot/example/App.java
cp com/thrivent/lnl/graalvm/polyglot/example/*.py target/com/thrivent/lnl/graalvm/polyglot/example
cp com/thrivent/lnl/graalvm/polyglot/example/*.js target/com/thrivent/lnl/graalvm/polyglot/example
```

To make it a native app:
```bash
native-image -H:Name=App --language:python -cp ./target com.thrivent.lnl.graalvm.polyglot.example.App
```

## Run the application
As a typical Java app:
``` bash
java -cp target com.thrivent.lnl.graalvm.polyglot.example.App
```

As a native app
```bash
./App
```