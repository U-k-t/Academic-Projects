import random, time, sys, matplotlib.pyplot as pp
sys.setrecursionlimit(15000)

def populateList(size): ## Generate a List of Size N with Random Values Ranging from 0-N
    list = []
    for x in range(1,size+1):
        list.append(x)
    for y in range (0,7): ##Shuffle List Seven Times Based on Principles of Randomization
        random.shuffle(list)
    return list

def mergeSort(list): ## Merge Sort Algorithm (Recursively Divide)
    mid = len(list)//2 # Find Midpoint of the Original Array (Integer, no Remainder)
    temp=[]
    sub1 = list[:mid] # Divide Arrays into Left and Right Halves
    sub2 = list[mid:]
    if len(sub1)>=2: # Recursively Divide the Array Till Size 1 Arrays
        sub1 = mergeSort(sub1)
    if len (sub2)>=2: # Recursively Divide the Array Till Size 1 Arrays
        sub2 = mergeSort(sub2)
    temp = combine(sub1,sub2) # Combine Smaller Arrays Until Fully Reunified
    return temp
def combine (a1,a2): ## Combine Two Arrays into a Larger, Sorted Array (... and Conquer)
    temp = []
    pos1 = 0
    pos2 = 0
    targetSize = len(a1)+len(a2)
    if len(a1) == 0: # Default Cases in the Event There is an Empty Array
        return a2
    elif len(a2) == 0:
        return a1
    while len(temp)<targetSize: # Compare the Element Values Until All Are Accounted For
        if a1[pos1] < a2[pos2]:
            temp.append(a1[pos1])
            pos1+=1
        else:
            temp.append(a2[pos2])
            pos2+=1
        if pos1 == len(a1): # Once One of the Arrays has Been Fully Accounted For, Append the Rest of the Array to the End of the Merge
            temp += a2[pos2:]
            break
        elif pos2== len(a2):
            temp += a1[pos1:]
            break
    return temp

def checkSort (list): ## Verification Method to Confirm List is Sorted
    #print(list)
    for x in range(0,len(list)-2):
        if list[x] > list[x+1]:
            # print(list)
            return '----------- Error -----------'
        else:
            return ('----------- %d Elements Sorted -----------' % len(list))

def main(): ## Driver Program
    testCases = [10000,20000,50000,100000,1000000,2000000]
    executionTimes = []
    for x in range(0,len(testCases)):
        arr = populateList(testCases[x])
        mergestart = time.time()
        sorted = mergeSort(arr)
        mergestop = round((time.time() - mergestart)/60,3)
        executionTimes.append(mergestop)
        print("--- %s Minutes to Execute When Sorting %d Elements---" % (mergestop,testCases[x]))
        print(checkSort(sorted))
    pp.plot(testCases,executionTimes)
    pp.xlabel("Number of Elements Sorted")
    pp.ylabel("Minutes to Execute")
    pp.show()

main()
