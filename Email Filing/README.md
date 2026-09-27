# Email Filing

**Source:** [USACO 2022 February Contest, Silver — Problem 3: Email Filing](https://usaco.org/index.php?page=viewproblem2&cpid=1208)  
**Difficulty:** Silver  
**Verified:** ✅ Passes all 12 official USACO test cases.

## Problem

Farmer John files M emails into N folders using a screen that shows K folders and K emails at a time, and both lists can only be scrolled down (emails can be skipped and revisited from the bottom). Decide whether all emails can be filed.

## Approach

- Simulate the scrolling. Keep a priority queue of visible emails keyed by folder, and file every email whose folder is on screen.
- Advance the folder window once its top folder is empty; otherwise scroll the email list, skipping emails that are already filed.
- After reaching the end of the email list, scroll back up through the skipped emails and check that each can be filed while the folder window moves down.

## Complexity

- **Time:** O((N + M) log M)
- **Space:** O(N + M)

## Concepts

Simulation, Priority Queue, Two Windows

## Files

- [`src/EF.java`](src/EF.java)
