
P = load 'points' using PigStorage('\t') as (x:double,y:double);
C = load 'centroids' using PigStorage('\t') as (cx:double,cy:double);
PC1 = CROSS P, C
PC2 = foreach PC generate P.x, P,y, 