/*
ID: czpcxfz1
PROG: checker
LANG: C++
*/
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <cstring>
#include <cmath>
using namespace std;
int ans, col, lu, ll, che[20], n;
bool dfs1(int now) 
{
  if (now == n) {
    ++ans;
    for (int i = 0; i < n - 1; ++i)
      printf("%d ", che[i] + 1);
    printf("%d\n", che[n - 1] + 1);
    if (ans == 3) 
      return true; 
    else return false;
  }
  for (int i = 0; i < n; ++i)
    if ((col & 1 << i) == 0 &&
	(lu & 1 << (i - now + 13)) == 0 &&
	(ll & 1 << (i + now)) == 0) {
      che[now] = i;
      col |= 1 << i;
      lu |= 1 << (i - now + 13);
      ll |= 1 << (i + now);
      if (dfs1(now + 1)) return true;
      col -= 1 << i;
      lu -= 1 << (i - now + 13);
      ll -= 1 << (i + now);
    }
  return false;
}
void dfs2(int now) 
{
  if (now == n) {
    ++ans;
    return;
  }
  for (int i = 0; i < n; ++i)
    if ((col & 1 << i) == 0 &&
	(lu & 1 << (i - now + 13)) == 0 &&
	(ll & 1 << (i + now)) == 0) {
      che[now] = i;
      col |= 1 << i;
      lu |= 1 << (i - now + 13);
      ll |= 1 << (i + now);
      dfs2(now + 1);
      col -= 1 << i;
      lu -= 1 << (i - now + 13);
      ll -= 1 << (i + now);
    }
}
int main()
{
  freopen("checker.in","r",stdin);
  freopen("checker.out","w",stdout);     
  scanf("%d", &n);
  dfs1(0);
  ans = col = lu = ll = 0;
  dfs2(0);
  printf("%d\n", ans);
  return 0;
}
