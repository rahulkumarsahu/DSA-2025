

1. A java Program can contain any no. Of classes but at most one class can be
declared as public. "If there is a public class the name of the Program and name
of the public class must be matched otherwise we will get compile time error".
2. If there is no public class then any name we gives for java source file.
--------

What is the difference between general import and static import ?
1. We can use normal imports to import classes and interfaces of a package.
whenever we are using normal import we can access class and interfaces directly
by their short name it is not require to use fully qualified names.
2. We can use static import to import static members of a particular class.
whenever we are using static import it is not require to use class name we can
access static members directly.

-------------
_Class Modifiers_
----

Public

_If a class declared as public then we can access that class from anywhere. With in the package or outside the package._

If class Test is not public then while compiling Test1 class we will get compile time error saying pack1.Test is not public in pack1; cannot be accessed from outside package

---
Default

_If a class declared as the default then we can access that class only within the current package hence default access is also known as "package level access"._

-----
Final

_Final is the modifier applicable for classes, methods and variables._


Final Methods:
1. Whatever the methods parent has by default available to the child.
2. If the child is not allowed to override any method, that method we have to
declare with final in parent class. That is final methods cannot overridden.

When a method is marked `final`, it means:
This method’s behavior is **fixed** and **cannot be changed** by any subclass.

_Final Class:_

_If a class declared as the final then we cann't creates the child class that is inheritance concept is not applicable for final classes._

The main advantage of final keyword is we can achieve security.
Whereas the main disadvantage is we are missing the key benefits of oops:
polymorphism (because of final methods), inheritance (because of final classes) hence

- When a class is marked `final`, it means:
    
    > “This class **cannot be extended**.”
    
- This is done to prevent inheritance when:
    
    - The class is **complete** and should not be modified.
        
    - The class is **immutable** or used for **security reasons** (e.g., `java.lang.String`).

----
_Abstract Modifier:_

_Abstract is the modifier applicable only for methods and classes but not for variables._

_Abstract Methods:_
_Even though we don't have implementation still we can declare a method with abstract modifier._
_That is abstract methods have only declaration but not implementation._
_Hence abstract method declaration should compulsory ends with semicolon._

_Child classes are responsible to provide implementation for parent class abstract_
_methods._
abstract illegal combination are final, strictfp, private, native, strictfp, synchronised.

_Abstract class:_

_For any java class if we are not allow to create an object such type of class we have to_  declare with abstract modifier that is for abstract class instantiation is not possible.

Notes
1. If a class contain at least on abstract method then compulsory the corresponding class should be declare with abstract modifier. Because implementation is not complete and hence we can't create object of that class.
2. Even though class doesn't contain any abstract methods still we can declare the
class as abstract that is an abstract class can contain zero no of abstract methods
also.

What is the difference between final and abstract ?
1. For abstract methods compulsory we should override in the child class to
provide implementation. Whereas for final methods we can't override hence
abstract final combination is illegal for methods.
2. For abstract classes we should compulsory create child class to provide
implementation whereas for final class we can't create child class. Hence final
abstract combination is illegal for classes.
3. Final class cannot contain abstract methods whereas abstract class can contain
final method.

------
_Public members:_

_If a member declared as the public then we can access that member from anywhere_
_"but the corresponding class must be visible" hence before checking member visibility we have to check class visibility._

_Default member:_

_If a member declared as the default then we can access that member only within the_
_current package hence default member is also known as package level access._

Private members:
1. If a member declared as the private then we can access that member only with in
the current class.
2. Private methods are not visible in child classes where as abstract methods should be visible in child classes to provide implementation hence private, abstract combination is illegal for methods.
Protected members:
1. If a member declared as the protected then we can access that member within
the current package anywhere but outside package only in child classes.
Protected=default+kids.
2. We can access protected members within the current package anywhere either
by child reference or by parent reference
3. But from outside package we can access protected members only in child classes and should be by child reference only that is we can't use parent reference to call protected members from outside package.