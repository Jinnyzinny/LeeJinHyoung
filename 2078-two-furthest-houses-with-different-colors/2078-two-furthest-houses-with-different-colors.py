class Solution:
    def maxDistance(self, colors: List[int]) -> int:
        answer = 0
        n = len(colors)
        for i in range(n):
            for j in range(n):
                if colors[i] != colors[j]:
                    answer = max(answer, j - i)

        return answer

        