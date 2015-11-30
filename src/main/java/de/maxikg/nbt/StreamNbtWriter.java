package de.maxikg.nbt;

import de.maxikg.nbt.utils.Throwables;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StreamNbtWriter extends AbstractNbtWriter implements Closeable {

    private final DataOutputStream outputStream;

    public StreamNbtWriter(OutputStream outputStream) {
        this.outputStream = new DataOutputStream(outputStream);
    }

    @Override
    public NbtWriter writeType(NbtType type) {
        try {
            outputStream.writeByte(type.getId());
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return this;
    }

    @Override
    public NbtWriter writeEnd() {
        writeType(NbtType.TAG_END);
        return this;
    }

    @Override
    public NbtWriter writeName(String name) {
        try {
            outputStream.writeUTF(name);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return this;
    }

    @Override
    public NbtWriter writeByte(byte b) {
        try {
            outputStream.writeByte(b);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return this;
    }

    @Override
    public NbtWriter writeShort(short s) {
        try {
            outputStream.writeShort(s);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return this;
    }

    @Override
    public NbtWriter writeInt(int i) {
        try {
            outputStream.writeInt(i);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return this;
    }

    @Override
    public NbtWriter writeLong(long l) {
        try {
            outputStream.writeLong(l);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return this;
    }

    @Override
    public NbtWriter writeFloat(float f) {
        try {
            outputStream.writeFloat(f);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return this;
    }

    @Override
    public NbtWriter writeDouble(double d) {
        try {
            outputStream.writeDouble(d);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return this;
    }

    @Override
    public NbtWriter writeByteArray(byte[] bytes) {
        try {
            outputStream.writeInt(bytes.length);
            for (byte b : bytes)
                outputStream.writeByte(b);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return this;
    }

    @Override
    public NbtWriter writeString(String str) {
        try {
            outputStream.writeUTF(str);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return this;
    }

    @Override
    public NbtWriter writeListStart(NbtType type, int length) {
        try {
            outputStream.writeByte(type.getId());
            outputStream.writeInt(length);
            // ToDo: State = list & list count setzen
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return this;
    }

    @Override
    public NbtWriter writeCompound() {
        writeType(NbtType.TAG_COMPOUND);
        return this;
    }

    @Override
    public NbtWriter writeIntArray(int[] ints) {
        try {
            outputStream.writeInt(ints.length);
            for (int i : ints)
                outputStream.writeInt(i);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return this;
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}
