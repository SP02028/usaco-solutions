# Triangles

**Source:** [USACO 2020 February Contest, Silver — Problem 2: Triangles](https://usaco.org/index.php?page=viewproblem2&cpid=1015)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N fence posts; count the total (doubled) area of right triangles with one leg vertical and one leg horizontal, modulo 10⁹ + 7.

## Approach

- A right angle at post p contributes (Σ vertical distances to posts with the same x) × (Σ horizontal distances to posts with the same y).
- For each x-column (and y-row), sort the posts and compute each post's sum of distances with a sweep that updates the running sum by (2j − size)·gap. Multiply per post and sum mod p.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N + coordinate range)

## Concepts

Prefix Sums, Sorting, Counting

## Files

- [`previous/T.java`](previous/T.java)
- [`src/T.java`](src/T.java)

## Notes

An earlier copy of this solution uploaded as a top-level file is kept in `previous/`.
