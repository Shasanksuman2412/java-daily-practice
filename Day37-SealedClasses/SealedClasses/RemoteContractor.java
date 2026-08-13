// Contractor is non-sealed, so RemoteContractor can extend it freely,
// with NO requirement to declare final/sealed/non-sealed itself.
public class RemoteContractor extends Contractor {
    @Override
    String role() {
        return "Remote Contractor";
    }
}
