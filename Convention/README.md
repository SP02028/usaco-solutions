# Convention

**Source:** [USACO 2018 December Contest, Silver — Problem 1: Convention](https://usaco.org/index.php?page=viewproblem2&cpid=858)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N cows arrive at given times and M buses each carry at most C cows. Choose departure times so the maximum waiting time is minimized.

## Approach

- Sort arrival times and binary search the maximum wait w.
- Check greedily: a bus leaves when it is full or when the next cow would make the first cow wait more than w; the check passes if at most M buses are used.

## Complexity

- **Time:** O(N log N + N log T)
- **Space:** O(N)

## Concepts

Binary Search on Answer, Greedy

## Files

- [`src/C.java`](src/C.java)
