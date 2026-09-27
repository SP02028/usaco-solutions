# Carousel

**Source:** [Codeforces 1328D — Carousel](https://codeforces.com/contest/1328/problem/D)  
**Difficulty:** Codeforces rating 1800  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Colour n animal figures arranged in a circle with the minimum number of colours so that no two adjacent figures of different types share a colour.

## Approach

- If all types are equal, 1 colour suffices.
- If n is even, alternate colours 1 and 2.
- If n is odd but two adjacent figures share a type, give them the same colour and alternate everywhere else.
- Otherwise 3 colours are needed: alternate 1/2 and give the last figure colour 3.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Constructive, Case Analysis, Cycles

## Files

- [`src/C.java`](src/C.java)
