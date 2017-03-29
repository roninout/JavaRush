package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Kovalchuk_A on 29.03.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) {
        ImageReader reader;

        if (imageTypes == ImageTypes.JPG)
        {
            reader = new JpgReader();
        }
        else if (imageTypes == ImageTypes.BMP)
        {
            reader = new BmpReader();
        }
        else if (imageTypes == ImageTypes.PNG)
        {
            reader = new PngReader();
        }
        else
        {
            throw  new  IllegalArgumentException("Неизвестный тип картинки");
        }


        return reader;
    }
}
