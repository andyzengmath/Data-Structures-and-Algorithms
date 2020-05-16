# Stack

class Empty(Exception):
    # Error attempting to access an element from an empty container
    pass

class ArrayStack:
    # LIFO stack implementation using a Python list as underlying storage
    