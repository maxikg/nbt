package de.maxikg.nbt;

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
    protected void doWriteByte(byte b) throws IOException {
        outputStream.writeByte(b);
    }

    @Override
    protected void doWriteShort(short s) throws IOException {
        outputStream.writeShort(s);
    }

    @Override
    protected void doWriteInt(int i) throws IOException {
        outputStream.writeInt(i);
    }

    @Override
    protected void doWriteLong(long l) throws IOException {
        outputStream.writeLong(l);
    }

    @Override
    protected void doWriteFloat(float f) throws IOException {
        outputStream.writeFloat(f);
    }

    @Override
    protected void doWriteDouble(double d) throws IOException {
        outputStream.writeDouble(d);
    }

    @Override
    protected void doWriteString(String str) throws IOException {
        outputStream.writeUTF(str);
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}
