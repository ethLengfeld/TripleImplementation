# Junior Data Engineer Challenge
# Ethan Lengfeld

import unittest
import CSVParse

# to run test run <python -m unittest TestCSVParse.py>
class TestCSVParse(unittest.TestCase):

    def test_config(self):
        props = CSVParse.config('database.ini', 'postgresql')
        self.assertEqual(props['host'],'dsa-candidate-challenge-elengfeld.cxoih28cgprt.us-west-2.rds.amazonaws.com')
        self.assertEqual(props['database'],'customer_transactions')
        self.assertEqual(props['user'],'elengfeld')

    def test_get_insert_into_query(self):
        row = ['91738319','dd04aa74-c92f-45af-af81-50cc08139e74',917150,'Popup::PopupEvent','11dd3e1e-67bf-4b40-8ef7-2c9b439bff1f','','32:01.2','32:01.2']
        expected = """INSERT INTO event_finance_customer_order_line_items(id,customer_order_id,event_id, event_type, line_item_id) VALUES ('91738319','dd04aa74-c92f-45af-af81-50cc08139e74',917150,'Popup::PopupEvent','11dd3e1e-67bf-4b40-8ef7-2c9b439bff1f');"""
        actual = CSVParse.get_insert_into_query(row)
        self.assertEqual(actual, expected)

    def test_get_insert_into_query_with_short_row(self):
        row = ['91738319','dd04aa74-c92f-45af-af81-50cc08139e74',917150,'32:01.2']
        actual = CSVParse.get_insert_into_query(row)
        self.assertIsNone(actual)

    # run select query to validate connection to db is working
    def test_create_table(self):
        props = CSVParse.config('database.ini', 'postgresql')
        count = CSVParse.create_table(props, "SELECT COUNT(*) FROM EVENT_FINANCE_CUSTOMER_ORDER_LINE_ITEMS;")
        self.assertEqual(count[0],1991)