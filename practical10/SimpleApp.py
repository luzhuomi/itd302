 """SimpleApp.py"""
from pyspark import SparkContext
logFile = "hdfs://127.0.0.1:9000/user/itd302/practical3/data"  # Should be some file on your system
sc = SparkContext("local", "Simple App")
logData = sc.textFile(logFile).cache()
numAs = logData.filter(lambda s: ’a’ in s).count()
numBs = logData.filter(lambda s: ’b’ in s).count()
print("Lines with a: %i, lines with b: %i" % (numAs, numBs))
