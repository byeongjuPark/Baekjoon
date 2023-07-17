def solution(n):
    if n == 0 or n == 1:
        return n
    answer = 0
    af = 0 
    be = 1
    for a in range(n):
        af = be
        be = answer
        answer = (af+be) % 1234567
    return answer

# 0 1 1 2 3 5 8 13 21