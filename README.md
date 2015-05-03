Yaka Compiler project
================
*This is an highschool project at INSA Rennes, that's why comments are in french.*

This project is under the MIT licence, see the LICENCE file for more.

Goal
----
Build a compiler for the Yaka language using javacc.

Features
--------
### Language

* Typed (integers and booleans)
* Basic I/O (Display messages and vars, input vars)
* Functions with typed return value and multiple args
* Recursivity

### Compiler

The compiler can build yaka code into either
* Yaka ASM, run on YVM
* i586 Pentium ASM, run on DosBOX

The compiler is designed for new language files to be easy to write.
It check types in expressions and functions call, don't allow multiple vars with same names but different type and check function call, trying to display meaningful error messages.

Build
-----
*Here are some hints on how to proceed...*
```BASH
# Build the compiler, java 1.7+ needed
cd src
javacc Yaka.jj
javac -d ../bin compiler/*.java

# Compile a yaka file into asm
cd bin/
java compiler.Yaka source.yak
```

Yaka language sample
--------------------

```YAKA
PROGRAMME param
ENTIER FONCTION max (ENTIER i, ENTIER j)
VAR BOOLEEN b, c;
VAR ENTIER k;
	k =i;
	SI k>j ALORS RETOURNE k
	SINON RETOURNE j FSI
FFONCTION

ENTIER FONCTION min (ENTIER i, ENTIER j)
	SI i<j ALORS RETOURNE i
		SINON RETOURNE j FSI
	FFONCTION

ENTIER FONCTION sup (ENTIER i, ENTIER j)
	RETOURNE i>j
FFONCTION

PRINCIPAL 
VAR ENTIER i, j, k;
VAR BOOLEEN b;
	i=5;LIRE(j);ALALIGNE;
	k=max (i,min(j,5))+2;
	b=sup(1+max(i,j-5),
			min(i*2,j));
	  ALALIGNE;
	ECRIRE(k);
	ALALIGNE;
	ECRIRE(b);
FPRINCIPAL

FPROGRAMME
```

Roadmap
-------

Dealine    | Checkpoint
-----------|-----------
16/03/2015 | Test expressions & i/o, code review
07/04/2015 | Final code review
11/05/2015 | Exam

Contribute
-----------

### Folder structure
This is a short overview of the folder use:
```
├───doc ............ documentation
├───src ............ java sources
│   ├───compiler ... compiler package
│   └───exception .. exeption package 
└───test ........... test files
    ├───compiler ... JUnit tests
    ├───eval ....... Yaka files provided by teacher for 1rst eval 
    ├───fail ....... Yaka files to test user bad behaviors
    └───ref ........ reference ASM files provided for the course
```

### Todo-list
* Better error handling
* Multithread
* String builder for generation
