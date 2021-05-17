import urllib.request
import json

def main():
    print("Hello! Let's parse some data")
    #json = "{ \"key\":\"value\" }"
    jsonData = returnData()
    if jsonData is None:
        print("jsonData doesn't exist, exiting")
        pass

    parseData(jsonData)

    print("Completed method <main>")


def returnData():
    print("Started procedure <returnData>")
    urlData = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_day.geojson"
    
    webUrl = urllib.request.urlopen(urlData)
    if(webUrl.getcode() == 200):
        jsonData = webUrl.read()
        print("Read JSON from "+urlData)
    else:
        print("Unable to retrieve data")
        return None
                
    print("Completed procedure <returnData>")

    return jsonData

def parseData(jsonData):
    print("Started procedure <parseData>")
    jsonLoaded = json.loads(jsonData)

    print("Printing all events from \""+jsonLoaded["metadata"]["title"]+"\"")

    count = 1
    for currObj in jsonLoaded["features"]:
        print("Event Number: "+str(count)+", Place: "+currObj["properties"]["place"])
        count += 1

    print("Completed procedure <parseData>")


if __name__ == "__main__":
    main()