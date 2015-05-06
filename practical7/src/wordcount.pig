A = load './TheCompleteSherlockHolmes.txt' as line:chararray;
B = foreach A generate flatten(tokenize(line)) as word;
C = group B by word;
D = foreach C generate $0, count($1);
store D into './wordcount';