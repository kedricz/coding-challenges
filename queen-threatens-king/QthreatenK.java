package qthreatenk;

/*
 * This program tells whether or not the King is threatened by the Queen 
 *   given the positions of the King and the Queen.
 *  
 * x and y represent cordinates in chessboard. The origin for coordinate is top left corner.
 * In this program, each position is represented as two digits number where x is tens digit and y is ones digit.
 * For example, if the Queen is at x=3 and y=5, then the position will be 35.
 * 
 * First, it will create a hashmap for moves of the Queen. 
 * The key for hashmap represent the position in chessboard.
 * It goes through all possible moves of the Queen and put each move to the hashmap.
 *  
 * After that, it will check the hashmap with King's position whether hashmap contains entry with King's position as a key.
 *
 * Time complexity and Space complexity for this method is O(n) where n is all possible moves of Queen, which is 28 at maximum.
 */

import java.util.*;

public class QthreatenK {
    
    int m = 8; // number of rows in chessboard
    int n = 8; // number of columns in chessboard
    
    /* 
     * This function takes the positions of both the Queen and the King as parameters
     *  and returns a boolean telling whether or not the King is threatened by the Queen.
     *
     * @param qX - x position of the Queen
     * @param qY - y position of the Queen
     * @param kX - x position of the King
     * @param kY - y position of the King
     *
     * @return - boolean value whether or not the King is threatened by the Queen
     */
    public boolean threatens(int qX, int qY, int kX, int kY) {
        
        /** Check if the positions for Queen and King are valid */
        if(qX < 1 || kX < 1 || qY < 1 || kY < 1 || qX > m || kX > m || qY > m || kY > m) {
            System.err.println("Invalid Position!");
            System.exit(0);
        }
        
        /** Check if Queen's position is the same as the position of the King */
        if(qX == kX && qY == kY) {
            System.err.println("Position Error! Cannot be in the same position");
            System.exit(0);
        }
        
        /* 
         * position is a hashmap that stores all of the Queen's moves 
         * from the current position position qX, qY
         */
        HashMap<Integer, Integer> positions = new HashMap<Integer, Integer>();
        
        /** Filling the Queen's moves in hashmap at the current position qX, qY */
        queenMoves(positions, qX, qY);

        
        /** Check if the position of King is within the Queen's moves */
        int kingPosition = kX*10 + kY;
        if(positions.containsKey(kingPosition)) {
            return true;
        }
       
        return false;
    }
    
    
    /* 
     * This functions takes hashmap and the positions of the Queen as parameters and
     *  add each diagonal move of the Queen to hashmap. 
     *
     * @param qP - Hashmap that contains the Queen's move
     * @param qX - x position of the Queen
     * @param qY - y position of the Queen
     */
    private void queenMoves(HashMap<Integer, Integer> qP, int qX, int qY) {
        
        int pos; // int variable to calculate the position
        
        // Put vertical moves of the Queen to hashmap
        for(int i=1; i<=m; i++) {
            pos = 0;
            pos = qX*10 + i;
            qP.put(pos,1);
        }
        
        // Put horizontal moves of the Queen to hashmap
        for(int i=1; i<=n; i++) {
            pos = 0;
            pos = (i*10) + qY;
            qP.put(pos,1);
        }
        
        
        /** Starting Diagonal Positions */
        int nw = (10*qX-10) + (qY-1);   // Northwest
        int ne = (10*qX+10) + (qY-1);   // Northeast
        int sw = (10*qX-10) + (qY+1);   // Southwest
        int se = (10*qX+10) + (qY+1);   // Southeast
        
        /** Add diagonal moves to hashmap */
        // Northwest moves
        while(nw > 0 && nw <= (m*10+n)) {
            qP.put(nw,1);
            nw -= (10+1);
        }
       
        // Northeast moves
        while(ne > 0 && ne <= (m*10+n)) {
            qP.put(ne,1);
            ne += (10-1);
        }
          
        // Southwest moves
        while(sw > 0 && sw <= (m*10+n)) {
            qP.put(sw,1);
            sw -= (10-1);
        }
        
        // Southeast moves
        while(se > 0 && se <= (m*10+n)) {
            qP.put(se,1);
            se += (10+1);
        }
    }
    
    
    public static void main(String[] args) {
        QthreatenK qk = new QthreatenK();
        System.out.println(qk.threatens(5, 6, 3, 2));
    }
    
}
