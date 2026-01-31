from typing import List


class Solution:
    def findMiddleIndex(self, nums: List[int]) -> int:
        total =0
        lent = len(nums)

        for i in range(lent):
            total += nums[i]

        left_sum =0
        for i in range(lent):
            if left_sum == total - left_sum-nums[i]:
                return i

            left_sum += nums[i]

        return -1
if __name__ == "__main__":
    sol = Solution()

    # Test Case 1
print(f"Test 1: {sol.findMiddleIndex([2, 3, -1, 8, 4])} (Expected: 3)")

# Test Case 2
print(f"Test 2: {sol.findMiddleIndex([1, -1, 4])} (Expected: 2)")

# Test Case 3
print(f"Test 3: {sol.findMiddleIndex([2, 5])} (Expected: -1)")
