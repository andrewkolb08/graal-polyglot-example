#include <graalvm/llvm/polyglot.h>

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#define MAX 100

void prepend(char* s, const char* t);

void* say_hello(void* input){
    char* buffer;
    buffer = (char*) malloc(MAX*sizeof(char));
    polyglot_as_string(input, buffer, sizeof(buffer), "UTF-8");
    prepend(buffer, "Hello, ");
    strcat(buffer, ", from the world of C!");

    return polyglot_from_string(buffer, "UTF-8");
}

void prepend(char* s, const char* t)
{
    size_t len = strlen(t);
    memmove(s + len, s, strlen(s) + 1);
    memcpy(s, t, len);
}