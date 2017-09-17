import java.util.Scanner;
import java.util.Stack

object Solution {

  case class Point(x:Int,y:Int)

  def main(args: Array[String]) {
    val in = new Scanner(System.in)
    val N = in.nextInt

    val list = (for {
      i <- 1 to N
      val x = in.nextInt
      val y = in.nextInt

    } yield Point(x,y)).toList

    val sortedList = list.sortBy(_.x)
    val full = List(halfWay(sortedList)) ::: List(halfWay(sortedList.reverse))
    val flat = full.flatten
    val newfull = flat :: full.head

    val sum = newfull.foldLeft(0.0) {case(sum,list) => { sum + primt(list.head,list.head) } }

    in.close
  }

  def primt(p1:Point,p2:Point) : Double = {
    val d = Math.sqrt(Math.pow(p1.x-p2.x,2) + Math.pow(p1.y-p2.y,2))
    d
  }

  def halfWay(points:List[Point]):List[Object] = {
    val stack = new Stack[Point]
    for(p <- points) {
      while(stack.size >= 2 && orientation(p,stack.get(0),stack.get(1))){
        stack.pop
      }
        stack.push(p)
    }
    stack.pop

    stack.toArray.toList
  }

  def orientation(p0:Point,p1:Point,p2:Point) : Boolean = {
      val ang = (p0.y - p1.y) * (p2.x - p1.x) -
               (p0.x - p1.x) * (p2.y - p1.y);
      val col = math.abs(ang) <= 1
      val leftTurn = ang < 0

      col || leftTurn
  }
}
