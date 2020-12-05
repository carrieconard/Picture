import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;
import java.awt.Color;// resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  public static void main(String[] args) 
  {  
    String filename = FileChooser.pickAFile(); 
    String filename1 = FileChooser.pickAFile();
    Picture picture = new Picture(filename);
    Picture picture1 = new Picture(filename1);
    //Part of assignment 4 
    //picture is undergoing checkerboard method
    //change parameters to accomodate different pictures and overloading
    picture.checkerboard(50,picture1);
    picture.show();
  }
  
  public void decreaseBlue(double val) {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value =0;
    int index =0;
    
    if (val <= 0) {
      System.out.println("Error! Parameters less than or equal to zero.");
    }
    
    if (val > 1) {
      System.out.println("Error! Parameters greater than one.");
    }
    
    
    
    while(index < pixelArray.length) {
      pixel=pixelArray[index];
      
      value=pixel.getBlue();
      
      
      value=(int)(1 - val);
      
      pixel.setBlue(value);
      
      index = index +1;
    }
    
  }
  public void modifyGreen(double val, double percentage) {
    
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value =0;
    int index =0;
    
    if (val <0) {
      System.out.println("Error! Parameters less than zero.");
      return;
    }
    
    if (val > 2) {
      System.out.println("Error! Parameters greater than two.");
    }
    
    if (percentage >1) {
      System.out.println("Error! Portion greater than one.");
    }
    
    if (percentage <0) {
      System.out.println("Error! Portion less than zero.");
    }
    
    
    
    
    while(index < (int)pixelArray.length*percentage) {
      
      pixel=pixelArray[index];
      
      value=pixel.getGreen();
      
      value=(int)(value * val);
      
      pixel.setGreen(value);
      
      index = index +1;
      
    }
    
  }    
  
  
  public void modifyRed(double val, double start, double end) {
    
    
    
    if (start > end) {
      System.out.println("Error! First portion comes after second portion.");
      return;
    }
    
    if (val > 2) {
      System.out.println("Error! Parameters greater than two.");
    }
    
    if (val < 0) {
      System.out.println("Error! Parameters less than zero.");
    }
    
    if (end >1) {
      System.out.println("Error! second portion greater than one.");
    }
    if(end < 0){
      System.out.println("Error! second portion less than zero.");
    }
    if (start <0) {
      System.out.println("Error! first portion less than zero.");
    }
    if(start > 1) {
      System.out.println("Error! first portion greater than one.");
    }
    
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value =0;
    int x = 0; 
    int index =((int)(pixelArray.length* start));
    
    
    
    while(index < (int)pixelArray.length*end) {
      
      pixel=pixelArray[index];
      
      value=pixel.getRed();
      
      x=(int)(value * val);
      
      pixel.setRed(x);
      
      index = index +1;
      
    }
    
  }
  
//Program 9
  
  
  /**
   * Method to decrease the green in the picture by 30%
   */
  public void decreaseGreen()
  {
    Pixel[]pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;
    
    //loop through all the pixels in the array 
    while (i < pixelArray.length)
    {
      //get the current pixel
      pixel = pixelArray[i];
      
      //get the value 
      value = pixel.getGreen();
      
      //set tge green value to 70% of what it was
      pixel.setGreen((int) (value * 0.7));
      
      //increment the index 
      i++;
    }
  }
  
  /**
   * Method to decrease the blue in the picture by 30%
   */
  public void decreaseBlue()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;
    
    //loop through all the pixels in the array 
    while (i < pixelArray.length)
    {
      //get the current pixel
      pixel = pixelArray[i];
      
      //get the value 
      value = pixel.getBlue();
      
      //set the blue value to 70% of what it was
      pixel.setBlue((int) (value * 0.7));
    }
  }
  /**
   * Method to make a picture look like t was taken at sunset 
   * by reducing the blue and green to mkae it look more red
   */
  public void makeSunset2()
  {
    decreaseGreen();
    decreaseBlue();
  }
  
  //Program 11
  
  /**
   * method to change the color of each pixel in the picture 
   * object by passed in amounts.
   * @param redAmount the amount to change the red value
   * @param greenAmount the amount to change the green value
   * @param blueAmount the amount to chnage the blue value
   */
  public void chaangeColor(double redAmount,
                           double greenAmount,
                           double blueAmount)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;
    
    //loop through all the pixels
    while( i < pixelArray.length)
    {
      //get the current pixel
      pixel = pixelArray[i];
      
      //change the red value 
      value = pixel.getRed();
      pixel.setRed((int) (redAmount * value));
      
      //change the green value
      value = pixel.getGreen();
      pixel.setGreen((int) (greenAmount * value));
      
      // change the blue value
      value = pixel.getBlue();
      pixel.setBlue((int) (blueAmount * value));
      
      // increment i
      i++;
    }
  }
  
  
  //Program 13
  /**
   * Method to lighten the color in the picture
   */
  public void lighten()
  {
    Pixel[] pixelArray = this.getPixels();
    Color color = null;
    Pixel pixel = null;
    
    //loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      //get the current pixel 
      pixel = pixelArray[i];
      //get the current color
      color = pixel.getColor();
      
      //get a lighten color
      color = color.brighter();
      
      //set the pixel color to the lighter color
      pixel.setColor(color);
    }
    
  }
  
  
  
