class DataEvent:
    
    # constructor
    def __init__(self, place, lat_n, long_w):
        self.place = place
        self.lat_n = str("{:.4f}".format(lat_n))
        self.long_w = str("{:.4f}".format(long_w))

    def list_event_details(self):
        print("place:" + self.place + ", latitude:" + self.lat_n + ", longitude:" + self.long_w)