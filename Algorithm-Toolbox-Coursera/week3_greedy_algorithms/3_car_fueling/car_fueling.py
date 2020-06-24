# python3
import sys


def compute_min_refills(distance, tank, stops):
    stops.append(distance)
    stops.append(0)
    num_stops = len(stops)
    stops.sort()
    #print(stops)
    num_refill = 0
    current_refill = 0
    
    while current_refill < num_stops:
        last_fill = current_refill
        
        while current_refill <= num_stops -1 and (stops[current_refill+1]-stops[last_fill]) <= tank:
            current_refill = current_refill + 1
            #print(last_fill, current_refill)
        if current_refill == last_fill:
            return -1
        if current_refill <= num_stops:
            num_refill = num_refill + 1
  
    
    return num_refill

if __name__ == '__main__':
    d, m, _, *stops = map(int, sys.stdin.read().split())
    print(compute_min_refills(d, m, stops))
    
