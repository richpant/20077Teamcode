package org.firstinspires.ftc.teamcode.OpModes;

import static java.lang.Math.*;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous

public class OldEncode extends LinearOpMode {
    private DcMotor rightFront;
    private DcMotor rightRear;
    private DcMotor leftFront;
    private DcMotor leftRear;
   // private Servo flipper;
    private DcMotor arm;
    private DcMotor arm2;

    @Override


    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        //flipper = hardwareMap.get(Servo.class,"flipper");
        arm = hardwareMap.get(DcMotor.class,"arm");
        arm2 = hardwareMap.get(DcMotor.class, "arm2");
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
        arm2.setDirection(DcMotorSimple.Direction.REVERSE);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        waitForStart();
        telemetry.addData("Status", "Resetting Encoders");    //
        telemetry.update();

        while (opModeIsActive()) {
            richmove(1000, 1000, 1000, 1000);

           arm(20);




            sleep(4000);
            /*rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            rightFront.setTargetPosition(3000);
            rightRear.setTargetPosition(3000);
            leftFront.setTargetPosition(-3000);
            leftRear.setTargetPosition(-3000);

            rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);



            rightRear.setPower(0.6);
            rightFront.setPower(0.6);
            leftFront.setPower(0.6);
            leftRear.setPower(0.6);

           // leftFront.setPower(leftFront/ Math.abs(.6));
            //leftRear.setPower(lb/(Math.abs(lb)));

            while(leftFront.isBusy() && leftRear.isBusy() && rightFront.isBusy() && rightRear.isBusy()){
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
*/


        }

    }


    //----------------------------encoder-----------------
    public void richmove(int rf, int rb, int lf, int lb) {
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData("Path0",  "Starting at %7d :%7d",
                rightFront.getCurrentPosition(),
                rightRear.getCurrentPosition(),
                leftRear.getCurrentPosition(),
                leftFront.getCurrentPosition());
        telemetry.update();

        rightFront.setTargetPosition(rf);
        rightRear.setTargetPosition(rb);
        leftFront.setTargetPosition(lf);
        leftRear.setTargetPosition(lb);

        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        rightRear.setPower(0.6);
        rightFront.setPower(0.6);

        leftFront.setPower(0.6);
        leftRear.setPower(0.6);

        while (leftFront.isBusy() && leftRear.isBusy() && rightFront.isBusy() && rightRear.isBusy()) {
            sleep(50);

            telemetry.addData("Path1",  "Running to %7d :%7d", rf,lf,rb,lb);
            telemetry.addData("Path2",  "Running at %7d :%7d",
                    rightFront.getCurrentPosition(),
                    rightRear.getCurrentPosition(),
                    leftRear.getCurrentPosition(),
                    leftFront.getCurrentPosition());

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



    //----------------------Lift------------
    public void arm(int encod){
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        arm.setTargetPosition(encod);
        arm2.setTargetPosition(encod);

      arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        arm.setPower(-.3);
        arm2.setPower(0.3);
        while (arm.isBusy ()&& arm2.isBusy()){
            sleep(50);
            telemetry.addData("Path1",  "Running to %7d :%7d", encod);
            telemetry.addData("Path2",  "Running at %7d :%7d",
                    arm.getCurrentPosition(),
                   arm2.getCurrentPosition());

        }
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setPower(0);
        arm2.setPower(0);
    }
}

