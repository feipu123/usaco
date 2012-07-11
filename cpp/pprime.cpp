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
int pri[10000], a, b, pn, aa[20], bb[20], th[20], nth, odda, na;
bool fl;
int c[20], n;
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
int get()
{
  int x = 0;
  for (int i = nth - 1; i >= 0; --i)
    x = x * 10 + th[i];
  if (odda) {
    for (int i = 1; i < nth; ++i)
      x = x*10 + th[i];
  }
  else {
    for (int i = 0; i < nth; ++i)
      x = x*10 + th[i];
  }
  return x;
}
void add()
{
  th[0]++;
  for (int i = 0; i < nth; ++i) {
    th[i + 1] += th[i] / 10;
    th[i] %= 10;
  }
  if (th[nth] > 0) {
    if (odda) {
      for (int i = 0; i < nth - 1; ++i)
	th[i] = 0;
      th[nth - 1] = 1;
      th[nth] = 0;
      odda = 0;
    }
    else {
      ++nth;
      odda = 1;
    }
  }
}
int main()
{
  freopen("pprime.in","r",stdin);
  freopen("pprime.out","w",stdout);     
  makeprime();
  scanf("%d%d", &a, &b);
  while (a>0) {
    aa[na] = a % 10;
    a /= 10;
    ++na;
  }
  /*
  while (b>0) {
    bb[nb] = b % 10;
    b /= 10;
    ++nb;
  }
  */
  odda = (na - 1) % 2;
  for (int i = 0; i < (na + 1) / 2; ++i)
    th[i] = aa[na - 1 - i];
  nth = (na + 1) / 2;
  while (get() < a) add();
  a = get();
  while (a <= b) {
    if (check(a)) printf("%d\n", a);
    add();
    a = get();
  }
  return 0;
}
