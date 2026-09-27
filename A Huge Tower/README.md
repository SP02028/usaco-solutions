# A Huge Tower

**Source:** [CEOI 2010 — A Huge Tower](https://oj.uz/problem/view/CEOI10_tower)  
**Verified:** ⚪ Not verified automatically: no downloadable test data for this problem.

## Problem

There are N blocks with given sizes. A tower is a stacking order of all blocks in which every block placed on top of another is at most D larger than the block directly below it. Count the valid towers modulo 1 000 000 009.

## Approach

- Sort the sizes. Build the tower by inserting blocks from largest to smallest: block l can be placed directly beneath itself or beneath any block in (l, r], where r is the last block with size ≤ size[l] + D, giving (r − l + 1) choices.
- Maintain r with a two-pointer sweep and multiply the answer by (r − l + 1) modulo 1e9+9.

## Complexity

- **Time:** O(N log N)
- **Space:** O(N)

## Concepts

Sorting, Two Pointers, Combinatorics

## Files

- [`src/AHT.java`](src/AHT.java)
