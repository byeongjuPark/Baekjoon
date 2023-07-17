def solution(s):
    answer = ''
    blankCheck = 1
    for a in s.lower():
        if a == ' ':
            blankCheck = 1
            
        elif blankCheck == 1:
            if a.isalpha():
                a = a.upper()
            blankCheck = 0
        answer += a
    
    return answer