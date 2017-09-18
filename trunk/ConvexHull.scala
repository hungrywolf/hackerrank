import java.util.Scanner;
import java.util.Stack

object Solution {

  case class Point(x:Double,y:Double)

  def main(args: Array[String]) {
    val in = new Scanner(System.in)
    val N = in.nextInt

    val list = (for {
      i <- 1 to N
      val x = in.nextDouble
      val y = in.nextDouble

    } yield Point(x,y)).toList

    val sortedList = list.sortBy(_.x)
    val full = List(halfWay(sortedList.reverse)) ::: List(halfWay(sortedList))
    val flat = full.flatten.asInstanceOf[List[Point]]
    println(flat)
    val newfull = flat ::: List(flat.head)

    println(sum(newfull))

    in.close
  }

  def sum(l:List[Point]) : Double = {
    def calculat(list:List[Point]) : Double  = list match {
      case Nil => 0.0
      case p1 :: p2 :: rest => primt(p1,p2) + calculat(List(p2) ::: rest)
      case p1 :: Nil => primt(p1,list.head)
    }
    calculat(l)
  }

  def primt(p1:Point,p2:Point) : Double = {
    val d = Math.sqrt(Math.pow(p1.x-p2.x,2) + Math.pow(p1.y-p2.y,2))
    d
  }

  def halfWay(points:List[Point]):List[Object] = {
    val stack = new Stack[Point]
    for(p <- points) {
      while(stack.size >= 2 && orientation(p,stack.peek,stack.get(stack.size-2))){
        stack.pop
      }
        stack.push(p)
    }
    stack.pop

    stack.toArray.toList
  }

  def cross(p0:Point,p1:Point,p2:Point) : Double =
     (p0.y - p1.y) * (p2.x - p1.x) - (p0.x - p1.x) * (p2.y - p1.y);

  def orientation(p0:Point,p1:Point,p2:Point) : Boolean = {

      val a = (p0.y - p1.y) * (p2.x - p1.x) <= 0
      val b = (p0.x - p1.x) * (p2.y - p1.y) <= 0

      cross(p0,p1,p2) < 0.0 || cross(p0,p1,p2)==0 && a && b
  }
}
