# Fight with Monsters

**Source:** [Codeforces 1296D — Fight with Monsters](https://codeforces.com/contest/1296/problem/D)  
**Difficulty:** Codeforces rating 1500  
**Verified:** ✅ Passes all 5 official Codeforces tests that are published in full.

## Problem

You and an opponent alternately hit n monsters (you deal a, the opponent b), and you score a monster if your hit kills it. You may use a 'skip opponent' technique at most k times in total. Maximize your score.

## Approach

- Reduce each monster's HP modulo (a + b) (using a + b if the remainder is 0); the number of skips needed to win it is ceil(hp / a) − 1.
- Sort the costs and greedily take the cheapest monsters while skips remain.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Greedy, Sorting, Math

## Files

- [`src/FWM.java`](src/FWM.java)
