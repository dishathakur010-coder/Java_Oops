import java.time.LocalDate;

public class CheckoutService {

    private AssetStore store;
    private Student[] students;

    public CheckoutService(AssetStore store, Student[] students) {
        this.store = store;
        this.students = students;
    }

    private Student findStudent(String uid) {

        for (Student s : students) {
            if (s.uid.equals(uid)) {
                return s;
            }
        }

        throw new NullPointerException("Student not found: " + uid);
    }

    public String checkout(CheckoutRequest req)
            throws IllegalArgumentException,
                   IllegalStateException,
                   SecurityException,
                   NullPointerException {

        ValidationUtil.validateUid(req.uid);
        ValidationUtil.validateAssetId(req.assetId);
        ValidationUtil.validateHours(req.hoursRequested);

        Student student = findStudent(req.uid);
        Asset asset = store.findAsset(req.assetId);

        student.validatePolicy();
        asset.validatePolicy(req.uid);



        if (req.hoursRequested == 6) {
            System.out.println("Note: Max duration selected. Return strictly on time.");
        }

        if (asset.assetName.contains("Cable") && req.hoursRequested > 3) {
            req.hoursRequested = 3;
            System.out.println("Policy applied: Cables can be issued max 3 hours. Updated to 3.");
        }


        store.markBorrowed(asset);
        student.incrementBorrow();

        return "TXN-" +
                LocalDate.now().toString().replace("-", "") +
                "-" + asset.assetId +
                "-" + req.uid;
    }
}
