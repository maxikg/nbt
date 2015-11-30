package de.maxikg.nbt;

public abstract class AbstractNbtWriter implements NbtWriter {

    @Override
    public NbtWriter writeByte(String name, byte b) {
        writeType(NbtType.TAG_BYTE);
        writeName(name);
        writeByte(b);
        return this;
    }

    @Override
    public NbtWriter writeShort(String name, short s) {
        writeType(NbtType.TAG_SHORT);
        writeName(name);
        writeShort(s);
        return this;
    }

    @Override
    public NbtWriter writeInt(String name, int i) {
        writeType(NbtType.TAG_INT);
        writeName(name);
        writeInt(i);
        return this;
    }

    @Override
    public NbtWriter writeLong(String name, long l) {
        writeType(NbtType.TAG_LONG);
        writeName(name);
        writeLong(l);
        return this;
    }

    @Override
    public NbtWriter writeFloat(String name, float f) {
        writeType(NbtType.TAG_FLOAT);
        writeName(name);
        writeFloat(f);
        return this;
    }

    @Override
    public NbtWriter writeDouble(String name, double d) {
        writeType(NbtType.TAG_DOUBLE);
        writeName(name);
        writeDouble(d);
        return this;
    }

    @Override
    public NbtWriter writeByteArray(String name, byte[] bytes) {
        writeType(NbtType.TAG_BYTE_ARRAY);
        writeName(name);
        writeByteArray(bytes);
        return this;
    }

    @Override
    public NbtWriter writeString(String name, String value) {
        writeType(NbtType.TAG_STRING);
        writeName(name);
        writeString(value);
        return this;
    }

    @Override
    public NbtWriter writeListStart(String name, NbtType type, int length) {
        writeType(NbtType.TAG_LIST);
        writeName(name);
        writeListStart(type, length);
        return this;
    }

    @Override
    public NbtWriter writeCompound(String name) {
        writeType(NbtType.TAG_COMPOUND);
        writeName(name);
        writeCompound();
        return this;
    }

    @Override
    public NbtWriter writeIntArray(String name, int[] ints) {
        writeType(NbtType.TAG_INT_ARRAY);
        writeName(name);
        writeIntArray(ints);
        return this;
    }
}
