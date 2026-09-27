# Create The Teams

**Source:** [Codeforces 1380C — Create The Teams](https://codeforces.com/contest/1380/problem/C)  
**Difficulty:** Codeforces rating 1400  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

n programmers with skills a_i. A team is valid if (team size) × (minimum skill) ≥ x. Maximize the number of valid teams.

## Approach

- Sort skills and scan from strongest to weakest, adding programmers to the current team and closing the team as soon as size × current skill ≥ x.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Greedy, Sorting

## Files

- [`src/CTT.java`](src/CTT.java)
