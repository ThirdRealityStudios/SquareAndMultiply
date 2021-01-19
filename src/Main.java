public class Main {

    public static void main(String[] args) {

        Main m = new Main();

        int base = 3;
        int exponent = 3;

        int result = m.squareAndMultiplay(base, exponent);

        System.out.println("Result is: " + result);
    }

    // This is a variant of the square and multiply algorithm
    // which will also apply the modulo in order not to receive overflows (too large values).
    public int squareAndMultiplay(int base, int exponent)
    {
        int modValue = 5;

        String binaryExponent = Integer.toBinaryString(exponent);

        // Begin always with one (1), according to the rules.
        int result = 1;

        // Note here: in some programming languages binary values are specified with a "0b" to recognize them. I just did this here too.
        System.out.println("Given binary exponent: 0b" + binaryExponent);

        for(char b : binaryExponent.toCharArray())
        {
            if(b == '0')
            {
                result *= base;
            }
            else // In case of one (0b1)
            {
                result *= result * base;

                // You always need to apply the modulo (result = result % modValue)
                // if the binary value is 1 (SM [or in German is QM], meaning Square and Multiply)
                result %= modValue;
            }
        }

        return result;
    }
}
