object Solution {

    def main(args: Array[String]) {
      val x = readLine
      val y = readLine

      val i = prefIndex(x,y,0)
      val pref = x.substring(0,i)
      val x1 = x.substring(pref.size,x.length)
      val y1 = y.substring(pref.size,y.length)
      println(s"${pref.size} ${pref}")
      println(s"${x1.size} ${x1}")
      println(s"${y1.size} ${y1}")

    }

    def prefIndex (x:String , y:String , i:Int) : Int = {
      if(i < 0) return 0
      if(i == x.size) return i
      if(i == y.size) return i
      if(x.charAt(i) == y.charAt(i)) return prefIndex(x,y,i+1)
      return i
    }
}
