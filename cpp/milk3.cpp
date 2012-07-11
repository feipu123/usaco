/*
ID: czpcxfz1
PROG: milk3
LANG: C++
*/
#include <cstdio>
#include <cstdlib>
#include <algorithm>
using namespace std;
int que[100000], b[3], a[3], x, y, h, t;
bool ha[100000], mi[100];
void bfs()
{
  que[0] = b[2];
  ha[b[2]] = true;
  mi[b[2]] = true;
  h = 0;
  t = 1;
  while (h < t) {
    x = que[h];
    ++h;
    for (int i = 0; i < 3; ++i)
      for (int j = 0; j < 3; ++j) {
	if (i == j) continue;
        a[0] = x / 10000;
        a[1] = x / 100 % 100;
        a[2] = x % 100;
	if (a[j] == b[j] || a[i] == 0) continue;
	if (a[i] < b[j] - a[j]) {
	  a[j] += a[i];
	  a[i] = 0;
	}
	else {
	  a[i] -= b[j] - a[j];
	  a[j] = b[j];
	}
	y = a[0] * 10000 + a[1] * 100 + a[2];
	if (ha[y]) continue;
	que[t] = y;
	++t;
	ha[y] = true;
	if (a[0] == 0) mi[a[2]] = true;
      }
  }
}
int main()
{
  freopen("milk3.in","r",stdin);
  freopen("milk3.out","w",stdout);     
  scanf("%d%d%d", &b[0], &b[1], &b[2]);
  bfs();
  int xxx;
  for (xxx = b[2]; xxx >= 0; --xxx)
    if (mi[xxx]) break;
  for (int i = 0; i < xxx; ++i) 
    if (mi[i]) 
      printf("%d ", i);
  printf("%d\n", xxx);
  return 0;
}
