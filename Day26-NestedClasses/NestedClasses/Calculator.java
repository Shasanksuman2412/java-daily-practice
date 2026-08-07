public class Calculator {

    static class Result {
        int sum;
        int product;

        Result(int sum, int product) {
            this.sum = sum;
            this.product = product;
        }
    }

    static Result calculate(int a, int b) {
        return new Result(a + b, a * b);
    }
}
