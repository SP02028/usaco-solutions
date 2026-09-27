# Splitting the Field

**Source:** [USACO 2016 US Open Contest, Gold — Problem 1: Splitting the Field](https://usaco.org/index.php?page=viewproblem2&cpid=645)  
**Difficulty:** Gold  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

Farmer John encloses all N cows in one rectangle. Using two non-overlapping rectangles instead (separated by a vertical or a horizontal line), find the maximum area that can be saved.

## Approach

- Sort cows by x and compute prefix and suffix min/max of y, then try every split between distinct x values and take the smallest total area of the two bounding boxes.
- Repeat with x and y swapped. The answer is the full area minus the best split.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Prefix/Suffix Min/Max, Sorting

## Files

- [`src/StF.java`](src/StF.java)
- [`src/StF2.java`](src/StF2.java)

## Notes

`StF2.java` is the USACO file-I/O version (`split.in` / `split.out`), originally uploaded as a top-level file.
