package org.jai.kissan.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.jai.kissan.commonutils.sequence.generator.StringPrefixedSequenceIdGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "crops")
public class CropEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crop_identity_seq")
    @GenericGenerator(
            name = "crop_identity_seq",
            strategy = StringPrefixedSequenceIdGenerator.STRING_PREFIXED_SEQUENCE_ID_GENERATOR_CLASS_NAME,
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CropID_"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%09d") })
    private String identityCode;

    private String name;
}
