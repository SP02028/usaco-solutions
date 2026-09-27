# Bit Inversions

**Source:** [CSES Problem Set — Bit Inversions](https://cses.fi/problemset/task/1188)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

A bit string is updated by flipping one bit at a time. After every flip, report the length of the longest run of equal bits.

## Approach

- Store the boundaries between runs in a TreeSet and a multiset (TreeMap of length → count) of run lengths.
- Flipping bit i toggles the boundaries at positions i and i+1; toggling a boundary merges or splits one run, which updates the multiset in O(log n).
- The answer after each update is the largest key of the multiset.

## Complexity

- **Time:** O((n + m) log n)
- **Space:** O(n)

## Concepts

TreeSet, Ordered Multiset

## Files

- [`src/BI.java`](src/BI.java)
