import csv;

def main():
    parse_CSV_file()

def parse_CSV_file():
    with open(r'C:\Users\e_len\Downloads\event_finance_customer_order_line_items.csv') as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        count = 0;
        for row in csv_reader:
            if count == 0:
                print(f'Columns are {",".join(row)}')
                count += 1
            else:
                break
                # print(f'row:{",".join(row)}')
                # count += 1
        print(f'Num rows processed in csv: {count}')

if __name__ == "__main__":
    main()