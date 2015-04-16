/* Simplified Steiner tree backtrack code Warren D. Smith Jan 1989
 * Program contains about 341 C instructions. See main() for I/O details; for an
 * input & output example, see table 1 of the text. */

#include <math.h>
#include <stdio.h>
#define REAL double
#define SQROOT(a) sqrt(a)
#define RANDM(a) frand(a) /* uniform random deviates in (0, 1) */
#define INITRAND() srand(57731)
#define DoForever while(1)

#define MAXDIM 12 /* max space dimension permitted */
#define NMAX 100 /* max number of sites permitted */
/* Global variable */
REAL STUB, SCALE, N;
int NUMSITES, DIMENSION;
static int BESTVEC[NMAX], STACK[NMAX*NMAX], adj[NMAX-2][3], edge[2*NMAX][2];
static REAL XX[NMAX*2][MAXDIM], LEN[NMAX], EL[NMAX][3];

/* SMT representation: Steiner point i is adjacent to points adj[i][0..2].
 * (If neighbor is Steiner - NUMSITES added!)
 * There are N - 2 Steiner points and N regular sites.
 * the coordinates of Steiner point i are XX[i+NUMSITES][0..DIMENSION-1], and
 * the coordinates of regular site i are XX[i][0..DIMENSION-1], i = 1, 2..
 * Edge i has endpoints edge[i][0] < edge[i][1] (same NUMSITE-add convention).
 ****/

/* added void as C99 defaults to returning int instead of void */
void buildtree(k, topvec)
int k, topvec[];
{/* builds tree represented by topvec[1..k]. Initial location of new Steiner pts
  * is a slight pertubation of the centroid of its neighbors */
  register int i, e, m, j, sn, ea, eb, en;
  /* First: build the tree corresponding to the null vector */
  N = 3; m = NUMSITES + 1;
  adj[1][0] = 1; adj[1][1] = 2; adj[1][2] = 3;
  edge[1][0] = 1; edge[2][0] = 2; edge[3][0] = 3;
  edge[1][1] = m; edge[2][1] = m; edge[3][1] = m;
  for(i=0; i<DIMENSION; i++)
    XX[m][i] = (XX[1][i] + XX[2][i] + XX[3][i])/3.0 + 0.001*SCALE*RANDM();

  for(i=1; i<=k; i++){/* Now: do vector element topvec[i] */
    en = i + 3; m = i + 1; sn = m + NUMSITES;
    e = topvec[i]; ea = edge[e][0]; eb = edge[e][1];
    adj[m][0] = ea; adj[m][1] = eb; adj[m][2] = en;
    m = ea - NUMSITES;
    if(m > 0) for(j=0; j<3; j++) if(adj[m][j] == eb){ adj[m][j] = sn; break; }
    m = eb - NUMSITES;
    if(m > 0) for(j=0; j<3; j++) if(adj[m][j] == ea){ adj[m][j] = sn; break; }
    edge[e][1] = sn; e = en + en - 4; edge[e][0] = en; edge[e][1] = sn;
    e++; edge[e][0] = eb; edge[e][1] = sn;
    for(j=0; j<DIMENSION; j++)
      XX[sn][j] = (XX[ea][j] + XX[eb][j] + XX[en][j])/3.0 + 0.001*SCALE*RANDM();
  }
  N = k + 3; /* Tree is now build. Initial coords in general position. */
  return;
}

REAL length()
{/* Stores edge lengths of tree T in array EL[1..k1][0..2] and returns total length */
#define dist(a,b) t = 0.0; for(m=0; m<DIMENSION; m++){ r=XX[a][m] - XX[b][m]; t += r*r; } t = SQROOT(t);
  register int m, i2, i, j; int n0, n1, n2, k1; REAL leng, t, r;
  leng = 0.0; k1 = N - 2;
  for(i=1; i<=k1; i++){
    i2 = i + NUMSITES;
    n0 = adj[i][0]; n1 = adj[i][1]; n2 = adj[i][2];
    if (n0<i2){
      dist(n0,i2); leng += t; EL[i][0] = t; n0 -= NUMSITES;
      if(n0>0) for(j=0;j<3;j++) if(adj[n0][j] == i2){ EL[n0][j] = t; break; }
    }
    if (n1<i2){
      dist(n1,i2); leng += t; EL[i][1] = t; n1 -= NUMSITES;
      if(n1>0) for(j=0;j<3;j++) if(adj[n1][j] == i2){ EL[n1][j] = t; break; }
    }
    if (n2<i2){
      dist(n2,i2); leng += t; EL[i][2] = t; n2 -= NUMSITES;
      if(n2>0) for(j=0;j<3;j++) if(adj[n2][j] == i2){ EL[n2][j] = t; break; }
    }
  } /* Have now figured out distance EL[i][0..2] from Steiner pt. i to neighbors */
  return(leng);
}

optimize(tol)
REAL tol; /* a small positive number */
{/* finds better coordinates XX[NUMSITES+1..NUMSITES+k1][] for the k1 Steiner points
  * of tree T by: doing a relaxation iteration. Assumes edge lengths of old tree
  * have been pre-stored in array EL[][] */
#define prep(a,b,c) if(b>NUMSITES){ val[i]++; B[i][a] = c; }
  
}
