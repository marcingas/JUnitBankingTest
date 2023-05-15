package pl.marcin.challenge;

public class Utilities {
    //reurns a char array containing every n-th char.
    //when sourceArr.lenght < n, returns sourceArr
    public char[] everyNthChar(char[] sourceArr, int n) {
        if (sourceArr == null || sourceArr.length < n) {
            return sourceArr;
        }
        int returnedLength = sourceArr.length / n;
        char[] result = new char[returnedLength];
        int index = 0;
        for (int i = n - 1; i < sourceArr.length; i += n) {
            result[index++] = sourceArr[i];
        }
        return result;
    }

    //removes pairs of the same character that are next to each other
    //by removing one occurance of character
    public String removePairs(String source) {
        if (source == null || source.length() < 2) {
            return source;
        }
        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();
        for (int i = 0; i < string.length - 1; i++) {
            if (string[i] != string[i+1]) {
                sb.append(string[i]);
            }
        }
        sb.append(string[string.length -1]);
        return sb.toString();
    }

    public int converter(int a, int b) {
        return (a / b) + a * 30 - 2;
    }
    public String nullOddLength(String source){
        if (source.length() % 2 == 0){
            return source;
        }
        return null;
    }
}

