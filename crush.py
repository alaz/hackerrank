#!/bin/python3

import sys

if __name__ == "__main__":
    n, m = input().strip().split(' ')
    n, m = [int(n), int(m)]
    arr = [0] * (n+1)
    for a0 in range(m):
        a, b, k = input().strip().split(' ')
        a, b, k = [int(a), int(b), int(k)]
        arr[a-1] += k
        arr[b] -= k

    t, r = [0, 0]
    for i in range(0, n):
        t += arr[i]
        r = max(r, t)

    print(r)
