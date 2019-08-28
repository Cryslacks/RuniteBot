import java.io.SyncFailedException;
import java.io.EOFException;
import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;

// 
// Decompiled by Procyon v0.5.36
// 

public final class FileOnDisk
{
    RandomAccessFile file;
    long length;
    long position;
    
    public FileOnDisk(final File file_0, final String string_0, long long_0) throws IOException {
        if (long_0 == -1L) {
            long_0 = Long.MAX_VALUE;
        }
        if (file_0.length() >= long_0) {
            file_0.delete();
        }
        this.file = new RandomAccessFile(file_0, string_0);
        this.length = long_0;
        this.position = 0L;
        final int int_0 = this.file.read();
        if (int_0 != -1 && !string_0.equals("r")) {
            this.file.seek(0L);
            this.file.write(int_0);
        }
        this.file.seek(0L);
    }
    
    void seek(final long long_0) throws IOException {
        this.file.seek(long_0);
        this.position = long_0;
    }
    
    public void write(final byte[] bytes_0, final int int_0, final int int_1) throws IOException {
        if (int_1 + this.position > this.length) {
            this.file.seek(1L + this.length);
            this.file.write(1);
            throw new EOFException();
        }
        this.file.write(bytes_0, int_0, int_1);
        this.position += int_1;
    }
    
    public void close() throws IOException {
        this.closeSync(false);
    }
    
    public void closeSync(final boolean bool_0) throws IOException {
        if (this.file != null) {
            if (bool_0) {
                try {
                    this.file.getFD().sync();
                }
                catch (SyncFailedException ex) {}
            }
            this.file.close();
            this.file = null;
        }
    }
    
    public long length() throws IOException {
        return this.file.length();
    }
    
    public int read(final byte[] bytes_0, final int int_0, final int int_1) throws IOException {
        final int int_2 = this.file.read(bytes_0, int_0, int_1);
        if (int_2 > 0) {
            this.position += int_2;
        }
        return int_2;
    }
    
    @Override
    protected void finalize() throws Throwable {
        if (this.file != null) {
            System.out.println();
            this.close();
        }
    }
    
    public static ObjectComposition getObjectDefinition(final int int_0) { //getObject thingy int_0	6164	

        ObjectComposition objectcomposition_0 = (ObjectComposition)ObjectComposition.objects.get(int_0);
        if (objectcomposition_0 != null) {
            return objectcomposition_0;
        }
        final byte[] bytes_0 = ObjectComposition.objects_ref.getConfigData(6, int_0);
        objectcomposition_0 = new ObjectComposition();
        objectcomposition_0.id = int_0;
        if (bytes_0 != null) {
            objectcomposition_0.decode(new Buffer(bytes_0));
        }
        objectcomposition_0.postDecode();
        objectcomposition_0.post();
        if (objectcomposition_0.isHollow) {
            objectcomposition_0.clipType = 0;
            objectcomposition_0.blocksProjectile = false;
        }
        ObjectComposition.objects.put(objectcomposition_0, int_0);
        return objectcomposition_0;
    }
    
    static Class loadClassFromDescriptor(final String string_0) throws ClassNotFoundException {
        return string_0.equals("B") ? Byte.TYPE : (string_0.equals("I") ? Integer.TYPE : (string_0.equals("S") ? Short.TYPE : (string_0.equals("J") ? Long.TYPE : (string_0.equals("Z") ? Boolean.TYPE : (string_0.equals("F") ? Float.TYPE : (string_0.equals("D") ? Double.TYPE : (string_0.equals("C") ? Character.TYPE : (string_0.equals("void") ? Void.TYPE : Class.forName(string_0)))))))));
    }
    
    static int method2511(final int int_0, final int int_1) {
        int int_2 = int_0 + int_1 * 57;
        int_2 ^= int_2 << 13;
        final int int_3 = (int_2 * int_2 * 15731 + 789221) * int_2 + 1376312589 & Integer.MAX_VALUE;
        return int_3 >> 19 & 0xFF;
    }
}
