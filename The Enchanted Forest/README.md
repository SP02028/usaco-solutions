# The Enchanted Forest

**Source:** [Codeforces 1687A — The Enchanted Forest](https://codeforces.com/contest/1687/problem/A)  
**Difficulty:** Codeforces rating 1600  
**Verified:** ✅ Passes all 1 official Codeforces tests that are published in full.

## Problem

Mushrooms grow by 1 per minute at each of n points. Marisa starts anywhere and moves one step per minute for k minutes, collecting all mushrooms at each point she visits. Maximize the total (The Enchanted Forest).

## Approach

- If k ≤ n, walk the best window of k consecutive points: its initial sum plus 0 + 1 + … + (k − 1) growth.
- If k > n, collect everything, ending with a sweep over all n points; the growth bonus is n(k − 1) − n(n − 1)/2.

## Complexity

- **Time:** O(n) per test case
- **Space:** O(n)

## Concepts

Prefix Sums, Sliding Window, Math

## Files

- [`src/TEF.java`](src/TEF.java)

## Notes

This folder was previously named "The Robotic Rush"; the IntelliJ project was named "The Enchanted Forest", which is the problem this code solves, so the folder has been renamed.
