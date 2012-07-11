/*
ID: czpcxfz1
PROG: pprime
LANG: C++
*/
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <cstring>
#include <cmath>
using namespace std;
int pri[10000], a, b, pn;
bool fl;
bool check(int x)
{
  int a[20], n = 0;
  while (x > 0) {
    a[n] = x % 10;
    x /= 10;
    ++n;
  }
  for (int i = 0; i < n / 2; ++i)
    if (a[i] != a[n - 1 - i]) return false;
  return true;
}
void makeprime()
{
  pri[0] = 2;
  pri[1] = 3;
  pn = 2;
  for (int i = 5; i < 20000; ++i) {
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
  freopen("pprime.in","r",stdin);
  freopen("pprime.out","w",stdout);     
  makeprime();
  scanf("%d%d", &a, &b);
  for (int i = a; i <= b; ++i) {
    fl = true;
    for (int j = 0; j < pn; ++j) {
      if (i % pri[j] == 0) {fl = false; break;}
      if (pri[j] * pri[j] > i) break;
    }
    if (fl and check(i))
      printf("%d\n", i);
  }
  return 0;
}
