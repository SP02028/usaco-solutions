# Max Binary Tree Width

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

For each n, find the largest w such that the sum w + ceil(w/2) + ceil(w/4) + … (down to 1) is at most n.

## Approach

- The sum is monotone in w, so binary search on w, computing the sum by repeatedly halving (rounding up).

## Complexity

- **Time:** O(log² n) per test case
- **Space:** O(1)

## Concepts

Binary Search on Answer

## Files

- [`src/Main.java`](src/Main.java)
