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

Durations: intended for smaller units of time than Periods; specify days/hours/minutes/seconds/nanos

...
<br>

## Java I/O Fundamentals
<br>

## Java File I/O (NIO.2)
<br>

## Java Concurrency
<br>

## Building Database Applications with JDBC
<br>

## Localization
<br>
