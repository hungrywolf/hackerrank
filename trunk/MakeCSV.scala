import java.io._

val file = "/tmp/rejecteddata.csv"
val writer = new PrintWriter(new File(file))
for(i <- 0 to 1000) {
  writer.write( List("AARCNT1002858","/home/bigdata/applications/group/intec_int/kprod/incoming/"+i%50,"144865","20170909 00:11:40","20170909",""+i%7,""+i%5,"reson "+i%5,"20170829043941-0400").map(e=>e).mkString(","))
  writer.write("\n")
}

writer.close()



val file = "/tmp/airfill.csv"
val writer = new PrintWriter(new File(file))
for (i <- 0 to 1000) {
  writer.write(List("/home/bigdata/applications/group/intec_int/kprod/incoming/"+i%50,"2017-09-09",""+i%7,""+i%5,	"20170829043941-0400").map(e=>e).mkString(","))
  writer.write("\n")
}
writer.close()



val file = "/tmp/filestats.csv"
val writer = new PrintWriter(new File(file))
for (i <- 0 to 1000) {
  writer.write(List("/home/bigdata/applications/group/intec_int/kprod/incoming/"+i%50,""+i,	"2017-09-09",""+i%23,"20170829043941").map(e=>e).mkString(","))
  writer.write("\n")
}
writer.close()
