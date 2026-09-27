# Stick Divisions

**Source:** [CSES Problem Set — Stick Divisions](https://cses.fi/problemset/task/1161)  
**Verified:** ⚪ Not verified automatically: CSES does not publish its test data.

## Problem

Cut a stick of length x into pieces of given lengths; each cut costs the length of the stick being cut. Minimize the total cost.

## Approach

- Reverse the process: merge pieces, where merging costs their sum. Always merge the two smallest (Huffman coding) using a min-heap.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Greedy, Priority Queue, Huffman Coding

## Files

- [`src/SD.java`](src/SD.java)
