// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.List;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
  private PhotonCamera visionCamera = new PhotonCamera("limelight");

  private PhotonPipelineResult cameraResults;

  /** Creates a new VisionSubsystem. */
  public VisionSubsystem() {
  }

  boolean hasTargets() {
    return cameraResults.hasTargets();
  }

  List<PhotonTrackedTarget> getCameraTargets() {
    return cameraResults.getTargets();
  }

  PhotonTrackedTarget getBestTarget() {
    return cameraResults.getBestTarget();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    cameraResults = visionCamera.getLatestResult();
  }
}
