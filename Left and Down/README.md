# Left and Down

**Source:** [Codeforces 2125B — Left and Down](https://codeforces.com/contest/2125/problem/B)  
**Difficulty:** Codeforces rating 900  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

A robot at (a, b) moves to (0, 0) by repeatedly choosing dx, dy ≤ k and moving left dx and down dy. The cost is the number of distinct (dx, dy) vectors used. Minimize it.

## Approach

- One vector suffices iff (a, b) = t·(dx, dy) with dx, dy ≤ k, meaning some divisor t of gcd(a, b) gives a/t, b/t ≤ k.
- Otherwise two vectors always suffice, so the answer is 1 or 2.

## Complexity

- **Time:** O(√gcd) per test case
- **Space:** O(1)

## Concepts

GCD, Divisors

## Files

- [`src/LAD.java`](src/LAD.java)
