package de.maxikg.nbt;

import de.maxikg.nbt.utils.Throwables;

public abstract class AbstractNbtWriter implements NbtWriter {

    @Override
    public NbtWriter writeType(NbtType type) {
        try {
            doWriteByte(type.getId());
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
        return this;
    }

    @Override
    public NbtWriter writeEnd() {
        return writeType(NbtType.TAG_END);
    }

    @Override
    public NbtWriter writeName(String name) {
        try {
            doWriteString(name);
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
        return this;
    }

    @Override
    public NbtWriter writeByte(String name, byte b) {
        writeType(NbtType.TAG_BYTE);
        writeName(name);
        writeByte(b);
        return this;
    }

    @Override
    public NbtWriter writeByte(byte b) {
        try {
            doWriteByte(b);
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
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
    public NbtWriter writeShort(short s) {
        try {
            doWriteShort(s);
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
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
    public NbtWriter writeInt(int i) {
        try {
            doWriteInt(i);
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
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
    public NbtWriter writeLong(long l) {
        try {
            doWriteLong(l);
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
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
    public NbtWriter writeFloat(float f) {
        try {
            doWriteFloat(f);
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
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
    public NbtWriter writeDouble(double d) {
        try {
            doWriteDouble(d);
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
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
    public NbtWriter writeByteArray(byte[] bytes) {
        try {
            doWriteInt(bytes.length);
            for (byte b : bytes)
                doWriteByte(b);
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
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
    public NbtWriter writeString(String str) {
        try {
            doWriteString(str);
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
        return this;
    }

    @Override
    public NbtWriter writeLength(int length) {
        try {
            doWriteInt(length);
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
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
    public NbtWriter writeListStart(NbtType type, int length) {
        writeType(type);
        writeLength(length);
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
    public NbtWriter writeCompound() {
        return writeType(NbtType.TAG_COMPOUND);
    }

    @Override
    public NbtWriter writeIntArray(String name, int[] ints) {
        writeType(NbtType.TAG_INT_ARRAY);
        writeName(name);
        writeIntArray(ints);
        return this;
    }

    @Override
    public NbtWriter writeIntArray(int[] ints) {
        try {
            doWriteInt(ints.length);
            for (int anInt : ints)
                doWriteInt(anInt);
        } catch (Throwable throwable) {
            throw Throwables.propagate(throwable);
        }
        return this;
    }

    protected abstract void doWriteByte(byte b) throws Throwable;

    protected abstract void doWriteShort(short s) throws Throwable;

    protected abstract void doWriteInt(int i) throws Throwable;

    protected abstract void doWriteLong(long l) throws Throwable;

    protected abstract void doWriteFloat(float f) throws Throwable;

    protected abstract void doWriteDouble(double d) throws Throwable;

    protected abstract void doWriteString(String str) throws Throwable;
}
