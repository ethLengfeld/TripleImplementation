# Junior Data Engineer Challenge
# Ethan Lengfeld

import csv
from configparser import ConfigParser
import psycopg2

CREATE_TABLE = """CREATE TABLE event_finance_customer_order_line_items (
        id     character varying,
        customer_order_id     character varying,
        event_id   integer,
        event_type  character(255),
        line_item_id    character varying(128),
        deleted_at  timestamp without time zone,
        created_at     timestamp without time zone,
        updated_at     timestamp without time zone
    );"""

# main function to get db properties,
# then create table, and finally insert
def main():
    props = config('database.ini', 'postgresql')
    print("props:"+str(props))
    create_table(props)
    parse_CSV_file_and_upload(props)

# read postgresql configuration from database.ini
def config(filename, section):
    print("Started <config> function")
    parser = ConfigParser()
    parser.read(filename)

    props={}
    if parser.has_section(section):
        params = parser.items(section)
        for curr_param in params:
            props[curr_param[0]] = curr_param[1];
    print("Completed <config> function")
    return props

# execute created table statement
def create_table(props, statement=CREATE_TABLE):
    print("Started <create_table> function")
    conn = None
    count = 0
    try:
        conn = psycopg2.connect(**props)
        # defined above
        print(statement)
        cursor = conn.cursor()
        # cursor.execute(statement)
        # count = cursor.fetchone()
        cursor.close()
    except Exception as error:
        print('Error: '+str(error))

    print("Completed <create_table> function")

    return count

# Parse the csv file and upload to table
def parse_CSV_file_and_upload(props):
    print("Started <parse_CSV_file_and_upload> function")
    conn = psycopg2.connect(**props)
    cursor = conn.cursor()
    # open file to write and save off created statements
    with open("insert_statements.txt", "w") as f:
        with open('event_finance_customer_order_line_items.csv',"r") as csv_file:
            csv_reader = csv.reader(csv_file, delimiter=',')
            count = 0;
            for row in csv_reader:
                # read header row
                if count == 0:
                    print(f'Columns are {",".join(row)}')
                else:
                    # get insert into statment
                    statement = get_insert_into_query(row)
                    # cursor.execute(statement)
                    # write to file so we have record of statements
                    f.write(statement+"\n")
                count += 1
        print(f'Num rows processed in csv: {count}')
    cursor.close()
    f.close()
    print("Completed <parse_CSV_file_and_upload> function")

# Get the insert into statement with row values injected
def get_insert_into_query(row):
    if len(row) < 5:
        return None
    insert_data = """INSERT INTO event_finance_customer_order_line_items(id,customer_order_id,event_id, event_type, line_item_id) VALUES ('{}','{}',{},'{}','{}');"""
    
    statement = insert_data.format(row[0],row[1],row[2],row[3],row[4])
    return statement

if __name__ == "__main__":
    main()