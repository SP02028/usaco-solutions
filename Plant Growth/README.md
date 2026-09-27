# Plant Growth

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

N plants each grow best when the water level T lies in [A_i, B_i]: they produce X below the range, Y inside it and Z above it. Choose T to maximize total production.

## Approach

- Only the values A_i and B_i + 1 can change the answer, so evaluate those candidate levels.
- Sort the A's and the B's and count, for a given T, how many plants are below, inside and above their ranges with binary search.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sorting, Binary Search, Candidate Points

## Files

- [`src/PG.java`](src/PG.java)
