package de.maxikg.nbt;

import de.maxikg.nbt.utils.Throwables;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamNbtReader implements NbtReader, Closeable {

    private final DataInputStream inputStream;
    private NbtType currentType;
    private String currentName;

    public StreamNbtReader(InputStream inputStream) {
        this.inputStream = new DataInputStream(inputStream);
    }

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
            currentType = NbtType.byId(inputStream.readByte());
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return currentType;
    }

    @Override
    public String readName() {
        try {
            currentName = inputStream.readUTF();
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return currentName;
    }

    @Override
    public byte readByte() {
        try {
            return inputStream.readByte();
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    @Override
    public short readShort() {
        try {
            return inputStream.readShort();
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    @Override
    public int readInt() {
        try {
            return inputStream.readInt();
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    @Override
    public long readLong() {
        try {
            return inputStream.readLong();
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    @Override
    public float readFloat() {
        try {
            return inputStream.readFloat();
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    @Override
    public double readDouble() {
        try {
            return inputStream.readDouble();
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    @Override
    public byte[] readByteArray() {
        byte[] data;
        try {
            data = new byte[inputStream.readInt()];
            //noinspection ResultOfMethodCallIgnored
            inputStream.read(data);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return data;
    }

    @Override
    public String readString() {
        try {
            return inputStream.readUTF();
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    @Override
    public int[] readIntArray() {
        int[] data;
        try {
            data = new int[inputStream.readInt()];
            for (int i = 0; i < data.length; i++)
                data[i] = inputStream.readInt();
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
        return data;
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}
