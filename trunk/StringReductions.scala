object Solution {

    def reduce(str:String) : String = {

      val tub = str.groupBy(_==str.head)
      print(tub.get(true) match {
        case Some(x) => x(0)
        case None => ""
      })

      tub.get(false) match {
        case Some(x) => reduce(x)
        case None => ""
      }

    }

    def main(args: Array[String]) {
        reduce(readLine)
    }
}
