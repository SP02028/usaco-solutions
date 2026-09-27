# Learning by Example

**Source:** [USACO 2014 December Contest, Bronze — Problem 4: Learning by Example](https://usaco.org/index.php?page=viewproblem2&cpid=490)  
**Difficulty:** Silver (this contest predates Platinum, so its Bronze division was Silver-level)  
**Verified:** ✅ Passes all 13 official USACO test cases, checked with a custom validator because more than one answer is accepted.

## Problem

Farmer John classifies each cow as spotted or not by copying the nearest cow whose weight he already knows (ties go to spotted). Count the spotted cows among weights in [A, B].

## Approach

- Sort the known cows and add sentinels at −∞ and +∞.
- Each gap between consecutive known weights is split at its midpoint: the left half follows the left cow and the right half the right cow. Count the spotted part of each half intersected with [A, B], plus the exact midpoint when a spotted cow wins the tie.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sorting, Intervals, Math

## Files

- [`src/LBE.java`](src/LBE.java)
