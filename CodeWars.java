import java.util.Arrays;

class ReverseSpecial {

    private String inputString;
    private String outputString;

    public ReverseSpecial(String inputString) {
        this.inputString = inputString;
    }

    public String getOutputString(){
        return this.outputString;
    }

    private boolean isLatin(char symbol) {
        return symbol >= 65 && symbol <= 90 || symbol >= 97 && symbol <= 122;
    }

    public void reverse() {
        String[] arrInputString = inputString.split(" ");
        char[] reverseArray = new char[inputString.length()];
        Arrays.fill(reverseArray, ' ');
        int shift = 0;

        for (String everyString: arrInputString) {

            char[] inputSymbols = everyString.toCharArray();
            int LastLatinIndex = inputSymbols.length - 1;
            for (int i=0; i<inputSymbols.length; i++) {
                if (!isLatin(inputSymbols[i])) {
                    reverseArray[shift + i] = inputSymbols[i];
                } else {
                    while (!isLatin(inputSymbols[LastLatinIndex]) || reverseArray[shift + LastLatinIndex] != 32) {
                        LastLatinIndex--;
                    }
                    reverseArray[shift + LastLatinIndex] = inputSymbols[i];
                }
            }
            shift += inputSymbols.length + 1;
        }
        outputString = new String(reverseArray);
    }
}

class CodeWars {
    public static void main(String[] args) {
        ReverseSpecial rc = new ReverseSpecial("satis44c55on h3le4 r444 3333r55d");
        rc.reverse();
        System.out.println(rc.getOutputString());
    }
}