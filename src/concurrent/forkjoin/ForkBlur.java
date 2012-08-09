package concurrent.forkjoin;

/*
* Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions
* are met:
*
*   - Redistributions of source code must retain the above copyright
*     notice, this list of conditions and the following disclaimer.
*
*   - Redistributions in binary form must reproduce the above copyright
*     notice, this list of conditions and the following disclaimer in the
*     documentation and/or other materials provided with the distribution.
*
*   - Neither the name of Oracle or the names of its
*     contributors may be used to endorse or promote products derived
*     from this software without specific prior written permission.
*
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
* IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
* THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
* PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
* EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
* PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
* PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
* LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
* SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * ForkBlur implements a simple horizontal image blur. It averages pixels in the
 * source array and writes them to a destination array. The THRESHOLD value
 * determines whether the blurring will be performed directly or split into
 * two tasks.
 * <p/>
 * This is not the recommended way to blur images; it is only intended to
 * illustrate the use of the Fork/Join framework.
 */
public class ForkBlur extends RecursiveAction {
	public static final String RESOURCES_IMAGE_JPG = "resources/image.jpg";
	private int[] source;
	private int start;
	private int length;
	private int[] destination;

	private static final int BLUR_WIDTH = 49; // Processing window size, should be odd.
	private static final int THRESHOLD = 10000;

	public ForkBlur(int[] source, int start, int length, int[] destination) {
		this.source = source;
		this.start = start;
		this.length = length;
		this.destination = destination;
	}

	// Average pixels from source, write results into destination.
	@SuppressWarnings("PointlessBitwiseExpression")
	protected void computeDirectly() {
		int sidePixels = (BLUR_WIDTH - 1) / 2;
		for (int index = start; index < start + length; index++) {
			// Calculate average.
			float rt = 0, gt = 0, bt = 0;
			for (int mi = -sidePixels; mi <= sidePixels; mi++) {
				int mindex = Math.min(Math.max(mi + index, 0), source.length - 1);
				int pixel = source[mindex];
				rt += (float) ((pixel & 0x00ff0000) >> 16) / BLUR_WIDTH;
				gt += (float) ((pixel & 0x0000ff00) >> 8) / BLUR_WIDTH;
				bt += (float) ((pixel & 0x000000ff) >> 0) / BLUR_WIDTH;
			}

			// Re-assemble destination pixel.
			destination[index] = (0xff000000) | (((int) rt) << 16) | (((int) gt) << 8) | (((int) bt) << 0);
		}
	}

	protected void compute() {
		if (length < THRESHOLD) {
			computeDirectly();
			return;
		}

		int split = length / 2;

		invokeAll(
				new ForkBlur(source, start, split, destination),
				new ForkBlur(source, start + split, length - split, destination)
		);
	}

	// Plumbing follows.

	public static void main(String[] args) throws Exception {
		File file = new File(RESOURCES_IMAGE_JPG);
		BufferedImage image = ImageIO.read(file);

		new ImageFrame("ForkBlur - original", image);
		new ImageFrame("ForkBlur - processed", blur(image));
	}

	public static BufferedImage blur(BufferedImage srcImage) {
		int w = srcImage.getWidth();
		int h = srcImage.getHeight();

		int[] srcPixels = srcImage.getRGB(0, 0, w, h, null, 0, w);
		int[] dstPixels = new int[srcPixels.length];

		System.out.println("Array size is " + srcPixels.length);
		System.out.println("Threshold is " + THRESHOLD);

		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println(Integer.toString(processors) + " processor" +
				(processors != 1 ? "s are " : " is ") +
				"available");

		ForkBlur fb = new ForkBlur(srcPixels, 0, srcPixels.length, dstPixels);

		ForkJoinPool pool = new ForkJoinPool();

		long startTime = System.currentTimeMillis();
		pool.invoke(fb);
		long endTime = System.currentTimeMillis();

		System.out.println("Image blur took " + (endTime - startTime) + " milliseconds.");

		BufferedImage dstImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dstImage.setRGB(0, 0, w, h, dstPixels, 0, w);

		return dstImage;
	}
}

class ImageFrame extends JFrame {
	@SuppressWarnings("MagicConstant")
	public ImageFrame(String title, BufferedImage image) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(image.getWidth(), image.getHeight());
		add(new ImagePanel(image));
		setLocationByPlatform(true);
		setVisible(true);
	}
}

class ImagePanel extends JPanel {
	private final BufferedImage image;

	public ImagePanel(BufferedImage image) {
		this.image = image;
	}

	protected void paintComponent(Graphics g) {
		int x = (getWidth() - image.getWidth()) / 2;
		int y = (getHeight() - image.getHeight()) / 2;
		g.drawImage(image, x, y, this);
	}
}
