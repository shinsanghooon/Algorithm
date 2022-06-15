n = map(int, input())
data = list(map(int, input().split()))
data.sort()

target=1
for x in data:
  print(f'target {target} / x {x}')
  if target < x:
    break
  target += x


print(target)