package edu.cnm.deepdive.craps;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RollsAdapter extends ArrayAdapter<Roll> {

  private Game game;

  public RollsAdapter(@NonNull Context context, int resource) {
    super(context, resource);
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    Roll roll = getItem(position);
    LayoutInflater inflater = LayoutInflater.from(getContext());
    TextView rollView = (TextView) inflater.inflate(R.layout.item_roll, null);
    rollView.setText(roll.toString());
    if (game.getState() == State.WIN) {
      rollView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.win_background));
    } else {
      rollView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.loss_background));
    }
    return rollView;
  }

  public void setGame(Game game) {
    this.game = game;
  }

}
