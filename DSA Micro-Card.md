# 1-Line Core Takeaway:


## Next Permutation (LeetCode 31)
> Find the rightmost digit that can increase ($nums[i] < nums[i+1]$), swap it with the smallest larger element to its right, and reverse the remaining suffix to minimize it in $O(N)$ time.

---

### Key Invariant

* **Why it works:** A descending suffix represents the maximum possible value for those digits, so swapping the pivot with its smallest larger successor and reversing the suffix converts it into the minimum possible ascending order for the next step.

---

### Implementation Checklist

1. **Find Pivot ($i$):** Scan right-to-left to find the first index $i$ where $nums[i] < nums[i+1]$.
2. **Find Swap Target ($j$):** If $i \ge 0$, scan right-to-left to find the first index $j$ where $nums[j] > nums[i]$, then swap $nums[i]$ and $nums[j]$.
3. **Minimize Suffix:** Reverse the subarray from index $i + 1$ to the end of the array.
4. **Edge Cases:** Fully descending array (e.g., `[3, 2, 1]` — no pivot found, reverses directly to `[1, 2, 3]`), arrays of size $\le 1$, and duplicate elements (use strict `<` and `>` comparisons).

---

### Complexity

* **Time:** $O(N)$
* **Space:** $O(1)$