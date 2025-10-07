object Basics extends App:
  // defining values
  val meaningOfLife: Int = 42 // const int meaningOfLife = 42 (java)

  // meaningOfLife = 43 is illegal cus we cant reassign
  println(meaningOfLife)

  //Int Bool Char Double Float String
  val aBoolean = false // type is optional (mostly)

  //strings and stirng operations
  val aString = "I Love Scala"
  val aComposedString = "I" + " " + "Love" + " " + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  //expressions = structures that reduce to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if(meaningOfLife > 43) 56 else 999 // in other languages: meaningOfLife > 43 ? 56 : 999

  val chainedIfExpression =
    if(meaningOfLife > 43) 56
    else if(meaningOfLife < 0 ) -2
    else if(meaningOfLife > 999) 78
    else 0

  // code blocks
  val aCodeBlock =
    //definitions
    val aLocalValue = 67

    aLocalValue + 3 // last expression of code block -> value of the entire block

  //defining functions
  def myFunction(x: Int, y: String):String =
    y + " " + x

  //recursive function
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n-1)

  //no loops or iteration, recursion

  //Unit return type = no meaningful value === void in other languages
  //type of SIDE EFFECTS - operations that have nothing to do with computation of meaningful info
  println("I love scala")

  def myUnitFunction(): Unit =
    println("I dont like returning Unit")

  val theUnit = ()
