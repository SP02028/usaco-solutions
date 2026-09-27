# Out of Sorts

**Source:** [USACO 2018 US Open Contest, Silver — Problem 1: Out of Sorts](https://usaco.org/index.php?page=viewproblem2&cpid=834)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Same problem as `OoS`: count the passes of Bessie's bubble sort.

## Approach

- Answer = 1 + the maximum distance an element must move left, computed by comparing each value's original index with its stably sorted index.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sorting, Bubble Sort Analysis

## Files

- [`src/OoS.java`](src/OoS.java)
- [`src/OoS3.java`](src/OoS3.java)

## Notes

`OoS.java` reads stdin; `OoS3.java` is the USACO file-I/O version (`sort.in` / `sort.out`).
