import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.*;
import Jama.*;

/**
 * @author Anders.Hu 2005-01-12
 */
public class MCS2 {

	public static void main(String[] args) {
		double pixx[][], pix1[][], pix2[][], pix3[][];
		try {
			// ¶ÁÈ¡Ä£°åÍ¼Æ¬ÄÚÈÝ
			BufferedImage image = ImageIO.read(new FileInputStream(
					"e:\\javaworkspace\\usaco\\1.jpg"));
			int width = image.getWidth();
			int height = image.getHeight();
			int minx = image.getMinX();
			int miny = image.getMinY();
			pixx = new double[height][width];
			pix1 = new double[height][width];
			pix2 = new double[height][width];
			pix3 = new double[height][width];
			System.out.println("width=" + width + ",height=" + height + ".");
			System.out.println("minx=" + minx + ",miniy=" + miny + ".");

			for (int i = minx; i < width; i++) {
				for (int j = miny; j < height; j++) {
					int pixel = image.getRGB(i, j);
					pix1[j][i] = (pixel >> 16) & 0xff;
					pix2[j][i] = (pixel >> 8) & 0xff;
					pix3[j][i] = pixel & 0xff;
					pixx[j][i] = pixel;
				}
			}
			Matrix A = new Matrix(pixx), A1 = new Matrix(pix1), A2 = new Matrix(
					pix2), A3 = new Matrix(pix3);
			SingularValueDecomposition svd = new SingularValueDecomposition(A), svd1 = new SingularValueDecomposition(
					A1), svd2 = new SingularValueDecomposition(A2), svd3 = new SingularValueDecomposition(
					A3);
			Matrix res1 = compute(svd1, minx, miny, width, height), res2 = compute(
					svd2, minx, miny, width, height), res3 = compute(svd3,
					minx, miny, width, height);
			
			Matrix U = svd.getU(), V = svd.getV(), S = svd.getS();
			
			Matrix uu = U.getMatrix(0, height - 1, 0, (int) (width / 1) - 1);
			Matrix ss = S.getMatrix(0, (int) (width / 1) - 1, 0,
					(int) (width / 1) - 1);
			Matrix vv = V.getMatrix(0, width - 1, 0, (int) (width / 1) - 1);
			Matrix res = uu.times(ss).times(vv.transpose());
			
			for (int i = minx; i < width; i++)
				for (int j = miny; j < height; j++)
					image.setRGB(i, j, (int) (res.get(j, i)));
			FileOutputStream out = new FileOutputStream(
					"e:\\javaworkspace\\usaco\\2.jpg");
			ImageIO.write(image, "JPEG", out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Matrix compute(SingularValueDecomposition svd, int minx, int miny, int width, int height) {
		Matrix U = svd.getU(), V = svd.getV(), S = svd.getS();
		
		Matrix uu = U.getMatrix(0, height - 1, 0, (int) (width / 2) - 1);
		Matrix ss = S.getMatrix(0, (int) (width / 2) - 1, 0,
				(int) (width / 2) - 1);
		Matrix vv = V.getMatrix(0, width - 1, 0, (int) (width / 2) - 1);
		Matrix res = uu.times(ss).times(vv.transpose());
		return res;
	}

}