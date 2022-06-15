n = int(input())
x, y = 1, 1
plans = input().split()

for p in plans:
  if p == 'L':
    # not move y = 1
    if y == 1:
      continue
    
    y -= 1
  
  elif p == 'R':
    # not move y = n
    if y == n:
      continue
    
    y += 1

  elif p == 'U':
    # not move x = 1
    if x == 1:
      continue
    
    x -=1 

  else: #D
    # not move x = n
    if x == n:
      continue
    x += 1

print(x, y)