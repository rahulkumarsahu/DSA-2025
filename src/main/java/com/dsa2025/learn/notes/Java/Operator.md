What is the difference between == operator and .equals( ) method ?

_In general we can use .equals( ) for content comparision where as == operator_
_for reference comparision_
String s1=new String("ashok");
String s2=new String("ashok");
System.out.println(s1==s2); //false
System.out.println(s1.equals(s2)); //true

--------


**Instance of**

We can use the instanceof operator to check whether the given an object is
particular type or not

To use instance of operator compulsory there should be some relation between
argument types (either child to parent Or parent to child Or same type)
Otherwise we will get compile time error saying inconvertible types

Whenever we are checking the parent object is child type or not by using
instanceof operator that we get false.

For any class or interface X null instanceof X is always returns false.

---------

Type casting

_There are 2 types of type-casting_
_1. implicit_
_2. explicit_

implicit type casting  (Widening or upcasting):
int x='a';
_System.out.println(x); //97_

_1. The compiler is responsible to perform this type casting._
_2. When ever we are assigning lower datatype value to higher datatype variable_
_then implicit type cast will be performed ._
_3. It is also known as Widening or Upcasting._
_4. There is no lose of information in this type casting._
_5. The following are various possible implicit type casting._

Note: Compiler converts char to int type automatically by implicit type casting.
![[Pasted image 20250506195555.png]]

Explicit Type Casting (Narrowing or Downcasting)

_1. Programmer is responsible for this type casting._
_2. Whenever we are assigning bigger data type value to the smaller data type_
_variable then explicit type casting is required._
_3. Also known as Narrowing or down casting._
_4. There may be a chance of lose of information in this type casting._
_5. The following are various possible conversions where explicit type casting is_
_required._

----------
_new Vs newInstance( ) :_

_1. new is an operator to create an objects , if we know class name at the beginning_
then we can create an object by using new operator .

_2. newInstance( ) is a method presenting class " Class " , which can be used to_
create object. if we don't know the class name at the beginning and its available dynamically. To use newInstance( ) method compulsory corresponding class should contains no argument constructor , otherwise we will get the RuntimeException saying InstantiationException.

If dynamically provide class name is not available then we will get the
_RuntimeException saying ClassNotFoundException_

--------
_Difference between ClassNotFoundException &_

_NoClassDefFoundError :_
_1. For hard coded class names at Runtime in the corresponding .class files not_
_available we will get NoClassDefFoundError , which is unchecked_

_Test t = new Test( );_
_In Runtime Test.class file is not available then we will get_
_NoClassDefFoundError_

_2. For Dynamically provided class names at Runtime , If the corresponding .class_
_files is not available then we will get the RuntimeException saying_
_ClassNotFoundException_

_Ex : Object o=Class.forname("Test").newInstance( );_
_At Runtime if Test.class file not available then we will get the_
_ClassNotFoundException , which is checked exception_

----------
_isInstance( )_
_isInstance( ) is a method , present in class Class , we_ can use isInstance( ) method to checked whether the_ given object is perticular type or not We don't know at the type at beginning it is available Dynamically at Runtime.

-----

