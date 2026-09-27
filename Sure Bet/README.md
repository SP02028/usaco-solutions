# Sure Bet

**Source:** Not publicly listed (practice / course problem)  
**Verified:** ⚪ Not verified automatically: the problem is not publicly listed, so there is no test data.

## Problem

n bets on each of two outcomes with given odds. Choose some bets from each side (each costs 1 unit) to maximize the guaranteed profit: the minimum over the two outcomes of the payout minus total stakes.

## Approach

- Sort both sides' odds descending, since the best bets are always a prefix of each side.
- Add bets from side A one at a time. While adding the next best side-B bet improves the minimum of the two outcomes, add it (two pointers). Track the best minimum.

## Complexity

- **Time:** O(n log n)
- **Space:** O(n)

## Concepts

Greedy, Two Pointers, Sorting

## Files

- [`src/SB.java`](src/SB.java)
