import random, time, sys, matplotlib.pyplot as pp
sys.setrecursionlimit(15000)

def populateList(size): ## Generate a List of Size N with Random Values Ranging from 0-N
    list = []
    for x in range(1,size+1):
        list.append(x)
    for y in range (0,7): ##Shuffle List Seven Times Based on Principles of Randomization
        random.shuffle(list)
    return list

def quickSort (list,pivotPos,max): ## Performs Quicksort on Array
    if pivotPos!=max:
        i = pivotPos #set border = pivot
        for x in range (pivotPos+1, max):
            if list[x] <= list[pivotPos]: #check elements against pivot
                i+=1 #if element is < pivot, increment border
                if i!= x:
                    list[x],list[i] = list[i],list[x] #swap element with border
        if i > pivotPos:
            list[pivotPos],list[i] = list[i],list[pivotPos] #swap border with last pivot
        if i < max and i < len(list)+1:
            quickSort(list,pivotPos,i)
            quickSort(list, i+1, max)
    return(list)

def checkSort (list): ## Verification Method to Confirm List is Sorted
    #print(list)
    for x in range(0,len(list)-2):
        if list[x] > list[x+1]:
            # print(list)
            return '----------- Error -----------'
        else:
            return ('----------- %d Elements Sorted -----------' % len(list))

def main():
    testCases = [10000,20000,50000,100000,1000000,2000000]
    executionTimes = []
    for x in range(0,len(testCases)):
        arr = populateList(testCases[x])
        quickstart = time.time()
        sorted = quickSort(arr,0,len(arr))
        quickstop = round((time.time() - quickstart)/60,3)
        executionTimes.append(quickstop)
        print("--- %s Minutes to Execute When Sorting %d Elements---" % (quickstop,testCases[x]))
        print(checkSort(sorted))
    pp.plot(testCases,executionTimes)
    pp.xlabel("Number of Elements Sorted")
    pp.ylabel("Minutes to Execute")
    pp.show()
    print("\n")

main()
