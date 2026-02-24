public class Main {

    public static void main(String[] args) {

        Student s1 = new Student("KRG20281", "Ravi", 0, 0);
        Student s2 = new Student("ABC12345", "Amit", 100, 0);
        Student s3 = new Student("KRG55555", "Neha", 0, 2);

        Student[] students = {s1, s2, s3};

        AssetStore store = new AssetStore();

        store.addAsset(new Asset("LAB-101", "HDMI Cable", true, 1));
        store.addAsset(new Asset("LAB-202", "VR Headset", true, 3));
        store.addAsset(new Asset("LAB-303", "Ethernet Cable", false, 1));
        store.addAsset(new Asset("LAB-404", "3D Printer", true, 2));

        CheckoutService service = new CheckoutService(store, students);

        CheckoutRequest r1 = new CheckoutRequest("KRG20281", "LAB-101", 5); // Success
        CheckoutRequest r2 = new CheckoutRequest("KRG20281", "LAB-999", 2); // Invalid Asset
        CheckoutRequest r3 = new CheckoutRequest("ABC12345", "LAB-202", 4); // Policy Failure

        CheckoutRequest[] requests = {r1, r2, r3};

        for (CheckoutRequest req : requests) {

            try {

                String receipt = service.checkout(req);
                System.out.println("SUCCESS: " + receipt);

            } catch (IllegalArgumentException e) {

                System.out.println("Invalid Input: " + e.getMessage());
                AuditLogger.logError(e);

            } catch (NullPointerException e) {

                System.out.println("Not Found: " + e.getMessage());
                AuditLogger.logError(e);

            } catch (SecurityException e) {

                System.out.println("Security Issue: " + e.getMessage());
                AuditLogger.logError(e);

            } catch (IllegalStateException e) {

                System.out.println("Policy Violation: " + e.getMessage());
                AuditLogger.logError(e);

            } finally {

                AuditLogger.log("Attempt finished for UID=" + req.uid +
                        ", asset=" + req.assetId);
            }

            System.out.println("----------------------------------------");
        }
    }
}
