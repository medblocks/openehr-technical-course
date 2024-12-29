package com.medblocks.vitalsignsv1composition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import java.lang.Double;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.NullFlavour;

@Generated(
    value = "org.ehrbase.openehr.sdk.generator.ClassGenerator",
    date = "2024-12-28T20:48:47.949114+05:30",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 2.20.0"
)
public interface PulseHeartBeatAnyEventChoice {
  FeederAudit getFeederAudit();

  void setFeederAudit(FeederAudit feederAudit);

  NullFlavour getRateNullFlavourDefiningCode();

  void setRateNullFlavourDefiningCode(NullFlavour rateNullFlavourDefiningCode);

  List<Cluster> getExertion();

  void setExertion(List<Cluster> exertion);

  TemporalAccessor getTimeValue();

  void setTimeValue(TemporalAccessor timeValue);

  String getRateUnits();

  void setRateUnits(String rateUnits);

  Double getRateMagnitude();

  void setRateMagnitude(Double rateMagnitude);
}
