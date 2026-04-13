class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        answer=10000
        for i in range(len(nums)):
            if nums[i]==target:
                answer=min(abs(i-start),answer)
        return answer

        