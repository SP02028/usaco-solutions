# Subarray Divisibility

**Source:** [CSES Problem Set — Subarray Divisibility](https://cses.fi/problemset/task/1662)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

Count subarrays whose sum is divisible by n.

## Approach

- A subarray sum is divisible by n iff two prefix sums are congruent mod n. Count the prefix residues (normalized to be non-negative, starting with residue 0 once) and add C(count, 2) for each residue.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Prefix Sums, Modular Arithmetic, Counting

## Files

- [`src/SD.java`](src/SD.java)

## Notes

The folder name is a misspelling of "Subarray Divisibility".
