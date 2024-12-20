package Utils;

import java.awt.Image;
import javax.swing.ImageIcon;

public  class LoadImage {
    public static ImageIcon loadImageAdjusted(String path, int width, int height) {
        try {
            ImageIcon originalIcon = new ImageIcon(LoadImage.class.getResource(path)); 
            Image originalImage = originalIcon.getImage();
            Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        } catch (Exception e) {
            System.out.println("Image: "+path+" not found!");
            return  null;
        }
  
    }
}