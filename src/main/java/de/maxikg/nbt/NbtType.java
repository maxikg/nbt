package de.maxikg.nbt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum NbtType {

    TAG_END((byte) 0),
    TAG_BYTE((byte) 1),
    TAG_SHORT((byte) 2),
    TAG_INT((byte) 3),
    TAG_LONG((byte) 4),
    TAG_FLOAT((byte) 5),
    TAG_DOUBLE((byte) 6),
    TAG_BYTE_ARRAY((byte) 7),
    TAG_STRING((byte) 8),
    TAG_LIST((byte) 9),
    TAG_COMPOUND((byte) 10),
    TAG_INT_ARRAY((byte) 11);

    private static final Map<Byte, NbtType> ID_MAPPING;

    static {
        NbtType[] values = values();
        Map<Byte, NbtType> types = new HashMap<>(values.length);
        Arrays.stream(values).forEach((value) -> types.put(value.getId(), value));
        ID_MAPPING = Collections.unmodifiableMap(types);
    }

    private final byte id;

    public static NbtType byId(byte id) {
        NbtType type = ID_MAPPING.get(id);
        if (type == null)
            throw new IllegalArgumentException("Invalid id: " + id);
        return type;
    }
}
