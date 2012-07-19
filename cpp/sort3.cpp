/*
ID: czpcxfz1
PROG: sort3
LANG: C++
*/
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <utility>
using namespace std;
int n, a[1010], b[1010], c[4][4], x, ans;
int main()
{
  freopen("sort3.in","r",stdin);
  freopen("sort3.out","w",stdout);     
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    scanf("%d", &a[i]);
    b[i] = a[i];
  }
  sort(b, b + n);
  for (int i = 0; i < n; ++i)
    ++c[a[i]][b[i]];
  for (int i = 1; i <= 3; ++i)
    for (int j = i + 1; j <= 3; ++j) {
      x = min(c[i][j], c[j][i]);
      c[i][j] -= x;
      c[j][i] -= x;
      ans += x;
    }
  if (c[1][2] > 0) ans += c[1][2] << 1;
  else ans += c[2][1] << 1;
  printf("%d\n", ans);
  return 0;
}
