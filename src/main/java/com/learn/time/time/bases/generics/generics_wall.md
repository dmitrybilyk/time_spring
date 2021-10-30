Given

class Person {}
class Student extends Person{}
class Faculty extends Person{}

List<Student> is not extending the List<Person>. They are not covariant. It's because Java wants to 
avoid situations when you pass List<Student> to method and Faculty object is added to it.
This is for type safety.

<?> - wildcard, <? extends Person> - bounded wildcard, 

public void printList(List<Person> list) {} should be turned into

public void printList(List<? extends Person> list) {} to make types covariant  OR

public void printList(List<?> list) {}
