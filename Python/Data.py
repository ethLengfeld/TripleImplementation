from DataEvent import DataEvent
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
    print(jsonLoaded)

    print("Getting all events from \""+jsonLoaded["metadata"]["title"]+"\"")

    event_list = []
    count = 0
    for currObj in jsonLoaded["features"]:
        place = currObj["properties"]["place"]
        coords = currObj["geometry"]["coordinates"]
        lat_n = coords[1]
        long_w = coords[0]
        event = DataEvent(place, lat_n, long_w)
        event_list.append(event)

    print("There are " + str(len(event_list)) + " events is this data")
    for curr_event in event_list:
        curr_event.list_event_details()
    print("Completed procedure <parseData>")


if __name__ == "__main__":
    main()