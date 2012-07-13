/*
ID: czpcxfz1
PROG: castle
LANG: C++
*/
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <cstring>
#include <cmath>
using namespace std;
const int di[4][2] = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
int vis[60][60], num[3000], m, n, ca[60][60], co, large, best, bestx, besty;
char bestd;
int dfs(int x, int y, int col)
{
  int xx = 1;
  vis[x][y] = col;
  for (int i = 0; i < 4; ++i)
    if ((ca[x][y] & 1 << i) == 0 && vis[x + di[i][0]][y + di[i][1]] == 0)
      xx += dfs(x + di[i][0], y + di[i][1], col);
 return xx;
}
int main()
{
  freopen("castle.in","r",stdin);
  freopen("castle.out","w",stdout);     
  scanf("%d%d", &m, &n);
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j)
      scanf("%d", &ca[i][j]);
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j) 
      if (vis[i][j] == 0) {
	++co;
	num[co] = dfs(i, j, co);
	if (num[co] > large) large = num[co];
      }
  printf("%d\n%d\n", co, large);
  for (int j = 0; j < m; ++j) {
    for (int i = n - 1; i > 0; --i)
      if ((ca[i][j] & 1 << 1) > 0 && vis[i][j]!= vis[i - 1][j]
	  && num[vis[i][j]] + num[vis[i - 1][j]] > best) {
	best = num[vis[i][j]] + num[vis[i - 1][j]];
	bestx = i;
	besty = j;
	bestd = 'N';
      }
    if (j == m - 1) break;
    for (int i = n - 1; i >= 0; --i)
      if ((ca[i][j] & 1 << 2) > 0 && vis[i][j] != vis[i][j + 1]
	  && num[vis[i][j]] + num[vis[i][j + 1]] > best) {
	best = num[vis[i][j]] + num[vis[i][j + 1]];
	bestx = i;
	besty = j;
	bestd = 'E';
      }
  }
  printf("%d\n%d %d %c\n", best, bestx + 1, besty + 1, bestd);
  return 0;
}
