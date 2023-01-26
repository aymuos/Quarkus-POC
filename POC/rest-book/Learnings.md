- Optional Class
  Optional is a container object which may or may not contain a non-null value. You must import java.util package to use this class. If a value is present, isPresent() will return true and get() will return the value. Additional methods that depend on the presence or absence of a contained value are provided, such as orElse() which returns a default value if the value is not present, and ifPresent() which executes a block of code if the value is present. This is a value-based class, i.e their instances are :

  Final and immutable (though may contain references to mutable objects).
  Considered equal solely based on equals(), not based on reference equality(==).
  Do not have accessible constructors. https://www.geeksforgeeks.org/java-8-optional-class/
- 