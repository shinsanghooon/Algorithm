# 10 min

input_data = input()
row = int(input_data[1])
column = int(ord(input_data[0])) - int(ord('a')) + 1

move_steps = [(-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, -1), (-2, 1)]

count = 0

for step in move_steps:
  new_row = row + step[0]
  new_col = column + step[1]

  if (new_row < 1) or (new_row > 8):
    continue
  
  if (new_col < 1) or (new_col > 8):
    continue

  count += 1

print(count)