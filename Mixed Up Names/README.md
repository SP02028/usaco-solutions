# Mixed Up Names

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

Each of N cow names has been scrambled. For each cow, find the earliest and latest position its name could occupy when all scrambled names are sorted alphabetically.

## Approach

- The best case for a cow is her letters sorted ascending while every other cow's letters are sorted descending; the worst case is the reverse.
- Sort the ascending and the descending versions of all names. Binary search to count how many other names must come before or after in each case.

## Complexity

- **Time:** O(N log N · L)
- **Space:** O(N · L)

## Concepts

Sorting, Binary Search, Strings

## Files

- [`src/MUN.java`](src/MUN.java)
