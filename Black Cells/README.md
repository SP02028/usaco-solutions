# Black Cells

**Source:** [Codeforces 1821D — Black Cells](https://codeforces.com/contest/1821/problem/D)  
**Difficulty:** Codeforces rating 1900  
**Verified:** ✅ Passes all 3 official Codeforces tests that are published in full.

## Problem

On an infinite strip, you may paint cells only inside n given segments, moving right one cell at a time and pressing/releasing a 'shift' button (each press/release costs 1). Paint at least k cells with the minimum number of moves.

## Approach

- Scan segments left to right. Segments of length 1 are 'optional' and cost 2 operations for just one cell, so count them separately.
- After each segment, if the long segments so far give at least k cells, the answer candidate is r_i − (overshoot) + 2·(segments used). Otherwise, if length-1 segments can fill the gap, use as many as needed.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Greedy, Prefix Scan

## Files

- [`src/BC.java`](src/BC.java)
