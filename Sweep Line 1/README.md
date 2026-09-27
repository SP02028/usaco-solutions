# Sweep Line 1

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

Given N segments on a line, count the pairs of segments that intersect.

## Approach

- Create a left and a right endpoint event per segment and sort them (left before right at equal x).
- Sweep: at each left endpoint, the new segment intersects every currently open segment, so add the active count, then open it; close segments at their right endpoints.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sweep Line, Sorting

## Files

- [`src/SL1.java`](src/SL1.java)
