package ru.concerteza.util.db.blob;

import org.apache.commons.lang.UnhandledException;
import ru.concerteza.util.db.blob.compress.Compressor;

import java.io.*;

/**
* User: alexey
* Date: 8/19/11
*/
public class DetachedBlob extends AbstractBlob implements Serializable {
    private static final long serialVersionUID = 5752953727569147166L;
    private final byte[] compressedData;
    private final Compressor compressor;

    public DetachedBlob(long id, byte[] compressedData, Compressor compressor) {
        super(id);
        this.compressedData = compressedData;
        this.compressor = compressor;
    }

    public InputStream getInputStream() {
        try {
            InputStream bais = new ByteArrayInputStream(compressedData);
            return compressor.wrapDecompress(bais);
        } catch (IOException e) {
            throw new UnhandledException(e);
        }
    }

    @Override
    public void close() throws IOException {
        // this method is intentionally left blank
    }
}