package com.medblocks.vitalsignsv1composition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.openehr.sdk.generator.commons.aql.containment.Containment;
import org.ehrbase.openehr.sdk.generator.commons.aql.field.AqlFieldImp;
import org.ehrbase.openehr.sdk.generator.commons.aql.field.ListAqlFieldImp;
import org.ehrbase.openehr.sdk.generator.commons.aql.field.ListSelectAqlField;
import org.ehrbase.openehr.sdk.generator.commons.aql.field.SelectAqlField;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.Language;

public class PulseHeartBeatObservationContainment extends Containment {
  public SelectAqlField<PulseHeartBeatObservation> PULSE_HEART_BEAT_OBSERVATION = new AqlFieldImp<PulseHeartBeatObservation>(PulseHeartBeatObservation.class, "", "PulseHeartBeatObservation", PulseHeartBeatObservation.class, this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE = new AqlFieldImp<TemporalAccessor>(PulseHeartBeatObservation.class, "/data[at0002]/origin|value", "originValue", TemporalAccessor.class, this);

  public SelectAqlField<Cluster> DEVICE = new AqlFieldImp<Cluster>(PulseHeartBeatObservation.class, "/protocol[at0010]/items[at1013]", "device", Cluster.class, this);

  public ListSelectAqlField<Cluster> EXTENSION = new ListAqlFieldImp<Cluster>(PulseHeartBeatObservation.class, "/protocol[at0010]/items[at1056]", "extension", Cluster.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(PulseHeartBeatObservation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(PulseHeartBeatObservation.class, "/language", "language", Language.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(PulseHeartBeatObservation.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  public ListSelectAqlField<PulseHeartBeatAnyEventChoice> ANY_EVENT = new ListAqlFieldImp<PulseHeartBeatAnyEventChoice>(PulseHeartBeatObservation.class, "/data[at0002]/events[at0003]", "anyEvent", PulseHeartBeatAnyEventChoice.class, this);

  private PulseHeartBeatObservationContainment() {
    super("openEHR-EHR-OBSERVATION.pulse.v2");
  }

  public static PulseHeartBeatObservationContainment getInstance() {
    return new PulseHeartBeatObservationContainment();
  }
}
