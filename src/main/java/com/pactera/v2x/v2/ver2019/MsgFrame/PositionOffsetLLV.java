package com.pactera.v2x.v2.ver2019.MsgFrame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.ChoiceConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class PositionOffsetLLV {
  @NotNull
  @Component(0)
  public PositionOffsetLL offsetLL;
  
  @Null
  @Component(1)
  public VerticalOffset offsetV;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof PositionOffsetLLV))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static PositionOffsetLLV per_decode(boolean align, InputStream in) throws IOException {
    return (PositionOffsetLLV)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(786489);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(PositionOffsetLLV.class);
  
  static {
    ChoiceConverter choiceConverter1 = PositionOffsetLL.CONV;
    ChoiceConverter choiceConverter2 = VerticalOffset.CONV;
    CONV.setComponentConverters(new AsnConverter[] { (AsnConverter)choiceConverter1, (AsnConverter)choiceConverter2 });
  }
}
