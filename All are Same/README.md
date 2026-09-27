# All are Same

**Source:** [Codeforces 1593D1 — All are Same](https://codeforces.com/contest/1593/problem/D1)  
**Difficulty:** Codeforces rating 1100  
**Verified:** ✅ Passes all 34 official Codeforces tests that are published in full.

## Problem

Find the largest k such that subtracting k from elements some number of times can make all elements of the array equal; print −1 if k can be arbitrarily large.

## Approach

- If all elements are already equal, the answer is −1.
- Otherwise every element must be reduced to the minimum, so k must divide every difference a_i − min; the answer is gcd of all a_i − min.

## Complexity

- **Time:** O(n log A)
- **Space:** O(n)

## Concepts

GCD, Number Theory

## Files

- [`src/AaS.java`](src/AaS.java)
