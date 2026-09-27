# RoboCow and StackTask

**Source:** Not publicly listed; the same task as the classic "Haybale Stacking" problem  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

N stacks start empty and K instructions each add one item to every stack in a range [A, B]. Output the median stack height.

## Approach

- Apply the ranges with a difference array, prefix-sum, sort the heights and print the middle one.

## Complexity

- **Time:** O(N log N + K)
- **Space:** O(N)

## Concepts

Difference Arrays, Sorting

## Files

- [`src/RCAST.java`](src/RCAST.java)
