package com.pactera.v2x.v2.ver2019.MapSpeedLimit;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ReflectionEnumeratedConverter;
import org.asnlab.asndt.runtime.type.AsnType;

public enum SpeedLimitType {
  unknown(0),
  maxSpeedInSchoolZone(1),
  maxSpeedInSchoolZoneWhenChildrenArePresent(2),
  maxSpeedInConstructionZone(3),
  vehicleMinSpeed(4),
  vehicleMaxSpeed(5),
  vehicleNightMaxSpeed(6),
  truckMinSpeed(7),
  truckMaxSpeed(8),
  truckNightMaxSpeed(9),
  vehiclesWithTrailersMinSpeed(10),
  vehiclesWithTrailersMaxSpeed(11),
  vehiclesWithTrailersNightMaxSpeed(12);
  
  private int value;
  
  public static final AsnType TYPE;
  
  public static final AsnConverter CONV;
  
  SpeedLimitType(int value) {
    this.value = value;
  }
  
  public int value() {
    return this.value;
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static SpeedLimitType per_decode(boolean align, InputStream in) throws IOException {
    return (SpeedLimitType)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  static {
    TYPE = MapSpeedLimit.type(65537);
    CONV = (AsnConverter)new ReflectionEnumeratedConverter(SpeedLimitType.class);
  }
}
