# Acron Bracelet

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

A bracelet is described by a string of '(' and ')'. Report how many characters have to be read before the string first becomes unbalanced, checking both from the left and (with brackets mirrored) from the right, and print the larger of the two values (0 if neither direction ever becomes unbalanced).

## Approach

- Scan left to right counting '(' and ')'; the first time closes exceed opens, return the number of closes seen.
- Reverse the string and swap every bracket, then run the same scan to handle the right-to-left direction.
- Print the maximum of the two scans.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Bracket Sequences, Prefix Balance

## Files

- [`src/AB.java`](src/AB.java)
