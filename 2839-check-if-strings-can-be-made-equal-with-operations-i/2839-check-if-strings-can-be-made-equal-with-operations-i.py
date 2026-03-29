class Solution:
    def __init__(self):
        self.answer = False  # 인스턴스 변수로 관리

    def dfs(self, split: List[str], index: int, s2: str) -> None:
        # 이미 정답을 찾았다면 더 이상 탐색하지 않음 (최적화)
        if self.answer:
            return
            
        if index == len(split):
            if "".join(split) == s2:
                self.answer = True
            return

        # 1. 현재 상태 그대로 다음 인덱스 탐색
        self.dfs(split, index + 1, s2)

        # 2. i와 i-2를 바꾼 상태로 탐색 (조건 충족 시)
        if index >= 2:
            split[index], split[index-2] = split[index-2], split[index] # Swap
            self.dfs(split, index + 1, s2)
            split[index], split[index-2] = split[index-2], split[index] # Backtracking
        
        
    def canBeEqual(self, s1: str, s2: str) -> bool:
        split1=list(s1)
        self.dfs(split1,0,s2)
        if self.answer:
            return True
        else:
            return False


        