def solution(s):
    answer = True
    
    cnt = 0
    for x in s:
        if cnt==-1:
            break
        if x =="(":
            cnt+=1
        else:
            cnt-=1
    if cnt == 0:
        answer = True
    else:
        answer = False
    
    return answer