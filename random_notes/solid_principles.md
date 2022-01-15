# SOLID

## Single Responsability Principle

`Motto`: "A class should have one, and only one, reason to change."

`Objective`: Avoid unnecessary coupling and reduces the complexity of future class changes.

`Questions yourself`: "What is the responsability of this class/component/service ?"
If the answer contains a "and", probably this concept was broken. So step back and retrink the implementation.


## Open/Closed Principle

`Motto`: “Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.”

`Objetive`: Write code that is easily to add new functionality without changing the original code. Prevent a change in one of your classes requires adaptation of all depending classes.

`Question yourself`: "Can i use this class as a parent, adding new features, without change the original class ?"


## Liskov Substitution Principle

`Motto`: “Objects in a program should be replaceable with instances of their base types without altering the correctness of that program.”

`Objective`: Maintain cohesive interfaces between parent and subclasses to have more reliable expected behavior of your code.

`Question yourself`: This subclass respects the interfaces and return inherited from the parent class ?


## Interface Segregation Principle

`Motto`: “A client should never be forced to implement an interface that it doesn’t use, or clients shouldn’t be forced to depend on methods they do not use.”

`Objective`: Maintain small interfaces for each propuse, do not bloat the objects with unused code.

`Question yourself`: Should this class implement all methods from their interface ?


## Dependency Inversion Principle

`Motto`: "Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions."

`Objective`: Avoid unnecessary coupling and reduces the need of changes.

`Question yourself`: Should this module be strictly coupled to its dependancy type ? What if the type dependancy type changes ?