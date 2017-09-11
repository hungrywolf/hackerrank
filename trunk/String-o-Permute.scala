object Solution {
  def main (args:Array[String]){
    val in = new Sccaner(System.in)
    val T = in.nextLine.toInt
    val L = in.nextLine

    for(i <- 0 to T) {
      val list = L.toList
      println(sweep(list,0,1).mkString(""))
    }


  }

  def swap (l : List[Char],from:Int,to:Int) : List[Char] = {
    if(to < 0) {
      List()
    } else {

    }
  }
}
