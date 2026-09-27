# Year of the Cow

**Source:** [USACO 2021 February Contest, Silver — Problem 2: Year of the Cow](https://usaco.org/index.php?page=viewproblem2&cpid=1111)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Bessie visits N ancestors at given years in the past using a time portal that only works on multiples of 12 years, with at most K jumps back. Minimize the total years travelled.

## Approach

- Map ancestors to 12-year blocks and sort the distinct blocks. Walking back through every block to the farthest ancestor is the baseline; each extra jump lets her skip one of the largest empty gaps between blocks.
- Subtract the K − 1 largest gaps and multiply by 12.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Greedy, Sorting

## Files

- [`YearOfTheCow.java`](YearOfTheCow.java)
