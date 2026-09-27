# Pencil Shades

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

A painter starts at position 0 and makes N moves (distance and direction L/R), painting each unit segment he passes. Count the total length painted at least K times.

## Approach

- Store a +1 / −1 event at the two ends of every move in a TreeMap (a coordinate-compressed difference array).
- Sweep the keys in order, keeping the running coverage, and add the segment length whenever the coverage is ≥ K.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sweep Line, Difference Array on a TreeMap

## Files

- [`src/PS.java`](src/PS.java)
