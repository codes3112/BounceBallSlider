package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane {
	
	public final double radius=20;
	private double x=radius,y=radius;
	private double dx=1,dy=1;
	private Circle circle=new Circle(x,y,radius);
	private Timeline animation;
	
	public BallPane() {
		circle.setFill(Color.GREEN);//set ball color
		getChildren().add(circle);// place a ball into this pane
		
		//create an animation for moving the ball
		
		animation=new Timeline(
				new KeyFrame(Duration.millis(50), e -> moveBall()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
	

	public void play() {
		animation.play();
	}
	
	public void pause() {
		animation.pause();
	}
	
	public void increaseSpeed() {
		animation.setRate(
				animation.getRate()+0.1);
	}
	
	public void deccreaseSpeed() {
		animation.setRate(
				
				animation.getRate()>0?animation.getRate()-0.1:0);
	}
	
	public DoubleProperty rateProperty() {
		return animation.rateProperty();
	}
	
	
	
	
	
	
	
	
	
	protected void moveBall() {
		//check boundaries
		if(x<radius||x>getWidth()-radius) {
			dx*=-1;// change ball move direction-change horizontal direction
		}
		
		if(y<radius||y>getHeight()-radius) {
			dy*=-1;//cahnge ball move direction - change vertical direction
			}
		
		//adjust ball position
		x+=dx;
		y+=dy;
		circle.setCenterX(x);
		circle.setCenterY(y);
	}

	
	
	

}
