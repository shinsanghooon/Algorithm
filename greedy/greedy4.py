s = list(map(int, list(input())))

count0 = 0
count1 = 0

# 0 0 0 1 1 0 0

start=0
end=0

for i in range(len(s)-1): 
  if(s[i]==0):
    if(s[i]==s[i+1]):
      end = i+1
      if((i+2) == len(s)):
        count0+=1
    else:
      start = i
      end = i
    if (start == end):
      count0 += 1


start=0
end=0

for i in range(len(s)-1): 
  if(s[i]==1):
    if(s[i]==s[i+1]):
      end = i+1
      if((i+2) == len(s)):
        count1+=1
    else:
      start = i
      end = i
    
    if (start == end):
      count1 += 1

print(count0)
print(count1)