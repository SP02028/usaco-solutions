# Dividing the Pasture

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

N axis-aligned rectangles are given. Decide whether they exactly tile a rectangle, with no overlap and no gaps.

## Approach

- The total area must equal the bounding box area.
- Every internal corner is shared by an even number of rectangles, so toggling each rectangle's four corners in a set must leave exactly the bounding box's four corners.

## Complexity

- **Time:** O(N)
- **Space:** O(N)

## Concepts

Geometry, Hashing

## Files

- [`src/DTP.java`](src/DTP.java)
