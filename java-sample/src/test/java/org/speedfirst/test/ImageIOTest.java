package org.speedfirst.test;


import org.junit.Test;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImageIOTest {

    @Test
    public void testImageIO() throws IOException {
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
    }

    @Test
    public void testResizeImage() throws IOException {

        InputStream is = this.getClass().getResourceAsStream("imageio-test.png");
        ImageInputStream iis = null;
        try {
            iis = ImageIO.createImageInputStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<ImageReader> iir = ImageIO.getImageReaders(iis);
        assertTrue(iir.hasNext());

        ImageReader reader = iir.next();
        reader.setInput(iis, true);

        BufferedImage originalImage = reader.read(0);
        int originWidth = originalImage.getWidth();
        int originHeight = originalImage.getHeight();

        int width = originWidth / 2;
        int height = originHeight / 2;

        int type = (originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB: originalImage.getType());

        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();

        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
                RenderingHints.VALUE_COLOR_RENDER_QUALITY);

        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

        File dir = new File("tmp");
        if (!dir.exists()) {
            boolean dirCreated = dir.mkdir();
            if (!dirCreated) {
                throw new RuntimeException("Cannot create dir " + dir.getAbsolutePath());
            }
        }
        File target = new File(dir.getPath(), "imageio-test-resize-to-half.png");

        ImageIO.write(resizedImage, "png", target);
        System.out.println("Generate resized png file to: " + target.getAbsolutePath());

    }
}
