package com.medblocks;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.UUID;

import org.ehrbase.openehr.sdk.client.openehrclient.CompositionEndpoint;
import org.ehrbase.openehr.sdk.client.openehrclient.OpenEhrClientConfig;
import org.ehrbase.openehr.sdk.client.openehrclient.defaultrestclient.DefaultRestClient;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.Category;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.Language;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.Setting;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.Territory;
import org.ehrbase.openehr.sdk.response.dto.TemplatesResponseData;

import com.medblocks.vitalsignsv1composition.VitalSignsV1Composition;
import com.medblocks.vitalsignsv1composition.definition.BloodPressureObservation;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartySelf;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating composition");
        OpenEhrClientConfig clientConfig = new OpenEhrClientConfig(URI.create("http://localhost:8080/ehrbase/"));
         DefaultRestClient client = new DefaultRestClient(clientConfig);
         VitalSignsV1Composition composition = new VitalSignsV1Composition();
         LocalDateTime now = LocalDateTime.now();
         BloodPressureObservation bloodPressureObservation = new BloodPressureObservation();
         bloodPressureObservation.setSystolicMagnitude(120.0);
         bloodPressureObservation.setDiastolicMagnitude(80.0);
         bloodPressureObservation.setDiastolicUnits("mm[Hg]");
         bloodPressureObservation.setSystolicUnits("mm[Hg]");
         bloodPressureObservation.setTimeValue(now);
         bloodPressureObservation.setOriginValue(now);
         bloodPressureObservation.setSubject(new PartySelf());
         bloodPressureObservation.setLanguage(Language.EN);
         composition.setBloodPressure(bloodPressureObservation);
         composition.setLanguage(Language.EN);
         composition.setSettingDefiningCode(Setting.OTHER_CARE);
         composition.setStartTimeValue(now);
         composition.setTerritory(Territory.US);

         PartyIdentified composer = new PartyIdentified();
         composer.setName("Sidharth Ramesh");
         composition.setComposer(composer);
         
         CompositionEndpoint compositionEndpoint = client.compositionEndpoint(UUID.fromString("1bdea245-c51f-4522-a802-10b7af1d349a"));
         VitalSignsV1Composition savedComposition = compositionEndpoint.mergeCompositionEntity(composition);
         System.out.println(savedComposition.getVersionUid().getValue());
    }
}
