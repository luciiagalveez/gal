package ufv.dis.pareja;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;

import ufv.dis.pareja.Producto;

public class GeneradorEAN13 {
	
	public static void generarEan (Producto p) throws WriterException, IOException {
		EAN13Writer ean13writer = new EAN13Writer();
		BitMatrix bitMatrix = ean13writer.encode(p.getEAN(),
		BarcodeFormat.EAN_13, 300, 100);
		Path path = FileSystems.getDefault().getPath("productos/" + p.getEAN() + p.getNombre() + ".png");
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}

}






