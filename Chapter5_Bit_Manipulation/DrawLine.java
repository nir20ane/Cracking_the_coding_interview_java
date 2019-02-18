/**
 * A monochrome screen is stored as a single array of bytes, allowing eight consecutive pixels
 * to be stored in one byte.The screen has width w, where w is divisible by 8 (that is, no byte
 * will be split across rows). The height of the screen, of course, can be derived from the length
 * of the array and the width. Implement a function drawHorizontalLine(byte[] screen, int width,
 * int x1, int x2, int y) which draws a horizontal line from (x1, y) to (x2, y).
 */
package bitmanipulation;

public class DrawLine {

	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		// calculate first offset and start byte
        int start_offset = x1%8;
        int first_fullbyte = x1/8;
        if(start_offset != 0)
        {
        	first_fullbyte += 1;
        }
        
		// calculate last offset and start byte
        int last_offset = x2%8;
        int last_fullbyte = x2/8;
        if(last_offset != 0)
        {
        	last_fullbyte -= 1;
        }
        
        // set full bytes between first and last byte
        for(int b=first_fullbyte;b<=last_fullbyte;b++)
        {
        	screen[(width/8)*y+b] = (byte) 0xFF;
        }
        
        // calculate start and end masks
        byte startmask = (byte) (0xFF>>start_offset);
        byte endmask = (byte) ~(0xFF>>(last_offset+1));
        
        // if both x1 and x2 are in same byte, create mask and adjust screen
        if(x1/8 == x2/8)
        {
        	byte mask = (byte) (startmask | endmask);
        	int byte_number = (width/8) *(y +(x1/8));
        	screen[byte_number] |= mask;
        }
        
        // if start offset != 0, create byte with start offset + 1 and adjust screen
        else if(start_offset != 0)
        {
        	int byte_number = (width/8) *(y +(start_offset+1));
        	screen[byte_number] |= startmask;
        }
        
        // if last offset != 7, create byte with last offset - 1 and adjust screen
        else if(last_offset != 7)
        {
        	int byte_number = (width/8) *(y +(last_offset-1));
        	screen[byte_number] |= endmask;
        }
		} 
	
	public static void main(String[] args) {
		 	byte[] screen = new byte[48];
	        int width = 32;
	        drawLine(screen, width, 0, 6, 0);
	}
}
