package ladder.controller;

import ladder.domain.Height;
import ladder.domain.LadderCreator;
import ladder.domain.Ladders;
import ladder.domain.Participants;
import ladder.domain.strategy.RandomPointGenerationStrategy;
import ladder.view.input.InputHeightView;
import ladder.view.input.InputNamesView;
import ladder.view.output.OutputLaddersView;
import ladder.view.output.OutputNamesView;

public class LadderController {

  public static void main (String[] args) {
    Participants participants = InputNamesView.scanPlayerNames();
    Height height = InputHeightView.scanLadderHeight();

    LadderCreator ladderCreator = new LadderCreator(height, participants);
    Ladders ladders = ladderCreator.createLadders(new RandomPointGenerationStrategy());

    OutputNamesView.printParticipantsNames(participants);
    OutputLaddersView.printRow(ladders);
  }

}