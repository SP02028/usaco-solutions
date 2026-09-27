# Even More Odd Photos

**Source:** [USACO 2021 January Contest, Bronze — Problem 2: Even More Odd Photos](https://usaco.org/index.php?page=viewproblem2&cpid=1084)  
**Difficulty:** Bronze  
**Verified:** ✅ Passes all 11 official USACO test cases.

## Problem

Group N cows (by breed ID) into a sequence of groups whose sums alternate even, odd, even, …. Maximize the number of groups.

## Approach

- Only the counts of even and odd IDs matter.
- While there are more odd than even IDs, merge two odds into an 'even' group.
- If even groups exceed odd groups by more than one, merge extras so evens = odds + 1; the answer is evens + odds.

## Complexity

- **Time:** O(N)
- **Space:** O(1)

## Concepts

Greedy, Parity

## Files

- [`src/emoc.java`](src/emoc.java)
