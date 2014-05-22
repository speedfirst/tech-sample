package org.speedfirst.test;


import org.junit.Test;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImageIOTest {

    @Test
    public void testImageIO() throws IOException {

        // for png format
        InputStream is = this.getClass().getResourceAsStream("imageio-test.png");
        ImageInputStream iis = ImageIO.createImageInputStream(is);
        Iterator<ImageReader> iir = ImageIO.getImageReaders(iis);
        assertTrue(iir.hasNext());

        ImageReader reader = iir.next();
        reader.setInput(iis, true); // set the reader's source

        assertEquals("com.sun.imageio.plugins.png.PNGImageReader", reader.getClass().getName());
        assertEquals("png", reader.getFormatName());
        assertEquals(400, reader.getHeight(0)); // get height
        assertEquals(300, reader.getWidth(0)); // get width

        // convert reader to buffered image
        BufferedImage bufferedImage = reader.read(0);
        assertEquals(400, bufferedImage.getHeight()); // get height
        assertEquals(300, bufferedImage.getWidth()); // get width
        assertEquals(BufferedImage.TYPE_4BYTE_ABGR, bufferedImage.getType());
        is.close();

        // for jpg format
        is = this.getClass().getResourceAsStream("imageio-test.jpg");
        iis = ImageIO.createImageInputStream(is);
        iir = ImageIO.getImageReaders(iis);
        assertTrue(iir.hasNext());

        reader = iir.next();
        reader.setInput(iis, true); // set the reader's source

        assertEquals("com.sun.imageio.plugins.jpeg.JPEGImageReader", reader.getClass().getName());
        assertEquals("JPEG", reader.getFormatName());

    }
}
