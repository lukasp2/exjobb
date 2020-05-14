import java.nio.ByteBuffer;
import java.util.UUID;

public class UuidAdapter {
    public static byte[] getBytesFromUUID(String uuid) {
        return getBytesFromUUID(UUID.fromString(uuid));
    }

    public static byte[] getBytesFromUUID(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());

        return bb.array();
    }

    public static UUID getUUIDFromBytes(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        Long high = byteBuffer.getLong();
        Long low = byteBuffer.getLong();

        return new UUID(high, low);
    }

    public static byte[][] getArrayBytesFromUUID(UUID[] uuid) {
        byte[][] array = new byte[uuid.length][16];
        for (int i = 0; i < uuid.length; i++) {
            array[i] = UuidAdapter.getBytesFromUUID(uuid[i]);
        }
        return array;
    }

    public static UUID[] getArrayUUIDFromBytes(byte[][] bytes) {
        UUID[] array = new UUID[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            array[i] = UuidAdapter.getUUIDFromBytes(bytes[i]);
        }
        return array;
    }

    public static UUID getUUIDFromInt(int id) {
        String uuidFormat = "00000000-0000-0000-0000-000000000000";
        uuidFormat = uuidFormat.substring(0, uuidFormat.length() - String.valueOf(id).length());
        uuidFormat = uuidFormat + id;

        return UUID.fromString(uuidFormat);
    }
}
