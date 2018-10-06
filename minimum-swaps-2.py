#!/bin/python3

# https://www.hackerrank.com/challenges/minimum-swaps-2

import sys

if __name__ == "__main__":
    n = int(input())
    a = [int(s) for s in input().strip().split(' ')]

    swaps = 0
    i = 0
    while i < n-1:
        if a[i] > i+1:
            j = min(a[i],n)-1
            a[i], a[j] = a[j], a[i]
            swaps += 1
        else:
            i += 1

    print(swaps)
