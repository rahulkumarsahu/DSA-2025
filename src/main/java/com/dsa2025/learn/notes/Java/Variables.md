Based on the type of value represented by a variable all variables are
divided into 2 types. They are:
1. Primitive variables
2. Reference variables

Primitive variables:
Primitive variables can be used to represent primitive values.
Example: int x=10;

Reference variables:
Reference variables can be used to refer objects.
Example: Student s=new Student();

Based on the behaviour and position of declaration all variables are divided
into the following 3 types.
1. Instance variables
2. Static variables
3. Local variables

Instance variables:
1. If the value of a variable is varied from object to object such type of variables are
   called instance variables. (Student object in class)
2. For every object a separate copy of instance variables will be created.
3. Instance variables will be created at the time of object creation and destroyed at
   the time of object destruction hence the scope of instance variables is exactly
   same as scope of objects.
4. Instance variables will be stored on the heap as the part of object.
5. Instance variables should be declared with in the class directly but outside of any method or block or constructor.
6. Instance variables can be accessed directly from Instance area. But cannot be
   accessed directly from static area.
7. But by using object reference we can access instance variables from static area.

NOTE :- 
From an **instance method**, you're already inside an object, so you can directly access both instance and static members. but in static you cannot make sure object exists so because of that we need to create an object first to access instance variables inside the static methods.

--------

Static variables:
1. If the value of a variable is not varied from object to object such type of variables
is not recommended to declare as instance variables. We have to declare such
type of variables at class level by using static modifier.
2. In the case of instance variables for every object a separate copy will be created
but in the case of static variables for entire class only one copy will be created
and shared by every object of that class.
3. Static variables will be crated at the time of class loading and destroyed at the
time of class unloading hence the scope of the static variable is exactly same as
the scope of the .class file.
4. Static variables will be stored in method area. Static variables should be declared
with in the class directly but outside of any method or block or constructor.
5. Static variables can be accessed from both instance and static areas directly.
6. We can access static variables either by class name or by object reference but
usage of class name is recommended.
7. But within the same class it is not required to use class name we can access
directly

--------

_Local variables:_

_Some times to meet temporary requirements of the programmer we can declare_
variables inside a method or block or constructors such type of variables are called local variables or automatic variables or temporary variables or stack variables. Local variables will be stored inside stack. The local variables will be created as part of the block execution in which it is declared and destroyed once that block execution completes. Hence the scope of the local variables is exactly same as scope of the block in which we declared.