//Program 15
  
  /**
   * method to negate the picture
   */
  public void negate()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int redValue, blueValue, greenValue = 0;
    
    //loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      //get the current pixel
      pixel = pixelArray[i];
      
      //get the current red, green, and blue values
      redValue = pixel.getRed();
      greenValue = pixel.getGreen();
      blueValue = pixel.getBlue();
      
      //set the pixel's color to the new color
      pixel.setColor(new Color(255 - redValue,
                               255 - greenValue,
                               255 - blueValue));
    }
  }
  
  
  
  
  
  
  
  
  
  public void fade()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    for (int i = 0; i < pixelArray.length; i++) {
      // get the current pixel
      pixel = pixelArray[i];
      //get, modify, then set the values
      pixel.setRed((int)(pixel.getRed()*0.6));
      pixel.setGreen((int)(pixel.getGreen()*0.6));
      pixel.setBlue((int)(pixel.getBlue()*0.6));
    }
  }
  
  
  
  public void copyPixelsFromSource(Picture source)
  {
    //are the two images exactly the same?
    if (this.getWidth()!= source.getWidth() || this.getHeight()!= source.getHeight())
    {
      System.out.println("Error! Source image size is not the same as this image.");
      return;
    }
    
    //create the pixel array from the target image
    Pixel[] targetArray = this.getPixels();
    //create the pixel array for the source image
    Pixel[] sourceArray = source.getPixels();
    //create variables to hold the current pixels RGB values
    Pixel pixel = null;
    Pixel targetPixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    
    for (int i = 0; i < sourceArray.length; i++)
    {
      pixel = sourceArray[i];
      targetPixel = targetArray[i];
      redValue = pixel.getRed();
      greenValue = pixel.getGreen();
      blueValue = pixel.getBlue();
      
      targetPixel.setRed(redValue);
      targetPixel.setGreen(greenValue);
      targetPixel.setBlue(blueValue);
    }
    
    
  }
  public void averageWithSource(Picture source)
  {
    //are the two images exactly the same?
    if (this.getWidth()!= source.getWidth() || this.getHeight()!= source.getHeight())
    {
      System.out.println("Error! Source image size is not the same as this image.");
      return;
    }
    
    //create the pixel array from the target image
    Pixel[] targetArray = this.getPixels();
    //create the pixel array for the source image
    Pixel[] sourceArray = source.getPixels();
    //create variables to hold the current pixels RGB values
    Pixel pixel = null;
    Pixel targetPixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    
    for (int i = 0; i < sourceArray.length; i++)
    {
      pixel = sourceArray[i];
      targetPixel = targetArray[i];
      redValue = (pixel.getRed()+targetPixel.getRed())/2;
      greenValue = (pixel.getGreen()+targetPixel.getGreen())/2;
      blueValue = (pixel.getBlue()+targetPixel.getBlue())/2;
      
      targetPixel.setRed(redValue);
      targetPixel.setGreen(greenValue);
      targetPixel.setBlue(blueValue);
    }
    
    
  }  
  
  //Program 18 
  
  /**
   * method to lighten the colors in the picture
   */
  public void lightten2()
  {
    Color color = null;
    Pixel pixel = null;
    
    //loop through the colums (x direction)
    for (int x = 0; x < getWidth(); x++)
    {
      //loop through the rows (y directions)
      for (int y = 0; y <getHeight(); y++)
      {
        //get pixe; at the x and y location
        pixel = getPixel(x,y);
        
        //get the current color
        color = pixel.getColor();
        
        //get a lighter color
        color = color.brighter();
        
        //set the pixel color to the lighter color
        pixel.setColor(color);
      }
    }
  }
  
  //Program 19
  
  /**
   * method to mirror around a vertical line in the middle 
   * of the picture based on the width
   */
  public void mirrorVertical()
  {
    int width = this.getWidth();
    int mirrorPoint = width / 2;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    
    //loop through all the rows
    for (int y = 0; y < getHeight(); y++)
    {
      //loop from 0 to the middle (mirror point)
      for (int x = 0; x < mirrorPoint; x++)
      {
        leftPixel = getPixel(x,y);
        rightPixel = getPixel(width - 1 - x, y);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  //Program 20
  
  /**
   * method to mirror around a horicontal line in the middle 
   * based on the height. It copies the top mirrored to 
   * the bottom
   */
  public void mirrorHorizontal()
  {
    int height = this.getHeight();
    int mirrorPoint = height / 2;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    //loop through the columns 
    for (int x=0; x < getWidth(); x++)
    {
      //loop from 0 to just before the mirror point
      for (int y=0; y < mirrorPoint; y++)
      {
        topPixel = getPixel(x,y);
        bottomPixel = getPixel(x,height - 1 - y);
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }
  
  //Program 22
  
  /**
   * method to mirror part of the temple picture around a 
   * vertical line at a mirror point
   */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    
    //loop through the rows
    for (int y = 27; y < 97; y++)
    {
      //loop from 1 to just before the mirror point
      for (int x = 13; x < mirrorPoint; x++)
      {
        leftPixel = getPixel(x,y);
        rightPixel = getPixel(mirrorPoint + (mirrorPoint - x), y);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  
  
  
//Program 23
  /**
   * Method to copy the picture of katie to the 
   * upper left corner of the current picture
   */
  public void copyKatie()
  {
    String sourceFile =
      FileChooser.getMediaPath("KatieFancy.jpg");
    Picture sourcePicture = new Picture(sourceFile);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // loop through the columns
    for (int sourceX = 0, targetX=0;
         sourceX < sourcePicture.getWidth();
         sourceX++, targetX++)
    {
      //loop through the rows
      for (int sourceY = 0, targetY =0;
           sourceY < sourcePicture.getHeight();
           sourceY++, targetY++)
      {
        //set the target puxel color to thr source pixel color
        sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
  
  
//Program 25
  /**
   * method to copy just Katie;s face to the current picture
   */
  public void copyKatiesFace()
  {
    String sourceFile =
      FileChooser.getMediaPath("KatieFancy.jpg");
    Picture sourcePicture = new Picture(sourceFile);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    //loop through the colormns 
    for (int sourceX = 70, targetX = 100;
         sourceX < 135; sourceX++, targetX++)
    {
      //loop through the rows
      for (int sourceY = 3, targetY = 100;
           sourceY < 80; sourceY++, targetY++)
      {
        //set the target pixel color to the source pixel color
        sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
  
  
//Program 27
  
  public void copyPictureTo(Picture sourcePicture,
                            int xStart)
  {
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    //loop through the colomns
    for (int sourceX = 0, targetX = xStart;
         sourceX < sourcePicture.getWidth();
         sourceX++, targetX++)
    {
      //loop through the rows
      for (int sourceY = 0,
           targetY = this.getHeight() - 5;
           sourceY < sourcePicture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
  
  public void copyFlowersBetter()
  {
    //create the flowers pictures
    Picture flower1Picture =
      new Picture(FileChooser.getMediaPath("flower1.jpg"));
    Picture flower2Picture =
      new Picture(FileChooser.getMediaPath("flower2.jpg"));
    
    //copy the first flower picture to near the
    //bottom left corner of the canvas
    this.copyPictureTo(flower1Picture,0);
    
    /* copy the first flower picture to near the
     * x= 100 in the canvas
     */
    
    this.copyPictureTo(flower2Picture,100);
    
    //copy the flowers1 negated to x = 200 in the canvas
    flower1Picture.negate();
    this.copyPictureTo(flower1Picture,200);
    
    
    this.copyPictureTo(flower2Picture,300);
    
    this.copyPictureTo(flower1Picture,400);
    
  }
  
  
//Program 28
  
  public void blendPicture()
  {
    Picture katiePicture =
      new Picture(FileChooser.getMediaPath("KatieFancy.jpg"));
    Picture jennyPicture =
      new Picture(FileChooser.getMediaPath("JenParty.jpg"));
    
    Pixel katiePixel = null;
    Pixel jennyPixel = null;
    Pixel targetPixel = null;
    
    int sourceX = 0;
    int targetX = 0;
    
    for (; sourceX < 150; sourceX++)
    {
      for (int sourceY=0, targetY=0;
           sourceY < katiePicture.getHeight();
           sourceY++, targetY++)
        
      {
        
        targetPixel = this.getPixel(targetX,targetY);
        
      }
    }
    
  }
  
  
//Program 31
  
  public void copyFlowerLarger()
  {
    Picture flowerPicture = 
      new Picture(FileChooser.getMediaPath("rose.jpg"));
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    for (double sourceX = 0, targetX=0;
         sourceX < flowerPicture.getWidth();
         sourceX = sourceX + 0.5, targetX++)
    {
      
      for (double sourceY = 0, targetY=0;
           sourceY < flowerPicture.getWidth();
           sourceY = sourceY + 0.5, targetY++)
      {
        sourcePixel =
          flowerPicture.getPixel((int) sourceX,(int) sourceY);
        targetPixel = this.getPixel((int) targetX,(int) targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
  
  
  private boolean isSameSize(Picture source) {
    if (source.getWidth() == this.getWidth()) {
      if (source.getHeight() == this.getHeight()) {
        return true;
      }
    }
    return false;
  }//end of isSameSize
  
  private void copyPixel (Picture srcPic, int srcX, int srcY, Picture dstPic, int dstX, int dstY)
  {
    Pixel srcPixel = null;
    Pixel dstPixel = null;
    //set the target puxel color to thr source pixel color
    srcPixel = srcPic.getPixel(srcX,srcY);
    dstPixel = dstPic.getPixel(dstX,dstY);
    Color color = srcPixel.getColor();
    dstPixel.setColor(color);
  }
  
  /* The target image is the Picture oject this method is called on. The method copies all 
   * the pixel from the source Picture passed in to the taget iage, completely replacing it.
   */
  public void simpleCopyFromSource(Picture source) {
    // Check that both source and target images are the same size
    if (!this.isSameSize(source)) {
      System.out.println("Error! The source and target images are not the same size.");
      return;
    }
    //Iterate through the rows and colomns of the source, copy each pixel to the target (this).
    for (int x=0; x<this.getWidth(); x++) {
      for (int y = 0; y<this.getHeight(); y++) {
        copyPixel(source, x, y, this,x, y);
      }
    }
  }
  
  public void addPic(Picture newPic, int xPos, int yPos)
  {
    //first check preconditions, newPic has to be smaller than "this" in both dimensions
    if(newPic.getWidth() > this.getWidth() || newPic.getHeight() > this.getHeight())
    {
      System.out.println("Error! The passed in picture is larger than this picture");
      return;
    }
    int newWidth = newPic.getWidth();
    int newHeight = newPic.getHeight();
    //iterate through each column and row
    for(int x =0; x < newWidth; x++){
      for (int y = 0; y<newHeight; y++){
        //make sure we aren't trying to copy beyond either
        //the left side of "this" image or the bottom of "this" image
        if( ((x +xPos) <getWidth()) && ((y+yPos) < getHeight()))
        {
          copyPixel(newPic,x,y, this, xPos+x,yPos+y);
          
        }
      }
    }
  }
  
  
  public void crop(int xPos, int yPos, int width, int height)
  {
    Pixel storeObject = null;
    for(int x =0; x<this.getWidth(); x++){
      for (int y =0; y <this.getHeight(); y++){
        storeObject = this.getPixel(x,y);
        //Color color = storeObject.setColor(Color.white); }
        if(x<xPos || y<yPos || x>(xPos+width) ||y>(yPos+height)) 
        { storeObject.setColor(Color.white);
        }
      }
    }
  }
  
  public void crop(int xPos, int yPos, int width, int height, Picture newPic)
  {
    
    if(newPic.getWidth() != width || newPic.getHeight() != height)
    {
      System.out.println("Error! The passed in picture is larger than this picture");
      return;
    }
    for(int x = 0; x <newPic.getWidth(); x++)
    {
      for (int y = 0; y < newPic.getHeight(); y++)
      {
        if(x+ xPos < getWidth() && y + yPos < getHeight())
        {
          copyPixel(this, (x+xPos), (yPos + y), newPic, x,y);
        }
      }
    }
  }
  public void changeColorRed(double redAmount) {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;
    
    //change all pixels to red
    while( i < pixelArray.length)   {
      pixel = pixelArray[i];
      
      value = pixel.getRed();
      pixel.setRed((int) (redAmount * value));
      
      i++;
      
    }
  }
  public void changeColorBlue(double blueAmount) {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;
    
    //change all pixels to blue
    while( i < pixelArray.length)   {
      pixel = pixelArray[i];
      
      value = pixel.getBlue();
      pixel.setBlue((int) (blueAmount * value));
      
      i++;
    }
  }
  public void changeColorGreen(double greenAmount) {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;
    
    //change all pixels to green
    while( i < pixelArray.length)   {
      pixel = pixelArray[i];
      
      value = pixel.getGreen();
      pixel.setGreen((int) (greenAmount * value));
      
      i++;
    }
  }
  // TODO: copy this method into your Picture.java file and work on it there.
  public void averagePixelsHorizontally() {
    // To get you started, these are the local variables you will need for this method
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    Pixel this_pixel = null;
    Pixel prev_pixel = null;
    Pixel next_pixel = null;
    int index = 0;
    int red;
    int green;
    int blue;
    while (index < pixelArray.length) {
      if (index == 0) {
        // special case, first pixel, no prev_pixel to average
        System.out.println("special case, first pixel");
        //TODO: put code here to average first pixel (index) with second pixel (index + 1)
        this_pixel = pixelArray[index];
        next_pixel = pixelArray[index +1];
        
        //averaging the red pixels
        red = (this_pixel.getRed() + next_pixel.getRed())/2;
        this_pixel.setRed(red);
        //averaging the green pixels
        green = (this_pixel.getGreen() + next_pixel.getGreen())/2;
        this_pixel.setGreen(green);
        //averaging the blue pixels
        blue = (this_pixel.getBlue() + next_pixel.getBlue())/2;
        this_pixel.setBlue(blue);
        
      } else if (index == pixelArray.length - 1) {
        // special case, last pixel, no next_pixel to average
        System.out.println("special case, last pixel");
        // TODO: put code here to average last pixel (index) with second-last pixel (index – 1)
        this_pixel = pixelArray[index];
        next_pixel = pixelArray[index -1];
        
        //averaging the red pixels
        red = (this_pixel.getRed() + next_pixel.getRed())/2;
        this_pixel.setRed(red);
        //averaging the green pixels
        green = (this_pixel.getGreen() + next_pixel.getGreen())/2;
        this_pixel.setGreen(green);
        //averaging the blue pixels
        blue = (this_pixel.getBlue() + next_pixel.getBlue())/2;
        this_pixel.setBlue(blue);
      } else {
        // standard case
        prev_pixel = pixelArray[index - 1]; 
        pixel = pixelArray[index];
        next_pixel = pixelArray[index + 1];
        // red pixel averaging
        red = (prev_pixel.getRed() + pixel.getRed() + next_pixel.getRed())/3;
        pixel.setRed(red);
        // green pixel averaging
        green = (prev_pixel.getGreen() + pixel.getGreen() + next_pixel.getGreen())/3;
        pixel.setGreen(green);
        // blue pixel averaging
        blue = (prev_pixel.getBlue() + pixel.getBlue() + next_pixel.getBlue())/3;
        pixel.setBlue(blue);
      } // end else
      index++;
    } // end while
  }// end method
  //program 33
  /** 
   * Method to turn the brown in a picture
   * into red
   */
  public void turnBrownIntoRed() {
    Color brown = new Color(42,25,15);
    Pixel[] pixels = this.getPixels();
    Pixel pixel = null;
    
    //loop through the pixels
    for (int i = 0; i<pixels.length; i++) {
      //get the current pixel
      pixel = pixels[i];
      
      //check if in distance to brown and if so double the red
      if(pixel.colorDistance(brown) < 50.0)
        pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                 pixel.getGreen(),
                                 pixel.getBlue()));
      
    }
  }
//program 34
  /** 
   * Method to turn brown to red inside of 
   * a rectangular area
   */
  public void turnBrownToRedInRectangle() {
    Color brown = new Color(42,25,15);
    Pixel pixel = null;
    
    //loop through the x values
    for(int x = 63; x < 125; x++) {
      for(int y=6; y<76; y++) {
        //get the current pixel
        pixel = this.getPixel(x,y);
        
        //check if in dist to brown and if so double the red
        if(pixel.colorDistance(brown) < 50.0)
          pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                   pixel.getGreen(),
                                   pixel.getBlue()));
      }
    }
  }
  //program 35
  /** 
   * Method to turn brown to red in a rectangular area
   * specified
   * by startX, endX-1, startY, endY-1
   * @param startX the starting location to check in x
   * @param endX the last pixel checked is one less than
   * this in x
   * @param startY the starting location to check in y
   * @param endY the last pixel checked is one less tha 
   * this in y
   */
  public void turnBrownToRedInRectangle(int startX, int endX, 
                                        int startY, int endY,
                                        double distance)
  {
    Color brown = new Color(42,25,15);
    Pixel pixel = null;
    
    //loop through the x values
    for(int x = startX; x < endX; x++)
    {
      for(int y = startY; y < endY; y++)
      {
        
        //get the current pixel
        pixel = this.getPixel(x,y);
        
        /*check if in distance to brown is less than 
         * the passed distance and if so double the red
         */ 
        if(pixel.colorDistance(brown) < distance)
          pixel.setColor(new Color((int) (pixel.getRed() * 2.0), pixel.getGreen(), pixel.getBlue())); 
        
        
      }
    }
  }
  //program 36
  /**
   * Method to remove red-eye from the current picture object 
   * in the rectangle defined by the startX, startY, endX, endY.
   * The red will be replaced with the passed newColor
   * @param startX the top left corner x value of a rectangle
   * @param startY the top left corner y value of a rectangle
   * @param endX the bottom right corner x value of a rectangle
   * @param endY the bottom right corner y value of a rectangle
   * @param newColor the new color to use
   */
  public void removeRedEye(int startX, int startY, int endX, 
                           int endY, Color newColor)
  {
    Pixel pixel = null;
    /* loop through the pixels in the rectangle defined by the startX, startY, and endX, and endY */
    for(int x = startX; x< endX; x++)
    {
      for(int y = startY; y< endY; y++) 
      {
        //get the current pixel
        pixel = getPixel(x,y);
        
        //if the color is near red then change it
        if(pixel.colorDistance(Color.red) < 167)
          pixel.setColor(newColor);
      }
    }
  }
//program 37
  /** 
   * Method to do a simple edge detection by comparing the 
   * absolute value of the difference between the color
   * intensities (average of the color values) between a 
   * pixel and the pixel below it. If the absolute vlaue of the
   * difference between the color intensities is less than a passed amount the top 
   * pixel color will be set to white. Otherwise it is set to black. 
   * @param amount if the absolute value of the differences in the color
   * average is less than this 
   * set the color to white, else black 
   */
  public void edgeDetection(double amount) {
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    double topAverage = 0.0;
    double bottomAverage = 0.0;
    int endY = this.getHeight() - 1;
    
    /* loop through the y values from 0 to height-1
     * (since compare to below pixel) */
    for(int y = 0; y < endY; y++) {
      //loop through the x values from 0 to width
      for(int x = 0; x < this.getWidth(); x++) {
        //get the top and bottom pixels
        topPixel = this.getPixel(x,y);
        bottomPixel = this.getPixel(x, y+1);
        
        //get the color averages for the two pixels
        topAverage = topPixel.getAverage();
        bottomAverage = bottomPixel.getAverage();
        
        /*check if the absolute value of the difference 
         * is less than the amount*/
        if(Math.abs(topAverage - bottomAverage) < amount) {
          topPixel.setColor(Color.WHITE);
          //else set the color to black
        }
        else{
          topPixel.setColor(Color.BLACK);
        }
      }
    }
  }
  //program 39
  /**
   * Method to posterize (reduce the number of colors) in 
   * the picture. The number of reds, greens, and blues
   * will be 4.
   */
  public void posterize() {
    Pixel pixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    
    //loop through the pixels
    for(int x = 0; x < this.getWidth(); x++) {
      for(int y = 0; y < this.getHeight(); y++) {
        //get the current pixela dn colors
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();
        
        //check the red range and change color
        if(redValue < 64) 
          redValue = 31;
        else if(redValue<128)
          redValue = 95;
        else 
          redValue = 223;
        
        //check the green range
        if(greenValue < 64) 
          greenValue= 31;
        else if(greenValue<128)
          greenValue = 95;
        else if(greenValue< 192)
          greenValue = 159;
        else 
          greenValue = 223;
        
        //check the blue range
        if(blueValue < 64) 
          blueValue= 31;
        else if(blueValue<128)
          blueValue = 95;
        else if(blueValue< 192)
          blueValue = 159;
        else 
          blueValue = 223;
        
        //set the colors
        pixel.setRed(redValue);
        pixel.setGreen(greenValue);
        pixel.setBlue(blueValue);
      }
    }
  }
  
  
  
  
  public void blackOut(int startX, int startY, int endX, int endY) {
    Color black = new Color(0,0,0);
    Pixel pixel = null;
    
    //loop through the x values
    for(int x = startX; x < endX; x++)
    {
      for(int y = startY; y < endY; y++)
      {
        
        //get the current pixel
        pixel = this.getPixel(x,y);
        
        /*check if in distance to brown is less than 
         * the passed distance and if so double the red
         */ 
        pixel.setColor(Color.BLACK); 
      }
      
    }
  }
  
  
  private void blurPixel(int x, int y, int size) {
    // blurs the passed in (x, y) pixel by averaging the colors of the surrounding
    // pixels size is how far out to go, so if size is 2, we will blur based on two
    // columns to the left, two to the right, two rows above and two below, in a 
    // square
    
    Pixel tempPixel = null;
    Pixel pixel = null;
    
    int sumR = 0;
    int sumG = 0;
    int sumB = 0;
    int divisor = 0;
    
    
    // iterate over the size x size pixels in this area to add up the RGBs
    for (int subx = x-size; subx < x+size + 1; subx++) {
      for (int suby = y-size; suby < y+size + 1; suby++) {
        // check if this pixel is in the range of this image
        if (suby >= y-size && suby < y+size +1 && subx >= x-size && subx < x+size +1)
        {
          
          // in range, so get this pixel, add it's colors to running average
          tempPixel = this.getPixel(subx, suby);
          sumR += tempPixel.getRed();
          sumG += tempPixel.getGreen();
          sumB += tempPixel.getBlue();
          // increase divisor
          divisor += 1;
        }
      }
    }
    // done adding up all the colors from surrounding pixels so
    // get this pixel and then set it's color to the average RGBs
    // making sure to divide by the divisor (num colors added in)
    pixel = this.getPixel(x,y);
    pixel.setRed((int) (sumR/divisor));
    pixel.setGreen((int) (sumG/divisor));
    pixel.setBlue((int) (sumB/divisor));
    
    
  }
  public void blurArea(int startX, int startY, int endX, int endY, int level) {
    Pixel pixel = null;
    
    // loop through the pixels
    for (int x = 0; x < this.getWidth(); x++) {
      for (int y = 0; y < this.getHeight(); y++) {
        if(x >= startX && x<endX && y>= startY && y< endY){
          pixel = this.getPixel(x,y);
          this.blurPixel(x,y,level);
        }
      }
      
    }
  }
  
  public void colorfulEdgeDetection(double amount, double threshold) {
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    double topAverage = 0.0;
    double bottomAverage = 0.0;
    int endY = this.getHeight() - 1;
    
    /* loop through the y values from 0 to height-1
     * (since compare to below pixel) */
    for(int y = 0; y < endY; y++) {
      //loop through the x values from 0 to width
      for(int x = 0; x < this.getWidth(); x++) {
        //get the top and bottom pixels
        topPixel = this.getPixel(x,y);
        bottomPixel = this.getPixel(x, y+1);
        
        //get the color averages for the two pixels
        topAverage = topPixel.getAverage();
        bottomAverage = bottomPixel.getAverage();
        
        /*check if the absolute value of the difference 
         * is less than the amount*/
        if(topAverage> threshold) {
          if(Math.abs(topAverage - bottomAverage) < amount) {
            topPixel.setColor(Color.WHITE);
            //else set the color to black
          }
          else{
            // topPixel.setColor(Color.BLACK);
          }
        }
      }
    } 
    
  }
  //program 40
  /**
   * Method to posterize (reduce the number of colors) in 
   * the picture
   * @param numLevels the number of color levels to use
   */
  public void posterize(int numLevels) {
    Pixel pixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int increment = (int) (256.0 / numLevels);
    int bottomValue, topValue, middleValue = 0;
    
    //loop through the pixels
    for(int x = 0; x< this.getWidth(); x++) {
      for(int y = 0; y < this.getHeight(); y++) {
        //get the current pixel and colors
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();
        
        //loop through the number of levels
        for(int i = 0; i < numLevels; i++) {
          //compute the bottom, top, and middle values
          bottomValue = i * increment;
          topValue = (i+1) * increment;
          middleValue = (int) ((bottomValue + topValue - 1) 
                                 / 2.0);
          
          /* check if current values are in current range and 
           * if so set them to the middle value
           */
          if(bottomValue <= redValue &&
             redValue < topValue) 
            pixel.setRed(middleValue);
          if(bottomValue <= greenValue &&
             greenValue < topValue) 
            pixel.setGreen(middleValue);
          if(bottomValue <= blueValue &&
             blueValue < topValue) 
            pixel.setBlue(middleValue);
        }
      }
    }
  }
  //program 41
  /** 
   * Method to replace the pixel colors in the current
   * picture object that have a color distance less than 
   * the oassed amount to white or black with the passed
   * replacement color
   * @param replacementColor the new color to use 
   */
  public void highlightLightAndDark(double amount, 
                                    Color replacementColor) {
    Pixel pixel = null;
    
    //loop through all the pixels in the x direction
    for(int x = 0; x < getWidth(); x++) {
      //loop through all the pixels in the y direction
      for(int y = 0; y < getHeight(); y++) {
        //get the current pixel
        pixel = getPixel(x,y);
        
        //if the distance from white or black is less than the 
        //passed amount use the replacement color instead 
        if(pixel.colorDistance(Color.white) < amount ||
           pixel.colorDistance(Color.black) < amount) {
          pixel.setColor(replacementColor);
        }
      }
    }
  }
  //program 42
  /**
   * Method to blur the pixels
   * @param numPixels the number of pixels to average in all
   * directions so if the numPixels is 2 then we will average
   * all pixels in the rectangle defined by 2 before the current 
   * pixel to 2 after the current pixel
   */
  public void blur(int numPixels)
  {
    Pixel pixel = null;
    Pixel samplePixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int count = 0;
    
    //loop through the pixels
    for(int x = 0; x < this.getWidth(); x++) {
      for( int y = 0; y < this.getHeight(); y++) {
        
        //get the curret pixel
        pixel = this.getPixel(x,y);
        
        //reset the count and red, green, and blue values
        count = 0;
        redValue = greenValue = blueValue = 0;
        
        /*loop through pixel numPixels before x to
         * numPixels after x
         */
        for(int xSample = x - numPixels;
            xSample <= x + numPixels; 
            xSample++) {
              for (int ySample = y - numPixels;
                   ySample <= y + numPixels; 
                   ySample++) {
                     /* check that we are in range of acceptable 
                      * pixels
                      */
                     if(xSample >= 0 && xSample <this.getWidth() && ySample >=0 && ySample < this.getHeight()) {
                       samplePixel = this.getPixel(xSample,ySample);
                       redValue = redValue + samplePixel.getRed();
                       greenValue = greenValue + samplePixel.getGreen();
                       blueValue = blueValue + samplePixel.getBlue();
                       count = count + 1;
                     } 
                   }
            }
            //use the average color of surrounding pixels
            Color newColor = new Color(redValue / count, 
                                       greenValue / count,
                                       blueValue / count);
            pixel.setColor(newColor);
      }
    }
  }
  //program 43
  /**
   * Method to replace the background in the current picture 
   * with the background from another picture
   * @param oldBackground a picture with the old background 
   * to replace 
   * @param newBackground a picture with the new background
   * to use
   */
  public void swapBackground(Picture oldBackground, 
                             Picture newBackground) {
    Pixel currPixel = null;
    Pixel oldPixel = null;
    Pixel newPixel = null;
    
    //loop through the columns
    for(int x=0; x<getWidth(); x++){
      //loop through the rows
      for(int y = 0; y<getHeight(); y++)
      {
        //get the current pixel and old background pixel
        currPixel = this.getPixel(x,y);
        oldPixel = oldBackground.getPixel(x,y);
        /* if the distance between the current pixel color
         * and the old background pixel color is less
         * than the 15 then swap in the new background pixel
         */
        if(currPixel.colorDistance(oldPixel.getColor()) < 15.0)
        {
          newPixel = newBackground.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }             
      }
    }
  }
  //program 44
  /**
   * Method to replace the background in the current picture
   * with the background from another picture
   * @param oldBackground a picture with the old background 
   * to replace
   * @param newBackground a picture with the new background 
   * to use
   * @param threshold if the distance between the current
   * pixel color and the background pixel color is less 
   * than this amount use the new background pixel color
   */
  public void swapBackground (Picture oldBackground, 
                              Picture newBackground, 
                              double threshold) {
    Pixel currPixel = null;
    Pixel oldPixel = null;
    Pixel newPixel = null;
    
    //loop through the columns
    for(int x = 0; x <getWidth(); x++) {
      //loop through the rows
      for(int y = 0; y<getHeight(); y++) {
        //get the current pixel and old background pixel
        currPixel = this.getPixel(x,y);
        oldPixel = oldBackground.getPixel(x,y);
        /* if the distance between the current pixel color
         * and the old background pixel color is less than 
         * the threshold then swap in the new background 
         * pixel
         */
        if((currPixel.colorDistance(oldPixel.getColor()) < threshold)) {
          newPixel = newBackground.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  //program 45
  /**
   * Method to do chromakey using a blue background
   * @param newBg the new background image to use to replace 
   * the blue from the current picture
   */
  public void chromakey(Picture newBg) {
    Pixel currPixel = null;
    Pixel newPixel = null;
    
    //loop through the columns
    for(int x = 0; x<getWidth(); x++) {
      for(int y = 0; y<getHeight(); y++) {
        //get the current pixel
        currPixel = this.getPixel(x,y);
        
        /*if the color at the current pixel is mostly blue
         * (blue value is greater than red and green combined), 
         * then use new background color
         */
        if(currPixel.getRed() + currPixel.getGreen() <
           currPixel.getBlue())
        {
          newPixel = newBg.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  //program 46
  /**
   * Method to do chromakey using a blue background
   * @param newBg the new background image to use to replace 
   * the blue from the current picture
   */
  public void chromakeyBlue(Picture newBg) {
    Pixel [] pixelArray = this.getPixels();
    Pixel currPixel = null;
    Pixel newPixel = null;
    
    //loop through the pixels
    for(int i = 0; i <pixelArray.length; i++) {
      //get the current pixel
      currPixel = pixelArray[i];
      
      /* if the color at the current pixel is mostly blue
       * (blue value is greater than red and green combined), 
       * then use new background color
       */
      if(currPixel.getRed() + currPixel.getGreen() < currPixel.getBlue()) {
        newPixel = newBg.getPixel(currPixel.getX(), 
                                  currPixel.getY());
        currPixel.setColor(newPixel.getColor());
      }
    }
  }
  //assignment 4 part 1
  public Picture shrink(int factor) {
    Picture picture = new Picture(this.getWidth()/factor+1, this.getHeight()/factor+1);
    
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    //testing if factor is less than 2 or greater than 4
    if(factor<2 || factor>4) {
      System.out.println("The parameters should be 2,3, or 4.");
      return this;
    }
    //loop through the columns
    for(int sourceX = 0, targetX = 0;             
        sourceX < this.getWidth();
        sourceX+=factor, targetX++)
    {     
      //loop through the rows 
      for(int sourceY = 0, targetY = 0;          
          sourceY < this.getHeight();
          sourceY+=factor, targetY++)
      {  //copying pixels into new picture
        sourcePixel = this.getPixel(sourceX, sourceY);
        targetPixel = picture.getPixel(targetX, targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    } 
    return picture;      
  }
//assignment 4 part 2
  public void reveal(Picture underPic, double division_height) {
    //creating dividingLine and target pixel
    int dividingLine = (int)(division_height * this.getHeight());
    Pixel targetPixel = null;
    
    //making sure division_height (percentage) value is between 0.0 and 1.0
    if(division_height<0.0 || division_height>1.0) {
      System.out.println("Error. Division_height must be between 0.0 and 1.0");
      return;
    }
    //testing if photos same size
    if(!this.isSameSize(underPic)){
      System.out.println("Error! Source picture is not the same size.");
      return;
    } //Nested loop to go through the image
    //looping through the columns
    for(int sourceX = 0, targetX = 0; sourceX < this.getWidth(); sourceX++, targetX++) {
      //looping through the rows
      for(int sourceY = 0, targetY = 0; sourceY < this.getHeight(); sourceY++, targetY++){
        if(sourceY<dividingLine){
          //making a black line
          targetPixel = getPixel(targetX, targetY + 1);
          //setting color of line to black
          targetPixel.setColor(Color.black);
          //copying picture out
          copyPixel(underPic, sourceX, sourceY, this, targetX, targetY);    
        }
        
      }
    }
  }
//assignment 4 part 3
  public void checkerboard(int width, Color c) {
    //checking if width is less than half the image
    if(width > (int)(this.getWidth()/2)) {
      System.out.println("Width must be less than half the image!");
      return;
    }
    Pixel pixel = null;
    
    //looping through the columns
    for(int x=0; x < getWidth(); x++) {
      //looping through the rows
      for(int y=0; y< getHeight(); y++){
        //making a square every even row and column
        if(((x/width) % 2 == 0) &&((y/width) % 2 ==0)){
          pixel = getPixel(x,y);
          pixel.setColor(c);
        }
      } 
    }//looping through the columns
    for(int x=0; x < getWidth(); x++) {
      //looping through the rows
      for(int y =0; y <getHeight(); y++) {
        //making a square every odd row and column
        if(((x/width) % 2 ==1) && ((y/width) % 2 ==1)){
          pixel = getPixel(x,y);
          pixel.setColor(c);
        }
      }
    }   
  }
  //assignment 4 part 4
  public void checkerboard(int width, int alpha) {
   //checking if width is less than half the image
    if(width > ((int)this.getWidth()/2)) {
      System.out.println("Width must be less than half the image!");
      return;
    }
    //checking if alpha is between 0 and 255
    if(alpha < 0 || alpha > 255) {
      System.out.println("Alpha needs to be in between 0 and 255");
      return;
    }
    Pixel pixel = null;
    
    //looping through the EVEN columns
    for(int x=0; x < getWidth(); x++) {
      //looping through the EVEN rows
      for(int y=0; y< getHeight(); y++){
        //making a square every even row and column
        if(((x/width) % 2 == 0) &&((y/width) % 2 ==0)){
          pixel = getPixel(x,y);
          pixel.setAlpha(alpha);
        }
      } 
      
    }//looping through the ODD columns
    for(int x=0; x < getWidth(); x++) {
      //looping through the ODD rows
      for(int y =0; y < getHeight(); y++) {
        //making a square every odd row and column
        if(((x/width) % 2 == 1) && ((y/width) % 2 ==1)){
          pixel = getPixel(x,y);
          pixel.setAlpha(alpha);
        }
      }
    }
  }
  //assignment 4 part 5 
  public void checkerboard(int width, Picture pic) {
    //checking if width is less than half the image
    if(width > ((int)this.getWidth()/2)) {
      System.out.println("Width must be less than half the image!");
      return;
    }
    //checking if picture is the same size
    if(!isSameSize(pic)) {
      System.out.println("Pictures need to be same size.");
      return;
    }
    
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    //looping through the EVEN columns
    for(int x=0; x < getWidth(); x++) {
      //looping through the EVEN rows
      for(int y=0; y< getHeight(); y++){
        //making a square every even row and column
        if(((x/width) % 2 == 0) &&((y/width) % 2 ==0)){
          sourcePixel = getPixel(x,y);
          targetPixel = pic.getPixel(x,y);
          sourcePixel.setColor(targetPixel.getColor());
        }
      } 
      
    }//looping through the ODD columns
    for(int x=0; x < getWidth(); x++) {
      //looping through the ODD rows
      for(int y =0; y < getHeight(); y++) {
        //making a square every odd row and column
        if(((x/width) % 2 == 1) && ((y/width) % 2 ==1)){
          sourcePixel = getPixel(x,y);
          targetPixel = pic.getPixel(x,y);
          sourcePixel.setColor(targetPixel.getColor());
        }
      }
    }
  }
}// this } is the end of class Picture, put all new methods before this