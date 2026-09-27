# EV Tractor

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

A tractor has N instructions (dx, dy) and must reach (x_g, y_g) using a subset of them. For every K from 1 to N, count the subsets of exactly K instructions that end at the goal.

## Approach

- Meet in the middle: split the instructions into two halves of ≤ 20.
- For every subset of each half, record its displacement and size in a hash map (displacement → count per size).
- For each displacement in the first half, look up the complementary displacement in the second half and add count₁[i]·count₂[j] to ans[i + j].

## Complexity

- **Time:** O(2^(N/2) · N)
- **Space:** O(2^(N/2) · N)

## Concepts

Meet in the Middle, Bitmask Enumeration, Hashing

## Files

- [`src/EVT.java`](src/EVT.java)
