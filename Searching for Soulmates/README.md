# Searching for Soulmates

**Source:** [USACO 2022 January Contest, Silver — Problem 1: Searching for Soulmates](https://usaco.org/index.php?page=viewproblem2&cpid=1182)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

Transform a into b using +1, ×2 and ÷2 (only when even). Find the minimum number of operations for each pair.

## Approach

- If a > b, the only useful move is to halve (adding 1 first if a is odd).
- If a < b, either add b − a directly, or recurse on (a, b/2) while paying 1 plus the parity of b (the reversed operations).

## Complexity

- **Time:** O(log² max) per pair
- **Space:** O(log max) recursion

## Concepts

Recursion, Greedy, Bit Manipulation

## Files

- [`SearchingForSoulmates.java`](SearchingForSoulmates.java)
- [`src/SfS.java`](src/SfS.java)

## Notes

`SearchingForSoulmates.java` is a commented copy of `src/SfS.java`.
