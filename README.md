Compiler project
================

Goal
----

Build a compiler for the Yaka language using javacc.
*This is an highschool project at INSA Rennes, that's why comments are in french.*

Features
--------

The compiler can build yaka code into either

* Yaka ASM, run on YVM
* x86 Pentium ASM, run on DosBOX

Build
-----

```BASH
cd src/
javacc ../Yaka.jj
javac -d ../bin *
```

Yaka language sample
--------------------

```YAKA
PROGRAMME max
  CONST
    aa=10,
    ba=VRAI,
    cc=aa;
  VAR ENTIER c1, c2, c3, c3, c4, c5;
  VAR BOOLEEN b1, b2;
    c1=(aa+cc/2)/5;
    c2=c1+3*c1-aa;
    b2=(c1<=(c2+4));
FPROGRAMME
```

Roadmap
-------

* _16/03/2015_ Test exp & i/o, code review
* _07/03/2015_ Final code review
* _11/05/2015_ Exam

Todo List
---------

* Basic compiler
* Multithread
* String builder for generation
