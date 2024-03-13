def find_pair(x):
    for a in range(1, x + 1):
        for b in range(1, x + 1):
            if a * b > x and a/b <x:
                return b,a 
    return -1

# Read input
x = int(input())

# Find and print the pair or -1 if no pair is found
result = find_pair(x)
if result == -1:
    print("-1")
else:
    print(*result)
