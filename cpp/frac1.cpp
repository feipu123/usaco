/*
ID: czpcxfz1
PROG: frac1
LANG: C++
*/
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <utility>
using namespace std;
int n, m;
pair<int, int> ans[10000];
int gcd(int x, int y)
{
  if (y == 0) return x;
  return gcd(y, x % y);
}
bool comp(pair<int, int> a, pair<int, int> b)
{
  return a.first * b.second < b.first * a.second;
}
int main()
{
  freopen("frac1.in","r",stdin);
  freopen("frac1.out","w",stdout);     
  scanf("%d", &n);
  m = 2;
  ans[0].first = 0;
  ans[0].second = 1;
  ans[1].first = 1;
  ans[1].second = 1;
  for (int i = 2; i <= n; ++i) 
    for (int j = 1; j <= i; ++j)
      if (gcd(i, j) == 1) {
	ans[m].first = j;
	ans[m].second = i;
	++m;
      }
  sort(ans, ans + m, comp);
  for (int i = 0; i < m; ++i)
    printf("%d/%d\n", ans[i].first, ans[i].second);
  return 0;
}
