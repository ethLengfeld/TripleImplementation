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

def main():
    props = config('database.ini', 'postgresql')
    print("props:"+str(props))
    # create_table(props)
    parse_CSV_file_and_upload(props)


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


def create_table(props):
    print("Started <create_table> function")
    conn = None
    try:
        conn = psycopg2.connect(**props)

        print(CREATE_TABLE)
        # TODO 
        cursor = conn.cursor()
        cursor.execute(CREATE_TABLE)
        # count = cursor.fetchone()
        # print(str(count[0]))

        cursor.close()
    except Exception as error:
        print('Error: '+str(error))

    print("Completed <create_table> function")


def parse_CSV_file_and_upload(props):
    print("Started <parse_CSV_file_and_upload> function")
    conn = psycopg2.connect(**props)
    cursor = conn.cursor()
    with open("insert_statements.txt", "w") as f:
        with open(r'C:\Users\e_len\Downloads\event_finance_customer_order_line_items.csv') as csv_file:
            csv_reader = csv.reader(csv_file, delimiter=',')
            count = 0;
            for row in csv_reader:
                if count == 0:
                    print(f'Columns are {",".join(row)}')
                    count += 1
                else:
                    insert_data = """INSERT INTO event_finance_customer_order_line_items(id,customer_order_id,event_id, event_type, line_item_id) VALUES ('{}','{}',{},'{}','{}');"""
                    query = insert_data.format(row[0],row[1],row[2],row[3],row[4])
                    cursor.execute(query)
                    f.write(query+"\n")
                    count += 1

        print(f'Num rows processed in csv: {count}')
    cursor.close()
    print("Completed <parse_CSV_file_and_upload> function")


if __name__ == "__main__":
    main()
