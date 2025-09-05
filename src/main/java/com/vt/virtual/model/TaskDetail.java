package com.vt.virtual.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(exclude = {"productionDivisions"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TaskDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sharedDate;
    private String jobDescription;
    private String accountName;
    private String taskName;
    private String taskCity;
    private String taskCode;
    private String taskStartDate;
    private String taskEndDate;
    @Column(length = 2000)
    private String taskSkills;
    private String taskFulfillmentStep;
}
