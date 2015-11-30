package de.maxikg.nbt;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamNbtReader extends AbstractNbtReader implements Closeable {

    private final DataInputStream inputStream;

    public StreamNbtReader(InputStream inputStream) {
        this.inputStream = new DataInputStream(inputStream);
    }

    @Override
    protected byte doReadByte() throws Throwable {
        return inputStream.readByte();
    }

    @Override
    protected short doReadShort() throws Throwable {
        return inputStream.readShort();
    }

    @Override
    protected int doReadInt() throws Throwable {
        return inputStream.readInt();
    }

    @Override
    protected long doReadLong() throws Throwable {
        return inputStream.readLong();
    }

    @Override
    protected float doReadFloat() throws Throwable {
        return inputStream.readFloat();
    }

    @Override
    protected double doReadDouble() throws Throwable {
        return inputStream.readDouble();
    }

    @Override
    protected String doReadString() throws Throwable {
        return inputStream.readUTF();
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}
