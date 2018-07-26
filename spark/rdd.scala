
sc.textFile(path).flatMap(_.split("\\ s+")).map( w => (w,1)).reduceByKey((a,b) => a+b);