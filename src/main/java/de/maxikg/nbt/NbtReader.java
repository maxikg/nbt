package de.maxikg.nbt;

public interface NbtReader {

    NbtType getCurrentNbtType();

    String getCurrentName();

    NbtType readNbtType();

    String readName();

    int readLength();

    int getRemainingLength();

    byte readByte();

    short readShort();

    int readInt();

    long readLong();

    float readFloat();

    double readDouble();

    byte[] readByteArray();

    String readString();

    int[] readIntArray();
}
