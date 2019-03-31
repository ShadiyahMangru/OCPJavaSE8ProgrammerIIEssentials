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
