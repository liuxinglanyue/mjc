MiniJava Compiler (`mjc`)
=========================

* [Building](#building)
* [Running](#running)
* [Hacking in Eclipse](#hacking-in-eclipse)
* [Submitting to TIGRIS](#submitting-to-tigris)

This is a compiler for a slightly modified version of the MiniJava
language described in Appel's *Modern Compiler Implementation in Java*.
It was created as part of the course *DD2488 Compiler Construction* at
KTH. The compiler supports the basic language described
[here](http://www.csc.kth.se/utbildning/kth/kurser/DD2488/komp14/project/grammar14v1b.pdf),
with the following extensions:

| Code                    | Description                                  |
| ----------------------- | -------------------------------------------- |
| **ARM**                 | ARM CPU backend with register allocation     |
| **LONG**                | add long and long\[\]                        |
| **IWE**                 | 'if' statements with or without 'else'       |
| **NBD**                 | nested blocks with new variable declarations |
| **ABC**                 | array bounds checks                          |
| **CLE CGT CGE CEQ CNE** | comparison operators                         |
| **BDJ**                 | logical OR connective                        |

Building
--------

Type `ant` in the top-level directory. This will build the compiler,
run the unit tests, and produce `mjc.jar`. See `ant -projecthelp` for
the different available targets. Here's a hopefully up to date list:

    Main targets:
     clean    Delete all generated files
     compile  Compile all sources
     jar      Build compiler JAR file
     report   Build report PDF file
     submit   Submit TAR archive to TIGRIS
     tar      Build compressed source-only TAR archive
     test     Run the unit tests
    Default target: jar

The compiler requires Java 7.

Running
-------
To run the compiler, type

    ./mjc foo.java -S

where `foo.java` is the MiniJava source file to be compiled. The available
command line options are:

    usage: mjc <infile> [options]
     -S             output assembly code
     -o <outfile>   output file
     -p             print abstract syntax tree
     -g             print abstract syntax tree in GraphViz format
     -s             print symbol table
     -h             show help message

Hacking in Eclipse
------------------

To get started in Eclipse, make an initial build with Ant by typing `ant`,
then perform the following steps in a new or existing Eclipse workspace:

1. **File → New → Java Project**.
2. Enter **mjc** as **Project name**.
3. Uncheck **Use default location** and pick the **mjc**
   folder as **Location**.
4. Click **Next**.
7. Check the **Allow output folders for source folders** checkbox,
   and then press **Configure Output Folder Properties** for each
   of **build/parser-src**, **src/main/java** and **src/test/java**
   to configure the output folders as follows:
    * **build/parser-classes** for **mjc/build/parser-src**
    * **build/main-classes** for **mjc/src/main/java**, and
    * **build/test-classes** for **mjc/src/test/java**.
8. Make sure **src/test/resources** is not used as a source folder,
   since it just contains input tests for the parser.
9. Under the **Libraries** tab, remove **mjc.jar** from the build path.
10. Click **Finish** to create the project.

**That's it!**

### Suppressing Warnings in Generated Code
The sources in **build/parser-src** generated by SableCC have some warnings.
To suppress them, in the properties for the **build/parser-src** source folder,
under **Java Compiler**, check **Ignore optional compile problems**

This is only possible in Eclipse Juno or later. In older Eclipse versions,
you instead have to go into **Configure Contents...** in the **Problems**
panel menu and create a new **Scope** that covers a working set containing
only **src/main/java** and **src/test/java**, but not **build/parser-src**.
This will prevent the warnings from showing up in the **Problems** panel.
The **Package Explorer** will still show an exclamation mark for the folder
though.

Submitting to TIGRIS
--------------------

To create a compressed source-only TAR archive and submit it by e-mail to
the TIGRIS judging system, make sure the `TIGRIS_ID` and `TIGRIS_EMAIL`
environment variables are set to your TIGRIS ID and submission e-mail, then
type

    ant submit

You may also specify the ID and e-mail using the `-Dtigris.id` and
`-Dtigris.email` ANT options. This will override the values set by the
environment variables. By default the submission is sent to
`submit@tigris.csc.kth.se`. This may be changed using the `-Dtigris.to`
option.

The target uses the script in `tools/submit`. The script depends on the
`uuencode` command from GNU sharutils and uses the `mail` command to send
the mail.
