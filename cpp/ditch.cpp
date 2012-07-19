/*
ID: czpcxfz1
PROG: ditch
LANG: C++
*/
#include <cstdio>
#include <cstdlib>
#include <algorithm>
using namespace std;
int n, m, a, b, c, g[210][210], pre[210], pres[210], ans, delta, num[210], lab[210], x, y, his[210], miny;
int main()
{
  freopen("ditch.in","r",stdin);
  freopen("ditch.out","w",stdout);     
  scanf("%d%d", &m, &n);
  for (int i = 0; i < m; ++i) {
    scanf("%d%d%d", &a, &b, &c);
    g[a][b] += c;
  }
  for (int i = 1; i < n; ++i)
    pres[i] = 1;
  num[0] = n;
  delta = 2000000000;
  x = 1;
  while (lab[1] != n) {
    his[x] = delta;
    for (y = pres[x]; y <= n; ++y)
      if (g[x][y] > 0 && lab[x] == lab[y] + 1)
	break;
    if (y <= n) {
      delta = delta > g[x][y] ? g[x][y] : delta;
      pres[x] = y;
      pre[y] = x;
      x = y;
      if (x == n) {
	ans += delta;
	while (x != 1) {
	  g[pre[x]][x] -= delta;
	  g[x][pre[x]] += delta;
	  x = pre[x];
	}
	delta = 2000000000;
      }
    }
    else {
      y = 0;
      miny = n - 1;
      for (int i = 2; i <= n; ++i)
	if (g[x][i] > 0 && lab[i] < miny) {
	  y = i;
	  miny = lab[i];
	}
      --num[lab[x]];
      if (num[lab[x]] == 0) break;
      lab[x] = miny + 1;
      ++num[miny + 1];
      pres[x] = y;
      if (x != 1) {
	x = pre[x];
	delta = his[x];
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
