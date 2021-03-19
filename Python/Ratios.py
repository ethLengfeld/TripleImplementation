from decimal import *

def main():
    selections = ["QUIT","Incurred Losses","Loss Ratio","Expense Ratio",
                  "Combined Ratio","Net Investment Income",
                  "Investment Income Ratio","Overall Operating Ratio"]
    selection = -1
    run_prev = False
    reuse = 'N'
    paid_losses=loss_reserves=investment_income=investment_expenses=0
    earned_premium=written_premium=incurred_underwriting_expenses=0
    incurred_losses=loss_ratio=expense_ratio=combined_ratio=0
    net_investment_income=investment_income_ratio=0
    
    # set decimal precision
    getcontext().prec = 3

    print("Welcome to the Ratio calculator!")

    while selection != 0:
        print("Please enter what you would like to calculate:")
        print("1 - "+selections[1]+"\n" +
            "2 - "+selections[2]+"\n" + 
            "3 - "+selections[3]+"\n" +
            "4 - "+selections[4]+"\n" +
            "5 - "+selections[5]+"\n" +
            "6 - "+selections[6]+"\n" +
            "7 - "+selections[7]+"\n" +
            "0 - "+selections[0])
        selection = input(": ")

        if selection < 1 or selection > 7:
            if not selection:
                print("You have quit.")
            else:
                print("Bad selection. You have quit.")
            break

        # ran previsouly, ability to reuse entered data
        if run_prev:
            reuse = raw_input("Would you like to reuse previously entered data?(Y/N) ")

        # based on selection we must gather the necessary data to compute
        calculationFlows = [ [1], [1,2], [3], [1,2,3,4], [5], [5,6], [1,2,3,4,5,6,7] ]
        flow = calculationFlows[selection-1]

        print("\n")

        # go through every step in the flow for the selection
        for element in flow:

            # Incurred Losses
            if element == 1:
                print("Calculating " + selections[element].upper())
                if reuse != "Y" or not paid_losses or not loss_reserves:
                    paid_losses = Decimal(input("Enter paid losses: "))
                    loss_reserves = Decimal(input("Enter loss reserves: "))
                incurred_losses = Decimal(paid_losses+loss_reserves)
                str = selections[element]+"({}) =  Paid Losses({})  +  Loss Reserves({})".format(incurred_losses,paid_losses,loss_reserves)
                print(str+"\n\n//---------------------------------------\\\\\n")


            # Loss Ratio
            elif element == 2:
                print("Calculating " + selections[element].upper())
                if reuse != 'Y' or not earned_premium:
                    earned_premium = Decimal(input("Enter Earned Premium: "))
                loss_ratio = Decimal(incurred_losses / earned_premium)
                str = selections[element]+"({}) =  Incurred Losses({})  /  Earned Premium({})".format(loss_ratio,incurred_losses,earned_premium)
                print(str+"\n\n//---------------------------------------\\\\\n")


            # Expense Ratio
            elif element == 3:
                print("Calculating " + selections[element].upper())
                if reuse != 'Y' or not written_premium or not incurred_underwriting_expenses:
                    written_premium = Decimal(input("Enter Written Premium: "))
                    incurred_underwriting_expenses = Decimal(input("Enter Incurred Underwriting Expenses: "))
                expense_ratio = Decimal(incurred_underwriting_expenses/written_premium)
                str = selections[element]+"({}) =  Incurred Underwriting Expenses({})  /  Written Premium({})".format(expense_ratio,incurred_underwriting_expenses,written_premium)
                print(str+"\n\n//---------------------------------------\\\\\n")


            # Combined Ratio
            elif element == 4:
                print("Calculating " + selections[element].upper())
                combined_ratio = Decimal(loss_ratio+expense_ratio)
                str = selections[element]+"({}) =  Loss Ratio({})  +  Expense Ratio({})".format(combined_ratio,loss_ratio,expense_ratio)
                print(str+"\n\n//---------------------------------------\\\\\n")


            # Net Investment Income
            elif element == 5:
                print("Calculating " + selections[element].upper())
                if reuse != 'Y' or not investment_income or not investment_expenses:
                    investment_income = Decimal(input("Enter Investment Income: "))
                    investment_expenses = Decimal(input("Enter Investment Expenses: "))
                net_investment_income = Decimal(investment_income-investment_expenses)
                str = selections[element]+"({}) =  Investment Income({})  -  Investment Expenses({})".format(net_investment_income,investment_income,investment_expenses)
                print(str+"\n\n//---------------------------------------\\\\\n")


            # Investment Income Ratio
            elif element == 6:
                print("Calculating " + selections[element].upper())
                if not earned_premium or reuse != 'Y' or not earned_premium:
                    earned_premium = Decimal(input("Enter Earned Premium: "))
                investment_income_ratio = Decimal(net_investment_income/earned_premium)
                str = selections[element]+"({}) =  Net Investment Income({})  /  Earned Premium({})".format(investment_income_ratio,net_investment_income,earned_premium)
                print(str+"\n\n//---------------------------------------\\\\\n")


            # Overall Operating Ratio
            elif element == 7:
                print("Calculating " + selections[element].upper())
                overall_operation_ratio = Decimal(combined_ratio-investment_income_ratio)
                str = selections[element]+"({}) =  Combined Ratio({})  -  Investment Income Ratio({})".format(overall_operation_ratio,combined_ratio,investment_income_ratio)
                print(str+"\n\n//---------------------------------------\\\\\n")


        run_prev = True
        print("\n")

if __name__ == "__main__":
    main()