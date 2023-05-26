package cz.cvut.fel.pjv;

import java.util.ArrayList;

public class BruteForceAttacker extends Thief {

    @Override
    public void breakPassword( int sizeOfPassword ) {
        getPwd( 0, new char[sizeOfPassword], new boolean[1] );
    }


    public void getPwd( int index, char res[], boolean isOpen[] ) {
        if( isOpen[0] == true ) {
            return;
        }
        if( index == res.length ) {
            if( tryOpen( res ) ) {
                isOpen[0] = true;
            }
            return;
        }
        for( char letter : getCharacters() ) {
            res[index] = letter;
            getPwd( index + 1, res, isOpen );
        }
    }
}
