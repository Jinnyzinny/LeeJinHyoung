import copy

class Solution:
    def areSimilar(self, mat: List[List[int]], k: int) -> bool:
        # K번 움직여야 하므로

        origin=copy.deepcopy(mat)
        # 3. 행별 회전 로직 실행
        for _ in range(k):
            for r, row in enumerate(mat):
                if r % 2 == 0:
                    # 짝수 행: 왼쪽으로 회전 (앞에서 빼서 뒤로)
                    row.append(row.pop(0))
                else:
                    # 홀수 행: 오른쪽으로 회전 (뒤에서 빼서 앞으로)
                    row.insert(0, row.pop())

        if origin==mat:
            return True
        else:
            return False
        


        