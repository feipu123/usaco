/*
ID: czpcxfz1
PROG: clocks
LANG: C++
*/
#include <cstdio>
#include <cstdlib>
const int di[10] = {0, 83200, 86016, 20800, 66576, 17732, 4161, 1300, 21, 325};
bool vis[300000];
int que[1000000], h, t, st, a, pre[1000000], sw[1000000];
void print(int x)
{
  if (x != 0) print(pre[x]);
  else return;
  printf("%d ", sw[x]);
}
int add(int x, int y)
{
  int a[10];
  for (int i = 0; i < 9; ++i) {
    a[i] = (x%4+y%4)%4;
    x /= 4;
    y /= 4;
  }
  x=0;
  for (int i = 8; i >= 0; --i)
    x = x*4 + a[i];
  return x;
}
void bfs()
{
  int x, y;
  que[0] = st;
  vis[st] = true;
  h = 0;
  t = 1;
  while (h < t) {
    x = que[h];
    ++h;
    for (int i = 1; i <= 9; ++i) {
      y = add(x, di[i]);
      if (vis[y]) continue;
      vis[y] = true;
      que[t] = y;
      pre[t] = h - 1;
      sw[t] = i;
      if (y == 0) { print(pre[t]); printf("%d\n", i);}
      ++t;
    }
  }
}
int main()
{
  freopen("clocks.in","r",stdin);
  freopen("clocks.out","w",stdout);     
  for (int i = 0; i < 9; ++i) {
    scanf("%d", &a);
    st = st * 4 + a / 3 % 4;
  }
  bfs();
  return 0;
}
