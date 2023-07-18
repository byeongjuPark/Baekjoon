def solution(x):
    numStr = str(x)
    strList = list(numStr)
    answer = False
    sum = 0
    for digit in strList:
        sum += int(digit)
        
    if x%sum==0:
        answer = True
    
    
    return answer