/*
ID: czpcxfz1
PROG: holstein
LANG: C++
*/
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <utility>
using namespace std;
int n, m, vit[30], feed[20][30], nown, bestn;
bool now[20], ans[20];
bool check()
{
  for (int i = 0; i < m; ++i)
    if (vit[i] > 0) return false;
  return true;
}
void dfs(int x)
{
  if (check()) {
    if (nown < bestn) {
      for (int i = 0; i < n; ++i)
	ans[i] = now[i];
      bestn = nown;
    }
    return;
  }
  if (x == n) return;
  for (int i = 0; i < m; ++i)
    vit[i] -= feed[x][i];
  ++nown;
  now[x] = true;
  dfs(x + 1);
  for (int i = 0; i < m; ++i)
    vit[i] += feed[x][i];
  --nown;
  now[x] = false;
  dfs(x + 1);
}
int main()
{
  freopen("holstein.in","r",stdin);
  freopen("holstein.out","w",stdout);     
  bestn = 100000;
  scanf("%d", &m);
  for (int i = 0; i < m; ++i)
    scanf("%d", &vit[i]);
  scanf("%d", &n);
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < m; ++j)
      scanf("%d", &feed[i][j]);
  dfs(0);
  printf("%d", bestn);
  for (int i = 0; i < n; ++i)
    if (ans[i])
      printf(" %d", i + 1);
  printf("\n");
  return 0;
}
