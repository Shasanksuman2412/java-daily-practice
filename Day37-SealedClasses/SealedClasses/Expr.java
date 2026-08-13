public sealed interface Expr permits Number, Add, Multiply {
}

record Number(double value) implements Expr {
}

record Add(Expr left, Expr right) implements Expr {
}

record Multiply(Expr left, Expr right) implements Expr {
}
