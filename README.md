Yaka Compiler project
================
*This is an highschool project at INSA Rennes, that's why comments are in french.*

This project is under the MIT licence, see the LICENCE file for more.

Goal
----
Build a compiler for the Yaka language using javacc.

Features
--------
The compiler can build yaka code into either
* Yaka ASM, run on YVM
* i586 Pentium ASM, run on DosBOX

The compiler is designed for new language files to be easy to write.

Build
-----
*Here are some hint on how to proceed...*
```BASH
# Build the compiler, java 1.7+ needed
cd src
javacc Yaka.jj
javac -d ../bin compiler/*.java

# Compile a file
cd bin/
java Yaka.java source.yak
```

Yaka language sample
--------------------

```YAKA
PROGRAMME max
  CONST
    aa=10,
    ba=VRAI,
    cc=aa;
  VAR ENTIER c1, c2, c3, c4, c5;
  VAR BOOLEEN b1, b2;
    c1=(aa+cc/2)/5;
    c2=c1+3*c1-aa;
    b2=(c1<=(c2+4));
FPROGRAMME
```

Roadmap
-------

Dealine    | Checkpoint
-----------|-----------
16/03/2015 | Test expressions & i/o, code review
07/03/2015 | Final code review
11/05/2015 | Exam

Todo List
---------

* Basic compiler
* Multithread
* String builder for generation
