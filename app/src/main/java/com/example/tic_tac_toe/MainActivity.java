package com.example.tic_tac_toe;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    boolean gameACtive=true;
    int activePlayer=1;
    int []gameState={2,2,2,2,2,2,2,2,2};
    /*
        player representation
    0=X
    1=0
        game state meaning
    0=1
    1=X
    2=empty
    */
    public void gameReset(View view){
        gameACtive=true;
        activePlayer =0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }
    int [][] winPos={
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8}
            ,{0,4,8},{2,4,6}
    };
    public void playerTap(View view){
        ImageView img=(ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(gameState[tappedImage]==2 && gameACtive ==true){
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer ==0){
                img.setImageResource(R.drawable.cross);
                activePlayer=1;
                TextView status=findViewById(R.id.status);
                status.setText("0's turn -tap to play");
            }
            else{
                img.setImageResource(R.drawable.zero);
                activePlayer=0;
                TextView status=findViewById(R.id.status);
                status.setText("X's turn -tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
//    check for win
        for (int []winpositions :winPos){
            if(gameState[winpositions[1]]==gameState[winpositions[1]]
                    &&gameState[winpositions[1]]==gameState[winpositions[2]]
                    && gameState[winpositions[0]]!=2){
                //somebody won -- finding who!
                String winnerStr;

                if(gameState[winpositions[0]]==0){
                    winnerStr ="x has won";

                }
                else {
                    winnerStr ="0 has won";

                }
//            winner announcemet status bar update
                TextView status=findViewById(R.id.status);
                status.setText(winnerStr);

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}