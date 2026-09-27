# OutOfMemoryError

**Source:** [Codeforces 2185D — OutOfMemoryError](https://codeforces.com/contest/2185/problem/D)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

An array must handle M additions a_i += b; whenever a value would exceed h, the entire array resets to its original values. Output the final array.

## Approach

- Use a version counter instead of physically resetting: each element stores the version when it was last changed plus its delta since the reset.
- A reset just increments the version, so every element is lazily treated as original.

## Complexity

- **Time:** O(N + M) per test case
- **Space:** O(N)

## Concepts

Lazy Reset, Timestamps

## Files

- [`src/OutOfMemoryError.java`](src/OutOfMemoryError.java)
