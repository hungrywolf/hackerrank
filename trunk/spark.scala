
import org.apache.spark.sql._

val sqlContext = SQLContext.getOrCreate(sc)

//anime_id, name, genre, type, episodes, rating, members
val anime = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("/Users/saleh/Desktop/challenge/src/test/resources/data/anime.csv")

//user_id, anime_id, rating
val rating = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("/Users/saleh/Desktop/challenge/src/test/resources/data/rating.csv.gz")


//val filterRating = rating.filter(x => x.toString.split(",")(2).toInt > 10 )

anime.registerTempTable("anime")
rating.registerTempTable("rating")

val explodAnime = anime.withColumn("genre",explode(split($"genre","[,]")))
explodAnime.registerTempTable("explodanime")

val finalResult2 = sqlContext.sql("select a.genre ,count(r.rating) as sum from rating as r , explodanime as a where r.anime_id = a.anime_id and a.episodes > 10 and a.rating > 0 group by a.genre order by sum desc limit 10")

val filterAnime = sqlContext.sql("select * from anime where episodes > 10 and rating > 0")
filterAnime.registerTempTable("filteranime")

//val groupGenre = sqlContext.sql("select genre from filteranime group by genre")
//groupGenre.registerTempTable("groupgenre")


val groupRating = sqlContext.sql("select r.anime_id as anime_id,count(r.rating) as count from rating as r group by r.anime_id")
groupRating.registerTempTable("grouprating")


val finalResult = sqlContext.sql("select a.genre ,sum(r.count) as sum from grouprating as r , filteranime as a where r.anime_id = a.anime_id group by a.genre order by sum desc limit 10")

finalResult.collect.foreach(println(_))

//yousef change
val finalResult2 = sqlContext.sql("select a.genre ,count(r.rating) as sum from rating as r , anime as a where r.anime_id = a.anime_id and a.episodes > 10 and a.rating > 0 group by a.genre order by sum desc limit 10")

finalResult2.collect.foreach(println(_))
