package All.Commands.Limelight;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.command.InstantCommand;

import All.Subsystems.Drive;
import All.Subsystems.Limelight;

public class RecalibratePose extends InstantCommand {

    public RecalibratePose (Limelight limelight) {super (limelight::recalibratePose, limelight);}

}
