# Movie Festival II

**Source:** [CSES Problem Set — Movie Festival II](https://cses.fi/problemset/task/1632)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

n movies (start, end) and k club members. Each member watches movies one at a time. Maximize the number of movies watched in total.

## Approach

- Sort movies by end time. Keep a multiset (TreeMap) of the members' free-at times.
- For each movie, assign it to the member who became free latest but still no later than its start (floorKey), and update that member's free time to the movie's end.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n + k)

## Concepts

Greedy, Sorting, TreeMap Multiset

## Files

- [`src/MFII.java`](src/MFII.java)
