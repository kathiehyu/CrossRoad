package com.example.crosstheroad;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import android.widget.Button;

public class Sprint3Test {
    @Test
    public void scoreOrigin() {
        GameActivity.setCurrentRow(15);
        GameActivity.updateScore();
        assert GameActivity.getScore() == 0;
    }
    

}
