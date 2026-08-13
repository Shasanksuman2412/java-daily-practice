public sealed interface PaymentMethod permits CreditCard, Cash, Crypto {
}

record CreditCard(String cardNumber, String provider) implements PaymentMethod {
}

record Cash(double amount) implements PaymentMethod {
}

record Crypto(String walletAddress, String coinType) implements PaymentMethod {
}
