

def printName(num):

    if num == 1:
        return 1
    else:
        return num*printName(num-1)



print(printName(4))
