# Chladni Figure

**Source:** [Codeforces 1147B — Chladni Figure](https://codeforces.com/contest/1147/problem/B)  
**Difficulty:** Codeforces rating 1900  
**Verified:** ✅ Passes all 13 official Codeforces tests that are published in full.

## Problem

A circle has n evenly spaced points and m segments between them. Decide whether rotating the picture by some k (1 ≤ k < n) maps the set of segments onto itself.

## Approach

- Any valid rotation can be reduced to a rotation by a divisor of n, so try only the proper divisors k of n.
- Store every segment as a normalized 64-bit hash in a HashSet and check that each rotated segment exists.

## Complexity

- **Time:** O(d(n) · m)
- **Space:** O(m)

## Concepts

Symmetry, Divisors, Hashing

## Files

- [`src/ChladniFigure.java`](src/ChladniFigure.java)

## Notes

The folder name is short for Chladni Figure.
