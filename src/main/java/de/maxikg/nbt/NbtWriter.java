package de.maxikg.nbt;

public interface NbtWriter {

    NbtWriter writeType(NbtType type);

    NbtWriter writeEnd();

    NbtWriter writeName(String name);

    NbtWriter writeByte(byte b);

    NbtWriter writeByte(String name, byte b);

    NbtWriter writeShort(short s);

    NbtWriter writeShort(String name, short s);

    NbtWriter writeInt(int i);

    NbtWriter writeInt(String name, int i);

    NbtWriter writeLong(long l);

    NbtWriter writeLong(String name, long l);

    NbtWriter writeFloat(float f);

    NbtWriter writeFloat(String name, float f);

    NbtWriter writeDouble(double d);

    NbtWriter writeDouble(String name, double d);

    NbtWriter writeByteArray(byte[] bytes);

    NbtWriter writeByteArray(String name, byte[] bytes);

    NbtWriter writeString(String str);

    NbtWriter writeString(String name, String value);

    NbtWriter writeLength(int length);

    NbtWriter writeListStart(NbtType type, int length);

    NbtWriter writeListStart(String name, NbtType type, int length);

    NbtWriter writeCompound();

    NbtWriter writeCompound(String name);

    NbtWriter writeIntArray(int[] ints);

    NbtWriter writeIntArray(String name, int[] ints);
}
