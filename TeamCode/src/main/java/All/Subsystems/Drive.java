package All.Subsystems;

import com.pedropathing.follower.Follower;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

// import All.Configs.Robot.PP.Constants;

public class Drive extends SubsystemBase {

    // MOTORS
    private final DcMotorEx LMF, LMB, RMF, RMB;

    // LOCALIZATION
    private final GoBildaPinpointDriver pinpoint;
    //private final Follower follower;

    // DRIVE CONSTANTS
    private double driveSpeed = 0.95;
    private double currentHeadingRad = 0.0;
    private double headingOffSet = 0.0;
    private static final double INIT_FIELD_OFFSET = Math.PI;
    private boolean headingInit = false;


    public Drive(HardwareMap hwMap) {
        LMF = hwMap.get(DcMotorEx.class, "LMF");
        LMB = hwMap.get(DcMotorEx.class, "LMB");
        RMF = hwMap.get(DcMotorEx.class, "RMF");
        RMB = hwMap.get(DcMotorEx.class, "RMB");

        LMF.setDirection(DcMotorEx.Direction.REVERSE);
        LMB.setDirection(DcMotorEx.Direction.REVERSE);

        pinpoint = hwMap.get(GoBildaPinpointDriver.class, "pinpoint");

        //follower = Constants.createFollower(hwMap);

    }

    // PERIODIC
    @Override
    public void periodic() {

        currentHeadingRad = pinpoint.getHeading(AngleUnit.RADIANS);

        if (!headingInit) {
            headingOffSet = currentHeadingRad -INIT_FIELD_OFFSET;
            headingInit = true;
        }

    }

    // public void updatePinpoint() {follower.update();}

    public void resetFieldOrietation() {headingOffSet = currentHeadingRad;}

    public void drive(double x, double y, double turn) {

        double robotHeading = currentHeadingRad - headingOffSet;

    }

}
