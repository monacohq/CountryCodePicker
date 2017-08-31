import os
import json

with open('./../country.json') as data_file:    
    data = json.load(data_file)

for fileName in os.listdir("."):
    f = fileName.split(".")[0].lower()
    for i in data:
        if f == i["name"].lower().replace(" ", "_"):
            print(fileName)
            os.rename(fileName, i["code"].lower()+".png")
