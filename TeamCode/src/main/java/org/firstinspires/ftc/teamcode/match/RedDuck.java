package org.firstinspires.ftc.teamcode.match;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous

public class RedDuck extends LinearOpMode {
    private DcMotor rightFront;
    private DcMotor rightRear;
    private DcMotor leftFront;
    private DcMotor leftRear;
    private CRServo flipper;
    private Servo   bucket;
    private DcMotor duck;
    //private DcMotor liftMotor;
    //add arm and arm2 and
    private DcMotor arm;

    @Override


    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        flipper = hardwareMap.get(CRServo.class,"flipper");
        bucket = hardwareMap.get(Servo.class,"bucket");
        arm = hardwareMap.get(DcMotor.class, "arm");

        duck = hardwareMap.get(DcMotor.class, "duck");
        // liftMotor = hardwareMap.get(DcMotor.class,"liftMotor");
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        telemetry.addData("Status", "Resetting Encoders");    //
        telemetry.update();
// Robot go vroom vroom
        while (opModeIsActive()) {

            //set motors to move to shipping tower.
            //straight
            //raise arm
            arms(-3000);
            //move off wall
            move(-450,-450,-450,-450);
            //turn toward goal
            move(328,328,-328,-328);
            //move forward to goal
            move(-610,-610,-610,-610);//change after shorten
            score();
            //back away from goal
            move(675,675,675,675);//change after shorten
            //turn back straight
            movefast(-350,-350,350,350);
            //back to wall
            move(650,650,650,650);
            down();



            sleep(5);
            //move off wall
            arms(-100);
            move(-100, -100, -100, -100);
            //turn
            move(900, 900, -900, -900);
            //move to duck wheel
            move(1100,1100,1100,1100);
            sleep(200);
            moveslow(110,110,110,110);
            move(-15,-15,15,15);
            duck(3500);



            movefast(-400,-400,-400,-400);
            //turn after duck
            move(150,150,-150,-150);
            //forward
            move(-500,-500,-500,-500);
            //strafe
            movefast(700, -700, -700, 700);//changed after shorten
            //go towards warehouse
            movefast(-1400,-1400,-1400,-1400);
            movefast(400, -400, -400, 400);//changed after shorten
            movefast(-1100,-1100,-1100,-1100);
            movefast(400, -400, -400, 400);
            movefast(-800,-800,-800,-800);
            sleep(5);

            move(-250,-250,250,250);
            move(-250,-250,-250,-250);
            sleep(13000);
            //move(-1000,-1000,-1000,-1000);



        }

    }

//=================movefast
public void movefast(int rf, int rb, int lf, int lb) {
    rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


    rightFront.setTargetPosition(rf);
    rightRear.setTargetPosition(rb);
    leftFront.setTargetPosition(lf);
    leftRear.setTargetPosition(lb);

    rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    leftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);


    rightRear.setPower(0.7);
    rightFront.setPower(0.7);

    leftFront.setPower(0.7);
    leftRear.setPower(0.7);

    while (leftFront.isBusy() && leftRear.isBusy() && rightFront.isBusy() && rightRear.isBusy()) {
        sleep(50);



    }
    rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    rightRear.setPower(0);
    leftFront.setPower(0);
    rightFront.setPower(0);
    leftRear.setPower(0);


}

    //----------------------------encoder-----------------
    public void move(int rf, int rb, int lf, int lb) {
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        rightFront.setTargetPosition(rf);
        rightRear.setTargetPosition(rb);
        leftFront.setTargetPosition(lf);
        leftRear.setTargetPosition(lb);

        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        rightRear.setPower(0.5);
        rightFront.setPower(0.5);

        leftFront.setPower(0.5);
        leftRear.setPower(0.5);

        while (leftFront.isBusy() && leftRear.isBusy() && rightFront.isBusy() && rightRear.isBusy()) {
            sleep(50);



        }
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightRear.setPower(0);
        leftFront.setPower(0);
        rightFront.setPower(0);
        leftRear.setPower(0);


    }

    //==========================duck
    public void duck(int time){
        duck.setPower(-.55);
        sleep(time);
        duck.setPower(0);




    }
    //----------------------ARMS------------
    public void arms(int encod) {
        // arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        arm.setTargetPosition(encod);

        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        arm.setPower(1);

        while (arm.isBusy()) {
            sleep(50);
        }

    }
    //================Score
    public void score() {
        sleep(1000);
        bucket.setPosition(0.5);
        sleep(500);
        flipper.setPower(-1);
        sleep(1500);
        flipper.setPower(0);
        sleep(500);
        bucket.setPosition(0.0);


    }
    //===================down
    public void down(){


        arm.setTargetPosition(-10);

        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        arm.setPower(-.5);

        while (arm.isBusy()) {
            sleep(50);
        }

    }
    //----------------------------MOVESLOW-----------------
    public void moveslow(int rf, int rb, int lf, int lb) {
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        rightFront.setTargetPosition(rf);
        rightRear.setTargetPosition(rb);
        leftFront.setTargetPosition(lf);
        leftRear.setTargetPosition(lb);

        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        rightRear.setPower(0.3);
        rightFront.setPower(0.3);

        leftFront.setPower(0.3);
        leftRear.setPower(0.3);

        while (leftFront.isBusy() && leftRear.isBusy() && rightFront.isBusy() && rightRear.isBusy()) {
            sleep(50);



        }
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightRear.setPower(0);
        leftFront.setPower(0);
        rightFront.setPower(0);
        leftRear.setPower(0);


    }

}

