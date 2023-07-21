def solution(n):
    answer = 0
    onecnt = bin(n).count('1')
    
    for a in range(n+1, 1000000):
        if onecnt == bin(a).count('1'):
            answer = a
            break
    return answer