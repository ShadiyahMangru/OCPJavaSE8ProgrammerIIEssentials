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
- Arrays:
   - built-in data structure that contains other objects or primitives
   - length variable to check number of elements
   - asList() converts array to a List that is not resizable but honors all other methods in List interface
- ArrayLists:
   - cannot contain primitives
   - get()
   - size()
- Wrapper Classes:
   - each primitive has a corresponding wrapper class for when an object required
- Autoboxing:
   - automatically converts a primitive to the corresponding wrapper class (e.g. int to Integer).
   - unboxing automatically converts a wrapper class back to a primitive
- Diamond Operator:
   - specifies allowed object types (e.g., ```ArrayList<Integer> iArrayL = new ArrayList<>();``` adding 4.36 to iArrayL is invalid)
   - empty diamond operator to avoid redundant/verbose code
- Searching:
   - binary search assumes input sorted (if no match found, returns ONE LESS THAN negated index of where the requested value would need to be inserted)
- Sorting:

- Generic classes:
   - Generic classes become useful when the classes used as the type parameter can have absolutely nothing to do with each other (e.g., ```public class Roster<T>{}``` T might be a HockeyPlayer object, a SoccerPlayer object, a SynchronizedSwimmer object, a BaseballPlayer object, etc.
   - Naming Conventions: E -- element, K -- map key, V -- map value, N -- number, T -- generic data type, S,U,V -- and so forth for multiple generic types
   - generic classes aren't limited to having a single type parameter (e.g., ```<T, U>```)
   - TYPE ERASURE allows your code to be compatible with older versions of Java that do not contain generics.
   
...
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
- **Stream Base Classes:**
   - InputStream, OutputStream, Reader, and Writer abstract classes (cannot instantiate an instance of it) are parents of all Java stream classes.  Note: ObjectInputStream's inherited parent is InputStream; BufferedWriter's inherited parent is Writer; exception: PrintStream's inherited parent is OutputStream.
   - high-level stream CONSTRUCTORS often use a reference to the abstract parent class.  This enables high-level stream classes to be used much more often without concern for particular underlying stream subclass.
- **Decoding Java I/O Class Names:**
   - when wrapping a stream, can mix and match only types that inherit from same abstract parent stream
   - low-level: FileInputStream, FileOutputStream, FileReader, FileWriter
   - high-level: BufferedReader, BufferedWriter, ObjectInputStream, ObjectOutputStream, InputStreamReader, OutputStreamWriter, PrintStream, PrintWriter
- **Common Stream Operations:** 
   - Closing the Stream: (exceptions and assertions) close() in a finally block or try-with-resource syntax
   - Flushing the Stream
   - Marking the Stream: some (if not supported, exception at runtime) java.io input stream classes include methods to move stream back to an earlier position
   - Skipping over Data: InputStream and Reader classes include skip(long) method to skip over a certain number of bytes
- **Working With Streams:**
- **FileInputStream and FileOutputStream classes:**
   - used to read bytes from a file or write bytes to a file, respectively; include constructors that take a File object or String, representing a path to the file
   - read() returns -1 when end of stream/file reached
   - note for output: if destination file already exists, will be overwritten
   - note for input: FileNotFoundException (subclass of IOException) if file not found
- **BufferedInputStream and BufferedOutputStream classes:**
   - to wrap FileInputStream and FileOutputStream
   - common to use Buffered classes anytime reading/writing data with byte arrays (because of performance improvement when move from nonbuffered to buffered file access)
- **FileReader and FileWriter classes:**
   - read/write char values
   - -1 returned when end of file detected
   - write(String) to write a String object directly to the stream
- **BufferedReader and BufferedWriter classes:** 
   - note `writeFile(List<String> data, File destination)` example
   - stop reading file when readLine() returns null
   - to avoid deciphering character encodings yourself
- **ObjectInputStream and ObjectOutputStream classes:** 
   - serialization: converting an in-memory object to a stored data format
   - deserialization: converting stored data into an object
   - ObjectInputStream and ObjectOutputStream are two stream classes for object serialization and deserialization
   - these classes support reading and writing null objects (important to check for null values when reading from a serialized data stream)
   - note: the constructor and any default initializations ignored during deserialization process
- **PrintStream and PrintWriter classes:**
   - PrintStream class operates on OutputStream instances and writes data as bytes.  System.out and System.err are PrintStream objects.
   - PrintWriter class operates on Writer instances and writes data as characters.  Has methods that convert everything to String values.
   - write() throws a checked IOException that must be caught in your application
   - print() same line
   - println() new line
   - format() line break after text NOT automatically inserted
   - format() and printf() take an optional vararg and formats the output
- **FilterInputStream and FilterOutputStream:**
   - Filter classes are the superclass of all classes that filter or transfer data
   <br>
- **Interacting with Users:**
   - java.io.Console recommended for interacting with and displaying info to user
   - Console class is a singleton (only 1 version of the object available in JVM)
   - useful for exception handling: System.console() will return null in environments where text interactions are not supported
   - Console class has far more options than System.in and System.out resources
   - reader() and writer() -- handle underlying character encoding automatically (to work with char and String data)
   - format() and printf() -- each take a String format and list of arguments
   - flush() -- forces any buffered output to be written immediately
   - readLine() -- retrieves single line of text from user (user presses Enter key to terminate it)
   - readLine(String format, Object... args) -- displays formatted prompt to user before accepting text
   - readPassword() -- echoing disabled (user does not see text s/he typing); returns an array of characters instead of a String (for security reasons); another precaution: immediately clear the character arrays that store the password as soon as they are no longer needed in the application
   <br>
- **Summary:**
   - java.io streams: byte vs. character (Reader/Writer for character)
   - common practice to start with a low-level resource or file stream and wrap it in a buffered stream to improve performance
   - Console class -- support for passwords and built-in support for String formatting
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

<br>

## Additional References
- Kaplan IT Training Course 1Z0-809 365-Day eLearning (Online)
