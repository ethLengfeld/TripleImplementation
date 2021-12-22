package problems;

public class ConvertToTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder sol = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sol.insert(0, (char) ('A' + (columnNumber % 26)));
            columnNumber /= 26;
        }
        return sol.toString();
    }
}
