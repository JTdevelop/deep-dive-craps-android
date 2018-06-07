package edu.cnm.deepdive.craps;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.security.SecureRandom;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

  private Game game;
  private Button play;
  private ListView rolls;
  private Random rng;
  private RollsAdapter rollsAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    play = findViewById(R.id.play_game);
    rolls = findViewById(R.id.game_rolls);
    game = new Game();
    rng = new SecureRandom();
    rollsAdapter = new RollsAdapter(this, R.layout.item_roll);
    rollsAdapter.setGame(game);
    play.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        game.reset();
        game.play(rng);
        rollsAdapter.clear();
        rollsAdapter.addAll(game.getRolls());
        rolls.setAdapter(rollsAdapter);

      }
    });
  }
}
