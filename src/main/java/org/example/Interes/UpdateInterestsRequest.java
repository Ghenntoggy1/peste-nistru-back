package org.example.Interes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInterestsRequest {
    private Integer userId;
    private Integer[] interests;
}
