package com.pactera.v2x.v2.ver2019.SPATIntersectionState;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class IntersectionState {
  @NotNull
  @Component(0)
  public NodeReferenceID intersectionId;
  
  @NotNull
  @Component(1)
  public IntersectionStatusObject status;
  
  @Null
  @Component(2)
  public Integer moy;
  
  @Null
  @Component(3)
  public Integer timeStamp;
  
  @Null
  @Component(4)
  public TimeConfidence timeConfidence;
  
  @NotNull
  @Component(5)
  public Vector<Phase> phases;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof IntersectionState))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static IntersectionState per_decode(boolean align, InputStream in) throws IOException {
    return (IntersectionState)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = SPATIntersectionState.type(65555);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(IntersectionState.class);
  
  static {
    CompositeConverter compositeConverter = NodeReferenceID.CONV;
    AsnConverter statusConverter = IntersectionStatusObject.CONV;
    AsnConverter moyConverter = MinuteOfTheYear.CONV;
    AsnConverter timeStampConverter = DSecond.CONV;
    AsnConverter timeConfidenceConverter = TimeConfidence.CONV;
    AsnConverter phasesConverter = PhaseList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { (AsnConverter)compositeConverter, statusConverter, moyConverter, timeStampConverter, timeConfidenceConverter, phasesConverter });
  }
}
