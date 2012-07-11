/*
ID: czpcxfz1
PROG: numtri
LANG: C++
*/
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <cstring>
#include <cmath>
using namespace std;
int r, tri[1010][1010];
int main()
{
  freopen("numtri.in","r",stdin);
  freopen("numtri.out","w",stdout);     
  scanf("%d", &r);
  for (int i = 0; i < r; ++i)
    for (int j = 0; j <= i; ++j)
      scanf("%d", &tri[i][j]);
  for (int i = r - 2; i >= 0; --i)
    for (int j = 0; j <= i; ++j)
      tri[i][j] += max(tri[i+1][j], tri[i+1][j+1]);
  printf("%d\n", tri[0][0]);
  return 0;
}
