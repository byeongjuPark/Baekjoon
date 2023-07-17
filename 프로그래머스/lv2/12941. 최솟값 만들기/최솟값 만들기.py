def solution(A,B):
    answer = 0
    A.sort()
    B.sort(reverse=True)
    print(A)
    print(B)
    for x in range(len(A)):
        answer += (A[x]*B[x])

    return answer