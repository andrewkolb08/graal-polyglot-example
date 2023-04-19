# GraalVM Polyglot Example
_An example of running multiple languages and calling them within Java_

Note, this guide assumes you have JAVA_HOME set to point to a Graal JDK.  Example using SDKMAN!:
```bash
sdk use java 22.3.r19-grl 
```

## Set env variables
```
export LLVM_TOOLCHAIN=$(lli --print-toolchain-path)
```

## Compile the application (Java & Native)
```bash
javac -d target com/thrivent/lnl/graalvm/polyglot/example/App.java
$LLVM_TOOLCHAIN/clang -shared com/thrivent/lnl/graalvm/polyglot/example/hello.c -lgraalvm-llvm -o hello.so
cp com/thrivent/lnl/graalvm/polyglot/example/*.py target/com/thrivent/lnl/graalvm/polyglot/example
cp com/thrivent/lnl/graalvm/polyglot/example/*.js target/com/thrivent/lnl/graalvm/polyglot/example
cp *.so target/com/thrivent/lnl/graalvm/polyglot/example

```

To make it a native app:
```bash
native-image -H:Name=App \
-H:ResourceConfigurationFiles=resource-config.json \
--language:python \
--language:js \
--language:llvm  \
--verbose \
--native-image-info \
-cp ./target com.thrivent.lnl.graalvm.polyglot.example.App
```

## Run the application (Java)
As a typical Java app:
``` bash
java -cp target com.thrivent.lnl.graalvm.polyglot.example.App
```

## Run the application (Native)
```bash
./App
```