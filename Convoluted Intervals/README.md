# Convoluted Intervals

**Source:** [USACO 2021 December Contest, Silver — Problem 3: Convoluted Intervals](https://usaco.org/index.php?page=viewproblem2&cpid=1160)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 20 official USACO test cases.

## Problem

N intervals [a_i, b_i] with endpoints in [0, M]. For every k from 0 to 2M, count ordered pairs (i, j) with a_i + a_j ≤ k ≤ b_i + b_j.

## Approach

- Count how many intervals start (and end) at each value.
- For every pair of start values (x, y), all f(x)·f(y) pairs begin covering k at x + y; for every pair of end values, the pairs stop covering after x + y. Record these in a difference array.
- A prefix sum over the difference array gives each k's count.

## Complexity

- **Time:** O(M² + N)
- **Space:** O(M)

## Concepts

Difference Arrays, Prefix Sums, Counting

## Files

- [`src/CI2.java`](src/CI2.java)
- [`src/TS.java`](src/TS.java)

## Notes

`CI2.java` uses long counters, which are needed because counts reach N² ≈ 4·10¹⁰. `TS.java` is another correct implementation of the same idea; it was stored in a folder named "Talent Show" and has been moved here.
