/*
ID: czpcxfz1
PROG: ariprog
LANG: C++
*/
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;
int num[90000], n, m, co, co2, b;
pair<int,int> ans[1000000];
bool ha[90000], fl;
bool comp(pair<int,int> a, pair<int,int> b) 
{
  return a.second < b.second || a.second == b.second && a.first < b.first;
}
int main()
{
  freopen("ariprog.in","r",stdin);
  freopen("ariprog.out","w",stdout);  
  scanf("%d%d", &n, &m);
  for (int i = 0; i <= m; ++i)
    for (int j = i; j <= m; ++j) {
      num[co] = i*i+j*j;
      ha[num[co]] = true;
      ++co;
    }
  sort(num, num + co);
  int k = 1;
  for (int i = 1; i < co; ++i)
    if (num[i] != num[i - 1]) {
      num[k] = num[i];
      ++k;
    }
  co = k;
  for (int i = 0; i < co; ++i)
    for (int j = i + 1; j < co; ++j) {
      fl = true;
      b = num[j] - num[i];
      for (int k = 2; k < n; ++k)
	if (!ha[num[i] + b * k]) {fl = false; break;}
      if (fl) {
	ans[co2].first = num[i];
	ans[co2].second = b;
	++co2;
      }
    }
  if (co2 == 0) {
    printf("NONE\n");
    return 0;
  }
  sort(ans, ans + co2, comp);
  for (int i = 0; i < co2; ++i) {
    printf("%d %d\n", ans[i].first, ans[i].second);
  }
  return 0;
}
