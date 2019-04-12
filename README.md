# OCP Java SE 8 Programmer II Essentials

## Java Class Design
 - Know traits of singleton classes and immutable classes.
 - With a method override, access modifier must NOT be more specific.
 - Singleton pattern requires that only ONE instance of the class exist.  To prevent default no-argument constructor from being available, a singleton class should have a PRIVATE CONSTRUCTOR in each class.
 - Lazy instantiation (in the Singleton pattern) defers creating the object until the first caller requests it.
 - with *protected* access modifier: accessible in same package or in subclasses in a different package
 - with *default* access modifier: package-private
 - What does the code below print?
 ```
 class Laptop extends Computer {
     String type = "laptop";
 }
 
 public class Computer {
     String type = "computer";
     public static void main(String[] args) {
         Computer computer = new Laptop();
         Laptop laptop = new Laptop();
         System.out.println(computer.type + " ," + laptop.type);
     }
 }
 ```
 This prints ```computer ,laptop``` .  For instance variables, Java looks at the type of the reference and calls the appropriate variable. 

<br>

## Advanced Java Class Design
<br>

## Generics and Collections
<br>

## Lambda Built-in Functional Interfaces
 - A functional interface has exactly one abstract method.
 - Java does NOT include built-in support for primitive functional interfaces that include float, char, or short; there is nothing, however, to prevent a developer from creating them in their own project.
 - The java.util.function package does NOT include any functional interfaces that operate on the primitive float.
- Java only includes primitive functional interfaces that operate on double, int, or long.
 - A Function needs to specify TWO generics -- the input parameter type and the return value type.
 - It IS possible to have a functional interface that takes no values and returns void (e.g., Runnable).
 - BiPredicate takes two generic types and returns a **primitive** boolean value (NOT a Boolean object).
 - Important to know number of parameters, types, return value, and method name for each of the functional interfaces.

<br>

## Java Stream API
<br>

## Exceptions and Assertions
<br>

## Java SE 8 Date/Time API
Import java.time.*; 
- LocalDate – just a date
- LocalTime – just a time (hours/minutes/seconds/nanos (fractional seconds))
- LocalDateTime – date and time (Java uses T to separate date and time when converting LocalDateTime to a String)
- ZonedDateTime – date and time and time zone

now() – static method that gives current date and time (in each of 4 aforementioned classes)

time zone offset:
- w/minus: add offset to time
- w/plus: subtract offset from time

Month is an enum (enum is NOT an int and cannot be compared to one)

Can combine dates and times into one object (ex. LocalDateTime.of(date1, time1);)

3 options to create ZonedDateTime
- all fields passed individually (with time zone object as last field)
- public static ZonedDateTime of(LocalDate date, LocalTime time, ZoneId zone)
- public static ZonedDateTime of(LocalDateTime dateTime, ZoneId zone)

No constructors used with date and time classes (cannot construct a date or time object directly).  Date and Time classes have private constructors to force you to use the factory’s static methods.
Ex. LocalDate d = new LocalDate(); //DOES NOT COMPILE

DateTimeException thrown for invalid values (e.g., January 32nd)

With immutable types, make sure return value of a method is not ignored: Date and Time classes immutable, therefore remember to assign the results of these methods to a reference variable so that they are not lost.

Adding to / subtracting from dates and times: plusDays(), plusMonths(), minusHours(), ….

Java hides seconds and nanoseconds when not using them.

5 ways to create a Period class: ofYears(int y), ofMonths(int m), ofWeeks(int w), of Days(int d), of(int y, int m, int d) -- Cannot chain methods when creating a Period

Review printing of Periods format as Strings
- Ex. System.out.println(Period.of(0, 20, 47)); //P20M47D
- Ex. System.out.println(Period.ofWeeks(3)); //P21D

Durations: intended for smaller units of time than Periods; specify days/hours/minutes/seconds/nanos.  Used with objects that have TIME (String output beginning with PT).  ofDays(int d), ofHours(int h), ..., ofNanos(int n).  Does not have a constructor that takes multiple units like Period class does.

ChronoUnit: (ex. Duration daily = Duration.of(1, ChronoUnit.DAYS);).  Can be used to determine how far apart two Temporal values are. Ex. ChronoUnit.HOURS.between(LocalTime one, LocalTime two). dateTime.plus(duration) OK, time.plus(duration) OK, date.plus(duration) NOT OK.

LocalTime cannot be used with Period.  LocalDate cannot be used with Duration.

Instant: specific moment in time in GMT time zone (converts to a common unit of measure).  Instant displays a year and month while preventing you from doing math with those fields.

Daylight Savings Time: One day in March that is 23 hours long.  One day in November that is 25 hours long.  Note time 'jumps/repeats' and different UTC offsets before and after 2am time 'jump/repeat'.

<br>

## Java I/O Fundamentals
- java.io API
- can design code that writes the current state of an application to a file every time application closed, and reloads data when application executed the next time
- **file:** record within a file system that stores user and system data
- **directory:** record within a file system that contains files as well as other directories (often refer to a directory reference as a file record)
- **root directory:** topmost directory in the file system (from which all files and directories inherit)
- **file system:** in charge of reading and writing data within a computer
- **path:** a String representation of a file or directory within a file system
- **File class (java.io.File):** used to read information about existing files and directories, list the contents of a directory, and create/delete files and directories.
  - an instance of a File class represents the pathname of a particular file or directory on the file system; can be passed as a reference to many stream classes to read or write data
- **absolute path:** full path from root directory to the file or directory
- **relative path:** path from current working directory to file or directory
- Java offers 2 options to retrieve local separation character within a path statement:
   - system property: System.getProperty("file.separator")
   - static variable: java.io.File.separator
- Commonly-used java.io.File methods: exists(), getName(), getAbsolutePath(), isDirectory(), isFile(), length(), lastModified(), delete(), renameTo(File), mkdir(), mkdirs(), getParent(), listFiles()
- note: \\ -- backslash must be escaped with another backslash to be used within a String

**Streams**

- **input:** reading the data from a resource
- **output:** writing the data to a resource
- the contents of a file may be accessed or written via a stream, which is a list of data elements presented sequentially
- the stream allows the application to focus on only a small portion of the overall stream at any given time
- streams with the word **Buffered** in their name read or write GROUPS of bytes or characters at a time
   - By utilizing the **BufferedOutputStream**, the Java application can write a large chunk of bytes at a time, reducing the round trips between the Java application and the file system and drastically improving performance
- Java provides three built-in streams: System.in, System.err, System.out
- **Byte Streams vs. Character Streams:** 
   - the stream classes (all contain InputStream or OutputStream in their names) are used for inputting and outputting all types of binary or byte data (ex. FileInputStream)
   - the reader and writer classes are used for inputting and outputting only character and String data (ex. FileReader)
- **Input and Output:**  
   - note: PrintWriter has NO accompanying PrintReader class.  PrintStream class has no corresponding InputStream class.
- **Low-Level vs. High-Level Streams:**  
   - low-level: stream that connects directly with the source of the data, such as a file, an array, or a String
   - high-level: stream that is built on top of another stream using wrapping (ex. FileInputStream is a low-level stream that interacts directly with the file; this can be wrapped by the high-level BufferedInputStream to improve performance)

...


<br>

## Java File I/O (NIO.2)
<br>

## Java Concurrency
<br>

## Building Database Applications with JDBC
<br>

## Localization
<br>
<br>

## Sources
- OCP: Oracle Certified Professional Java SE 8 Programmer II Study Guide (Sybex)
- OCA/OCP Java SE 8 Programmer Practice Tests (Sybex)
