package com.niq.niqactivateservice.model;/* Created by Indunil Prasanna */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shopper {

    @Id
    private String id;
    private String name;
}
