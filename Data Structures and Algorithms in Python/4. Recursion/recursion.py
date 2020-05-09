# 4.1.1 factorial function
def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)
#print(factorial(10))

#4.1.2 English ruler

def draw_line(tick_length, tick_label = ''):
    #draw one line with given tick length ( folowed by optional label)
    
    line = '-' * tick_length
    if tick_label:
        line += ' ' + tick_label
    print(line)
    
def draw_interval(center_length):
    #draw tick interval based upon a central tick length
    if center_length > 0:                 #stops when lengths drops to 0
        draw_interval(center_length - 1)  #recursively draw top ticks
        draw_line(center_length)          #draw the center tick
        draw_interval(center_length - 1)  #recursively draw bottom ticks
            
def draw_ruler(num_inches, major_length):
    # draw English ruler with given number of inches, major tick length
    draw_line(major_length, '0')          # draw inch 0 line
    for j in range(1, 1 + num_inches):
        draw_interval(major_length - 1)   #draw interior ticks for inch
        draw_line(major_length, str(j))   # draw inch j line and label
            
#draw_ruler(1, 3)

# binary search

def binary_search(data, target, low, high):
    #return true if target is found in indicated python list
    # the search only considers the portion from data[low] to data[high] inclusive
    
    if low > high:
        return False
    else:
        mid = (low + high)//2
        if target == data[mid]:
            return True
        elif target < data[mid]:
            return binary_search(data, target, low, mid - 1)
        else:
            return binary_search(data, target, mid + 1, high)