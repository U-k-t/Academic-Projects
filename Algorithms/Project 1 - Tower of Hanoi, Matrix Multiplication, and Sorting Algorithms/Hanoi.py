import random, time, sys, matplotlib.pyplot as pp
sys.setrecursionlimit(15000)

def createTower(size): ## Generate a list of Descending Values From Declared Size to 1
    tower = []
    for x in range (0,size):
        tower.append(size-x)
    for x in range(0,len(tower)):
            print(str(tower[len(tower)-x-1]) + '      ' + str([]) + '      ' + str([]))
    print()
    return tower

def tower(tower1,tower2,Hanoi,initSize): ## Tower of Hanoi
    t1 = tower1
    t2 = tower2
    t3 = Hanoi
    if len(t3) == initSize: # Once All Elements Have Been Moved to The Third 'Tower' Stop the Recusive Call
        print()
        for x in range(0,len(t3)):
            print(str(t1) + '      ' + str(t2) + '      ' + str(t3[len(t3)-x-1])) #Print the Towers
    else:
        if initSize %2 != 0:
            if len(t1)!=0 and t1[-1]==1: # Always Start by Moving The Samllest Disk One to the Left
                moveTop(t1,t3)
            elif len(t2)!=0 and t2[-1]==1:
                moveTop(t2,t1)
            elif len(t3)!=0 and t3[-1]==1:
                moveTop(t3,t2)
        else:
            if len(t1)!=0 and t1[-1]==1: # Always Start by Moving The Samllest Disk One to the Right
                moveTop(t1,t2)
            elif len(t2)!=0 and t2[-1]==1:
                moveTop(t2,t3)
            elif len(t3)!=0 and t3[-1]==1:
                moveTop(t3,t1)
        moveOptimal(t1,t2,t3) # Then Make the Most Optimal Move and Call the Function Again
        print(str(t1) + '      ' + str(t2) + '      ' + str(t3))
        tower(t1,t2,t3,initSize)

def moveTop (t1, t2): ## Move an Element From One "Tower" to another
    if len(t1)!=0:
        t2.append(t1[-1])
        t1.pop(len(t1)-1)
def moveOptimal (t1,t2,t3): ## Make Optimal Moves
    if len(t3) == 0 or ((len(t1)!=0 and t3[-1]>t1[-1])and t1[-1]!=1): # Always Move the Largest Element Possible to an Empty Space
        moveTop(t1,t3)
    elif len(t2) == 0 or ((len(t1)!=0 and t1[-1] < t2[-1]) and t1[-1] !=1):
        moveTop (t1,t2)
    elif len(t1) == 0 and (len(t3)!=0 and len(t2)!=0) and t2[-1]<t3[-1]:
        moveTop(t3,t1)
    elif len(t1) == 0 and (len(t3)!=0 and len(t2)!=0) and t2[-1]>t3[-1]:
        moveTop(t2,t1)
    elif (len(t3)!=0 and len(t2)!=0) and (t2[-1]!=1 and t2[-1]<t3[-1]): # If There are No Empty Spaces, Move the Smallest, Topmost Element That is not '1'
        moveTop(t2,t3)
    elif (len(t3)!=0 and len(t2)!=0) and (t3[-1]!=1 and t3[-1]<t2[-1]):
        moveTop(t3,t2)
    elif (len(t3)!=0 and len(t1)!=0) and (t3[-1]!=1 and t3[-1]<t1[-1]):
        moveTop(t3,t1)
    elif (len(t1)!=0 and len(t2)!=0) and (t2[-1]!=1 and t2[-1]<t1[-1]):
       moveTop(t2,t1)

def main():
    testCases = [3,5,7,9,11]
    executionTimes = []
    for x in range(0,len(testCases)):
        hanoi = createTower(testCases[x])
        timestart = time.time()
        tower(hanoi,[],[],len(hanoi))
        timestop = round((time.time() - timestart),3)
        executionTimes.append(timestop)
        print("--- %s Minutes to Execute When Operating on Tower of %d Elements---" % (timestop,testCases[x]))
    pp.plot(testCases,executionTimes)
    pp.xlabel("Size of Tower")
    pp.ylabel("Seconds to Execute")
    pp.show()

main()
