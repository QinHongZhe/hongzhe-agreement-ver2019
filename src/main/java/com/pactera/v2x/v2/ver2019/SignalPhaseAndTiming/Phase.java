package com.pactera.v2x.v2.ver2019.SignalPhaseAndTiming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.validation.constraints.NotNull;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class Phase {
  @NotNull
  @Component(0)
  public Integer id;
  
  @NotNull
  @Component(1)
  public Vector<PhaseState> phaseStates;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Phase))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static Phase per_decode(boolean align, InputStream in) throws IOException {
    return (Phase)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = SignalPhaseAndTiming.type(262157);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(Phase.class);
  
  static {
    AsnConverter idConverter = PhaseID.CONV;
    AsnConverter phaseStatesConverter = PhaseStateList.CONV;
    CONV.setComponentConverters(new AsnConverter[] { idConverter, phaseStatesConverter });
  }
}
