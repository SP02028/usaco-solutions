# Add to Neighbour and Remove

**Source:** [Codeforces 1462D — Add to Neighbour and Remove](https://codeforces.com/contest/1462/problem/D)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 4 official Codeforces tests that are published in full.

## Problem

In one operation you add an element to one of its neighbours and remove it. Find the minimum number of operations to make all elements equal.

## Approach

- The final array consists of k equal segments of sum S/k, so minimizing operations means maximizing k (operations = n − k).
- Try k from n down to 1 with S divisible by k and greedily check whether the array splits into consecutive segments of sum S/k.

## Complexity

- **Time:** O(n · d(S)) per test case
- **Space:** O(n)

## Concepts

Greedy, Divisors, Prefix Sums

## Files

- [`src/ATNAR.java`](src/ATNAR.java)
