class Solution {

    public double myPow(double x, int n) {
        long exponent = n;

        // Negative power: x^(-n) = 1 / x^n
        if (exponent < 0) {
            x = 1 / x;
            exponent = -exponent;
        }

        return fastPower(x, exponent);
    }

    private double fastPower(double base, long exponent) {
        if (exponent == 0) {
            return 1.0;
        }

        double half = fastPower(base, exponent / 2);

        if (exponent % 2 == 0) {
            return half * half;
        }

        return half * half * base;
    }
}