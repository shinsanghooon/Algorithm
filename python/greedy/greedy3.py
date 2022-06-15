data = list(map(int, list(input())))
print(data)

result = 1 
for i in data:
  if i == 1 or i == 0:
    result = result + i
  else:
    result = result * i

print(result)