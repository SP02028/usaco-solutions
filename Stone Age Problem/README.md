# Stone Age Problem

**Source:** [Codeforces 1679B — Stone Age Problem](https://codeforces.com/contest/1679/problem/B)  
**Difficulty:** Codeforces rating 1200  
**Verified:** ✅ Passes all 7 official Codeforces tests that are published in full.

## Problem

Maintain the sum of an array under point assignments and 'assign every element to x' operations.

## Approach

- Store the time and value of the last global assignment and the time of each element's last point update. An element's current value is its own value if it was updated after the last global assignment, otherwise the global value; update the sum accordingly.

## Complexity

- **Time:** O(n + q)
- **Space:** O(n)

## Concepts

Lazy Updates, Timestamps

## Files

- [`src/SAP.java`](src/SAP.java)
