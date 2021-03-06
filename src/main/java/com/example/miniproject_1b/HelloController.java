package com.example.miniproject_1b;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.security.Key;
import java.util.concurrent.atomic.AtomicInteger;


public class HelloController {

    boolean isReady=false;
    @FXML
    private ImageView foreHand;
    @FXML
    private ImageView backHand;

    public ImageView umpire;
    public Image stop;
    public Image ready;

    public Image fist;
    public Image five;
    public Image four;
    public Image three;
    public Image two;
    public Image one;
    public Image zero;

    @FXML
    protected void setAnimation() {
        isReady=!isReady;
        //both hands can be used with same or opposite values
        KeyValue foreTurn0 = new KeyValue(foreHand.rotateProperty(), 0);
        KeyValue foreTurn1 = new KeyValue(foreHand.rotateProperty(), 23);
        KeyValue foreTurn2 = new KeyValue(foreHand.rotateProperty(), 35);
        KeyValue foreTurn3 = new KeyValue(foreHand.rotateProperty(), 50);

        KeyValue foreMoveX0 = new KeyValue(foreHand.translateXProperty(),0);
        KeyValue foreMoveX1 = new KeyValue(foreHand.translateXProperty(),6);
        KeyValue foreMoveX2 = new KeyValue(foreHand.translateXProperty(),25);
        KeyValue foreMoveX3 = new KeyValue(foreHand.translateXProperty(),56);

        KeyValue foreMoveY0 = new KeyValue(foreHand.translateYProperty(),0);
        KeyValue foreMoveY1 = new KeyValue(foreHand.translateYProperty(),-6);
        KeyValue foreMoveY2 = new KeyValue(foreHand.translateYProperty(),-25);
        KeyValue foreMoveY3 = new KeyValue(foreHand.translateYProperty(),-67);

        KeyValue backTurn0 = new KeyValue(backHand.rotateProperty(), 0);
        KeyValue backTurn1 = new KeyValue(backHand.rotateProperty(), 23);
        KeyValue backTurn2 = new KeyValue(backHand.rotateProperty(), 35);
        KeyValue backTurn3 = new KeyValue(backHand.rotateProperty(), 50);

        KeyValue backMoveX0 = new KeyValue(backHand.translateXProperty(),0);
        KeyValue backMoveX1 = new KeyValue(backHand.translateXProperty(),6);
        KeyValue backMoveX2 = new KeyValue(backHand.translateXProperty(),25);
        KeyValue backMoveX3 = new KeyValue(backHand.translateXProperty(),56);

        KeyValue backMoveY0 = new KeyValue(backHand.translateYProperty(),0);
        KeyValue backMoveY1 = new KeyValue(backHand.translateYProperty(),-6);
        KeyValue backMoveY2 = new KeyValue(backHand.translateYProperty(),-25);
        KeyValue backMoveY3 = new KeyValue(backHand.translateYProperty(),-67);

        KeyValue showFore=new KeyValue(foreHand.imageProperty(),three);
        KeyValue showBack=new KeyValue(backHand.imageProperty(),three);

        KeyValue readyUmp=new KeyValue(umpire.imageProperty(),stop);
        KeyValue playUmp=new KeyValue(umpire.imageProperty(),ready);


        /*KeyValue backTurn0 = new KeyValue(backHand.rotateProperty(), 0);
        KeyValue backTurn1 = new KeyValue(backHand.rotateProperty(), 18);
        KeyValue backTurn2 = new KeyValue(backHand.rotateProperty(), 35);

        KeyValue backMoveX0 = new KeyValue(backHand.translateXProperty(),0);
        KeyValue backMoveX1 = new KeyValue(backHand.translateXProperty(),3);
        KeyValue backMoveX2 = new KeyValue(backHand.translateXProperty(),22);

        KeyValue backMoveY0 = new KeyValue(backHand.translateYProperty(),0);
        KeyValue backMoveY1 = new KeyValue(backHand.translateYProperty(),-52);
        KeyValue backMoveY2 = new KeyValue(backHand.translateYProperty(),-100);*/

        /*KeyValue foreTurn0 = new KeyValue(foreHand.rotateProperty(), 0);
        KeyValue foreTurn1 = new KeyValue(foreHand.rotateProperty(), 18);
        KeyValue foreTurn2 = new KeyValue(foreHand.rotateProperty(), 35);

        KeyValue foreMoveX0 = new KeyValue(foreHand.translateXProperty(),0);
        KeyValue foreMoveX1 = new KeyValue(foreHand.translateXProperty(),3);
        KeyValue foreMoveX2 = new KeyValue(foreHand.translateXProperty(),22);

        KeyValue foreMoveY0 = new KeyValue(foreHand.translateYProperty(),0);
        KeyValue foreMoveY1 = new KeyValue(foreHand.translateYProperty(),-52);
        KeyValue foreMoveY2 = new KeyValue(foreHand.translateYProperty(),-100);*/

        KeyFrame play=new KeyFrame(Duration.seconds(0.2),playUmp);
        KeyFrame stopPlay=new KeyFrame(Duration.seconds(0.1),readyUmp);

        KeyFrame mvtUp=new KeyFrame(Duration.seconds(0.15),foreTurn1,foreMoveX1,foreMoveY1,backTurn1,backMoveX1,backMoveY1,foreTurn2,foreMoveX2,foreMoveY2,backTurn2,backMoveX2,backMoveY2);
        KeyFrame mvtDn=new KeyFrame(Duration.seconds(0.15),foreTurn1,foreMoveX1,foreMoveY1,backTurn1,backMoveX1,backMoveY1,foreTurn0,foreMoveX0,foreMoveY0,backTurn0,backMoveX0,backMoveY0);

        KeyFrame showUp=new KeyFrame(Duration.seconds(0.2),foreTurn1,foreMoveX1,foreMoveY1,backTurn1,backMoveX1,backMoveY1,foreTurn2,foreMoveX2,foreMoveY2,backTurn2,backMoveX2,backMoveY2,foreTurn3,foreMoveX3,foreMoveY3,backTurn3,backMoveX3,backMoveY3);
        KeyFrame showDn=new KeyFrame(Duration.seconds(0.3),foreTurn2,foreMoveX2,foreMoveY2,backTurn2,backMoveX2,backMoveY2,foreTurn1,foreMoveX1,foreMoveY1,backTurn1,backMoveX1,backMoveY1,foreTurn0,foreMoveX0,foreMoveY0,backTurn0,backMoveX0,backMoveY0);
        KeyFrame show=new KeyFrame(Duration.seconds(0.2),showFore,showBack);

        Timeline startMove=new Timeline(play);
        startMove.setDelay(Duration.seconds(1));
        Timeline stopMove=new Timeline(stopPlay);
        Timeline moveUp=new Timeline(mvtUp);
        Timeline moveDown=new Timeline(mvtDn);
        Timeline showingUp=new Timeline(showUp);
        Timeline showDown=new Timeline(showDn);
        Timeline showHand=new Timeline(show);
        Timeline reset=new Timeline(new KeyFrame(Duration.seconds(0.2),new KeyValue(foreHand.imageProperty(),fist),new KeyValue(backHand.imageProperty(),fist)));
        reset.setDelay(Duration.seconds(0.5));

        startMove.setOnFinished(e->moveUp.play());
        AtomicInteger n= new AtomicInteger(3);
        moveUp.setOnFinished(e ->{
            n.getAndDecrement();
            moveDown.play();
        });
        moveDown.setOnFinished(e->{
            if(n.get() > 0)
                moveUp.play();
            else {
                //stopMove.play();
                showingUp.play();
            }
        });
        showingUp.setOnFinished(e->stopMove.play());
        stopMove.setOnFinished(e->{
            showDown.play();
            showHand.play();
        });
        showDown.setOnFinished(e->reset.play());
        reset.setOnFinished(e->{
            n.set(3);
            if(isReady)
                startMove.play();
        });
        if(isReady)
            startMove.playFromStart();
    }
}