# Farmer John Actually Farms

**Source:** [USACO 2023 December Contest, Bronze — Problem 3: Farmer John Actually Farms](https://usaco.org/index.php?page=viewproblem2&cpid=1349)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 13 official USACO test cases.

## Problem

N plants have heights h_i and grow a_i per day. Farmer John knows t_i, the number of plants that must be taller than plant i. Find the minimum day on which the height ranking matches t, or −1.

## Approach

- Sort plants by their required rank (N − t_i − 1). Consecutive plants in this order must satisfy height_{i-1}(d) > … strictly, which gives either a lower bound on d (when the later plant grows faster but starts shorter) or an upper bound (when it grows slower).
- Take the maximum lower bound and the minimum upper bound; the answer is the lower bound if it is below every upper bound, otherwise −1.

## Complexity

- **Time:** O(N log N) per test case
- **Space:** O(N)

## Concepts

Sorting, Inequalities, Math

## Files

- [`src/FJACF.java`](src/FJACF.java)
