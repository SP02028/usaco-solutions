# Square Overlap

**Source:** [USACO 2013 January Contest, Silver — Problem 2: Square Overlap](https://usaco.org/index.php?page=viewproblem2&cpid=227)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 10 official USACO test cases.

## Problem

N axis-aligned K×K tiles (given by their lower-left corners). Output 0 if no two tiles overlap, the overlap area if exactly one pair overlaps, or −1 if more than one pair does.

## Approach

- Sort tiles by x and sweep with a window of tiles whose x is within K. Keep the active tiles in a TreeSet ordered by y and check the nearest neighbours in y for vertical overlap.
- Stop as soon as a second overlapping pair appears; otherwise compute the single overlap's area from the x and y overlaps.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sweep Line, TreeSet, Geometry

## Files

- [`src/TC.java`](src/TC.java)

## Notes

This is AlphaStar's reworded version of USACO 2013 January Silver "Square Overlap"; the folder keeps the AlphaStar title.
