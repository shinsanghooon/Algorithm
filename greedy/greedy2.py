n = map(int, input().split())
data = list(map(int, input().split()))
# 2, 3, 1, 2, 2

data.sort()
# 1, 2, 2, 2, 3

count = 0
now_count = 0
for i in data:
  now_count += 1
  if now_count >= i:
    count +=1 
    now_count = 0

print(count)
