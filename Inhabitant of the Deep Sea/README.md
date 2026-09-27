# Inhabitant of the Deep Sea

**Source:** [Codeforces 1955C — Inhabitant of the Deep Sea](https://codeforces.com/contest/1955/problem/C)  
**Difficulty:** Codeforces rating 1300  
**Verified:** ✅ Passes all 10 official Codeforces tests that are published in full.

## Problem

n ships with durabilities are attacked k times by a Kraken, alternating first ship, last ship, first, last, …; each attack lowers durability by 1 and a ship at 0 sinks. Count the sunk ships.

## Approach

- If the total durability is ≤ k, all ships sink.
- Otherwise ceil(k/2) attacks hit from the front and floor(k/2) from the back. Greedily sink ships from each end with its share of attacks, then count ships at 0.

## Complexity

- **Time:** O(n)
- **Space:** O(n)

## Concepts

Two Pointers, Simulation

## Files

- [`src/INotDS.java`](src/INotDS.java)
