# RationalLee

**Source:** [Codeforces 1369C — RationalLee](https://codeforces.com/contest/1369/problem/C)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Distribute n integers among k friends, where friend i gets w_i of them and is happy with (max + min) of their share. Maximize the total happiness.

## Approach

- Sort the numbers. Friends with w_i = 1 get the largest numbers, counted twice (as both max and min).
- Every other friend gets one of the next-largest numbers as max. Assign minima from the smallest numbers, giving friends with larger w their minimum first; the code does this by adding the next k − ones elements from the front of the sorted array.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n + k)

## Concepts

Greedy, Sorting

## Files

- [`src/RL.java`](src/RL.java)
