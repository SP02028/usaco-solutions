# Add or XOR

**Source:** [Codeforces 2119A — Add or XOR](https://codeforces.com/contest/2119/problem/A)  
**Difficulty:** Codeforces rating 800  
**Verified:** ✅ Passes the sample test from the problem statement (full official tests are not published for this problem).

## Problem

Transform a into b using operations a := a + 1 (cost x) or a := a XOR 1 (cost y). Find the minimum total cost, or −1 if impossible.

## Approach

- If a > b, the only way down is XOR when a is odd and a XOR 1 = b.
- Otherwise every unit step from a to b is needed. Steps from an even number to the next odd number can be done by either operation, so use the cheaper one; steps from odd to even require +1.

## Complexity

- **Time:** O(1) per test case
- **Space:** O(1)

## Concepts

Math, Bit Manipulation, Greedy

## Files

- [`src/AOX.java`](src/AOX.java)
