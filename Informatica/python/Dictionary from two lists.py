def create_dict(keys, values):
    
    dictionary={}
    
    
    
    for x in range(len(keys)):
        if x<len(values):
            dictionary[keys[x]]=values[x]
        else:
            dictionary[keys[x]]= None
    
    return dictionary
        