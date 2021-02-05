package org.jai.kissan.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.jai.kissan.commonutils.sequence.generator.StringPrefixedSequenceIdGenerator;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "farmers")
public class FarmerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "farmer_identity_seq")
    @GenericGenerator(
            name = "farmer_identity_seq",
            strategy = StringPrefixedSequenceIdGenerator.STRING_PREFIXED_SEQUENCE_ID_GENERATOR_CLASS_NAME,
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "FarmerID_"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%09d")})
    private String identityCode;

    private String name;
    private String address;
    private String contactNumber;

    @Column(unique = true)
    private String aadharNumber;

}
