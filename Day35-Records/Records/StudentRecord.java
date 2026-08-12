// ---- Exercise 5: the record version of Day 27's Student class ----
// Compare this ONE line to Day 27's Student.java, which needed a manual
// constructor, getters, equals(), hashCode(), and toString().
public record StudentRecord(String name, int age) {
    // Note: there's no setAge() possible here - records have NO setters.
    // Day 27's original Student class also didn't have one, but COULD have
    // added one if it wanted mutable fields. A record can NEVER do that -
    // it's immutable by design, with no way to opt out.
}
