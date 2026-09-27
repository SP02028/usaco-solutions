# Art Exhibition

**Source:** [JOI 2018 Final Round (Japanese Olympiad in Informatics) — Art Exhibition](https://oj.uz/problem/view/JOI18_art)  
**Verified:** ⚪ Not verified automatically: no downloadable test data for this problem.

## Problem

Each artwork has a size A_i and a value B_i. Choose a non-empty set maximizing S − (A_max − A_min), where S is the total value chosen.

## Approach

- Sort by size; for a fixed right end r it is optimal to take every artwork from some left index l to r.
- Maintain a sliding window with the running value sum, dropping from the left whenever the sum falls below the size spread, and track the best value of sum − (A_r − A_l).

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Sorting, Two Pointers

## Files

- [`src/AE.java`](src/AE.java)
