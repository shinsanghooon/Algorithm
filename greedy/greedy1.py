n, m, k = map(int, input().split())
data = list(map(int, input().split()))

print(n, m, k)
print(data)

# 2, 4, 5, 4, 6
# 6, 5, 4 ,4, 2 
data.sort()
first = data[n - 1]
second = data[n - 2]

result = 0 

iter_count = m // (k+1)
additional = m % (k+1)

print(iter_count)
print(additional)

result = (first * k + second) * iter_count + first * additional
print(result)
