package de.maxikg.nbt;

import de.maxikg.nbt.utils.Throwables;

public abstract class AbstractNbtReader implements NbtReader {

    private NbtType currentType;
    private String currentName;
    private int length;

    @Override
    public NbtType getCurrentNbtType() {
        return currentType;
    }

    @Override
    public String getCurrentName() {
        return currentName;
    }

    @Override
    public NbtType readNbtType() {
        try {
            currentType = NbtType.byId(doReadByte());
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
        return currentType;
    }

    @Override
    public String readName() {
        try {
            currentName = doReadString();
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
        return currentName;
    }

    @Override
    public int readLength() {
        try {
            length = doReadInt();
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
        return length;
    }

    @Override
    public int getRemainingLength() {
        return length;
    }

    @Override
    public byte readByte() {
        try {
            return doReadByte();
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
    }

    @Override
    public short readShort() {
        try {
            return doReadShort();
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
    }

    @Override
    public int readInt() {
        try {
            return doReadInt();
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
    }

    @Override
    public long readLong() {
        try {
            return doReadLong();
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
    }

    @Override
    public float readFloat() {
        try {
            return doReadFloat();
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
    }

    @Override
    public double readDouble() {
        try {
            return doReadDouble();
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
    }

    @Override
    public byte[] readByteArray() {
        byte[] data;
        try {
            data = new byte[doReadInt()];
            for (int i = 0; i < data.length; i++)
                data[i] = doReadByte();
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
        return data;
    }

    @Override
    public String readString() {
        try {
            return doReadString();
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
    }

    @Override
    public int[] readIntArray() {
        int[] data;
        try {
            data = new int[doReadInt()];
            for (int i = 0; i < data.length; i++)
                data[i] = doReadInt();
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
        return data;
    }

    protected abstract byte doReadByte() throws Throwable;

    protected abstract short doReadShort() throws Throwable;

    protected abstract int doReadInt() throws Throwable;

    protected abstract long doReadLong() throws Throwable;

    protected abstract float doReadFloat() throws Throwable;

    protected abstract double doReadDouble() throws Throwable;

    protected abstract String doReadString() throws Throwable;
}
