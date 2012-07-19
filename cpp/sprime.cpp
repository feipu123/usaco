/*
ID: czpcxfz1
PROG: sprime
LANG: C++
*/
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <cstring>
#include <cmath>
using namespace std;
int pri[10000], n, ans[10][10000], pn;
bool fl;

bool check(int x)
{
  for (int j = 0; j < pn; ++j) {
    if (x % pri[j] == 0) return false;
    if (pri[j] * pri[j] > x) break;
  }
  return true;
}
void makeprime()
{
  pri[0] = 2;
  pri[1] = 3;
  pn = 2;
  for (int i = 5; i < 10000; i += 2) {
    fl = true;
    for (int j = 0; j < pn; ++j) {
      if (i % pri[j] == 0) {fl = false; break;}
      if (pri[j] * pri[j] > i) break;
    }
    if (fl) {
      pri[pn] = i;
      ++pn;
    }
  }
}

int main()
{
  freopen("sprime.in","r",stdin);
  freopen("sprime.out","w",stdout);     
  makeprime();
  scanf("%d", &n);
  ans[1][0] = 4;
  ans[1][1] = 2;
  ans[1][2] = 3;
  ans[1][3] = 5;
  ans[1][4] = 7;
  for (int i = 2; i <= n; ++i) {
    for (int j = 1; j <= ans[i - 1][0]; ++j)
      for (int k = 1; k < 10; k += 2) 
	if (check(ans[i - 1][j] * 10 + k)) {
	  ++ans[i][0];
	  ans[i][ans[i][0]] = ans[i - 1][j] * 10 + k;
	}
  }
  for (int i = 1; i <= ans[n][0]; ++i)
    printf("%d\n", ans[n][i]);
  return 0;
}
