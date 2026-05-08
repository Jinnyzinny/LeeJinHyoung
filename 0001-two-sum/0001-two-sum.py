class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        answer=[];
        for i in range(len(nums)):
            for j in range(len(nums)):
                if(i!=j and nums[i]+nums[j]==target):
                    answer.append(i)
                    answer.append(j)
                    return answer
        