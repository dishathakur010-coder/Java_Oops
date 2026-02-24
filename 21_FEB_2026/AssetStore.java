import java.util.HashMap;

public class AssetStore {

    private HashMap<String, Asset> assetMap = new HashMap<>();

    public void addAsset(Asset asset) {
        assetMap.put(asset.assetId, asset);
    }

    public Asset findAsset(String assetId) {

        Asset asset = assetMap.get(assetId);

        if (asset == null) {
            throw new NullPointerException("Asset not found: " + assetId);
        }

        return asset;
    }

    public void markBorrowed(Asset asset) {

        if (!asset.available) {
            throw new IllegalStateException("Asset already borrowed.");
        }

        asset.available = false;
    }
}
