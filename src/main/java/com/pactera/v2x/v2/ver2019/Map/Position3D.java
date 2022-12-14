package com.pactera.v2x.v2.ver2019.Map;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.asnlab.asndt.runtime.conv.AnnotationCompositeConverter;
import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.CompositeConverter;
import org.asnlab.asndt.runtime.conv.annotation.Component;
import org.asnlab.asndt.runtime.type.AsnType;

public class Position3D {
  @NotNull
  @Component(0)
  public Integer lat;
  
  @NotNull
  @Component(1)
  public Integer long_;
  
  @Null
  @Component(2)
  public Integer elevation;
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Position3D))
      return false; 
    return TYPE.equals(this, obj, (AsnConverter)CONV);
  }
  
  public void per_encode(boolean align, OutputStream out) throws IOException {
    TYPE.encode(this, (byte) (align ? 4 : 3), (AsnConverter)CONV, out);
  }
  
  public static Position3D per_decode(boolean align, InputStream in) throws IOException {
    return (Position3D)TYPE.decode(in, (byte) (align ? 4 : 3), (AsnConverter)CONV);
  }
  
  public static final AsnType TYPE = Map.type(262153);
  
  public static final CompositeConverter CONV = (CompositeConverter)new AnnotationCompositeConverter(Position3D.class);
  
  static {
    AsnConverter latConverter = Latitude.CONV;
    AsnConverter long_Converter = Longitude.CONV;
    AsnConverter elevationConverter = Elevation.CONV;
    CONV.setComponentConverters(new AsnConverter[] { latConverter, long_Converter, elevationConverter });
  }
}
