object ObjectOrientation extends App:
  //java public static void main(String[] args)

  //class and instance
  class Animal:
    //fields
    val age: Int = 0
    //methods
    def eat() = println("I am eating")

  val anAnimal = new Animal

  //inheritance
  class Dog(val name:String) extends Animal //constructor definition
  val aDog = new Dog("Lassie")

  //constructor args are NOT fields: need to make the constructor arg a val like above
  println(aDog.name)

  //subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  //abstract class
  abstract class WalkingAnimal:
    val hasLegs = true // by default public, can be private or protected
    def walk():Unit //dont need to provide implementation but any inheriting class will need to override it

  //"Interface" = ultimate abstract type
  trait Carnivore:
    def eat(animal: Animal): Unit

  trait Philosoppher:
    def ?!(thought: String): Unit //valid method name

  //single class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosoppher:
    override def eat(animal: Animal): Unit = println("I am eating")
    def ?!(thought: String): Unit = println(s"I was thinking: $thought")

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog //infix notation = object method argument, only for 1 argument methods
  aCroc ?! "What if we could fly"

  //operators in scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMaths = 1.+(2) //equivalent

  //anonymous classes
  //abstract classes or traits can not be instanciated by themselves (need to be inherited from something else)
  //this notation can do that on the spot
  val dinosaur = new Carnivore:
    override def eat(animal: Animal): Unit = println("Im a dinosaur I eat whatever")

  /*
    what you are telling the compiler
    class Carnivore_anonymous_3456 extends Carnivore:
      override def eat(animal: Animal): Unit = println("Im a dinosaur I eat whatever")

    val dinosaur = new Carnivore_anonymous_3456
   */

  //singleton object
  object MySingleton: // only instance of the MySingleto type
    val myValue = 2345
    def myMethod(): Int = 234
    def apply(x: Int):Int = x + 1

  MySingleton.myMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to apply from above

  object Animal:
    //companion object to the Animal class
    //property that they can access each others private fields and methods
    //singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

  //case classes = lightweight data structures
  //sensible equals and hash code
  //serialization
  //companion with apply
  //pattern matching
  case class Person(name: String, age: Int)

  //can be constructed without new keyword
  val bob = Person("Bob", 54) // Person.apply("Bob",54)

  //exceptions
  try
    //code that can throw
    val x: String = null
    x.length
  catch
    case e: Exception => "Something bad"
  finally
    //execute no matter what
    println("This is always printed")

  //generics
  abstract class MyList[T]:
    def head: T
    def tail: MyList[T]

  //using a generic with a concrete type
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head // int
  val rest = aList.tail
  val aStringList = List("Hello","Scala")
  val firstString = aStringList.head // string

  // Point 1: int scala we operate with IMMUTABLE values/objects
  // any modification to an object should return a new object
  /*
    Benefit 1 = good in multithreaded environments
    2 = helps to make sense of the code (reasoning about the code)
   */
  val reversedList = aList.reverse // returns a new list

  //Point 2: scala is closest to OO ideal

