package com.pactera.v2x.v2.ver2019.RSM;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.conv.OctetStringConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class ParticipantData {
  @NotNull
  @Component(0)
  public ParticipantType ptcType;
  
  @NotNull
  @Min(0L)
  @Max(65535L)
  @Component(1)
  public Integer ptcId;
  
  @NotNull
  @Component(2)
  public SourceType source;
  
  @Null
  @Size(min = 8, max = 8)
  @Component(3)
  public byte[] id;
  
  @NotNull
  @Component(4)
  public Integer secMark;
  
  @NotNull
  @Component(5)
  public PositionOffsetLLV pos;
  
  @NotNull
  @Component(6)
  public PositionConfidenceSet posConfidence;
  
  @Null
  @Component(7)
  public TransmissionState transmission;
  
  @NotNull
  @Component(8)
  public Integer speed;
  
  @NotNull
  @Component(9)
  public Integer heading;
  
  @Null
  @Component(10)
  public Integer angle;
  
  @Null
  @Component(11)
  public MotionConfidenceSet motionCfd;
  
  @Null
  @Component(12)
  public AccelerationSet4Way accelSet;
  
  @NotNull
  @Component(13)
  public VehicleSize size;
  
  @Null
  @Component(14)
  public VehicleClassification vehicleClass;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof ParticipantData))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static ParticipantData per_decode(boolean align, InputStream in) throws IOException {
    return (ParticipantData)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = RSM.type(65587);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(ParticipantData.class);
  
  static {
    AsnConverter ptcTypeConverter = ParticipantType.CONV;
    IntegerConverter integerConverter = IntegerConverter.INSTANCE;
    AsnConverter sourceConverter = SourceType.CONV;
    OctetStringConverter octetStringConverter = OctetStringConverter.INSTANCE;
    AsnConverter secMarkConverter = DSecond.CONV;
    CompositeConverter compositeConverter1 = PositionOffsetLLV.CONV;
    CompositeConverter compositeConverter2 = PositionConfidenceSet.CONV;
    AsnConverter transmissionConverter = TransmissionState.CONV;
    AsnConverter speedConverter = Speed.CONV;
    AsnConverter headingConverter = Heading.CONV;
    AsnConverter angleConverter = SteeringWheelAngle.CONV;
    CompositeConverter compositeConverter3 = MotionConfidenceSet.CONV;
    CompositeConverter compositeConverter4 = AccelerationSet4Way.CONV;
    CompositeConverter compositeConverter5 = VehicleSize.CONV;
    CompositeConverter compositeConverter6 = VehicleClassification.CONV;
    CONV.setComponentConverters(new AsnConverter[] { 
          ptcTypeConverter, (AsnConverter)integerConverter, sourceConverter, (AsnConverter)octetStringConverter, secMarkConverter, (AsnConverter)compositeConverter1, (AsnConverter)compositeConverter2, transmissionConverter, speedConverter, headingConverter, 
          angleConverter, (AsnConverter)compositeConverter3, (AsnConverter)compositeConverter4, (AsnConverter)compositeConverter5, (AsnConverter)compositeConverter6 });
  }
}
