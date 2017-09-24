import java.io._

val file = "/tmp/rejecteddata.csv"
val writer = new PrintWriter(new File(file))
for(i <- 0 to 1000) {
  writer.write( List("AARCNT1002858","/home/bigdata/applications/group/intec_int/kprod/incoming/"+i%50,"144865","20170909 00:11:40","2017-09-09",""+i%7,""+i%5,"reson","20170829","20170829043941").map(e=>e).mkString(","))
  writer.write("\n")
}

writer.close()



val file = "/tmp/airfill.csv"
val writer = new PrintWriter(new File(file))
for (i <- 0 to 1000) {
  writer.write(List("/home/bigdata/applications/group/intec_int/kprod/incoming/"+i%50,"2017-09-09","0",""+i%5,"20170829","20170829043941").map(e=>e).mkString(","))
  writer.write("\n")
}
writer.close()



val file = "/tmp/filestats.csv"
val writer = new PrintWriter(new File(file))
for (i <- 0 to 1000) {
  writer.write(List("/home/bigdata/applications/group/intec_int/kprod/incoming/"+i%50,""+i,	"2017-09-09",""+i%23,"20170829","20170829043941").map(e=>e).mkString(","))
  writer.write("\n")
}
writer.close()


val file = "/tmp/dedup.csv"
val writer = new PrintWriter(new File(file))
for (i <- 0 to 1000) {
  writer.write(List("/home/bigdata/applications/group/intec_int/kprod/incoming/"+i%50,""+i,	"2017-09-09",""+i%7,""+i%5,"20170829","20170829043941").map(e=>e).mkString(","))
  writer.write("\n")
}
writer.close()
