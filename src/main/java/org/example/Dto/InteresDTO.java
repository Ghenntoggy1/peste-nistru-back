package org.example.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Interes.Interests;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InteresDTO {
    private Integer id;
    private String name;
    private Map<String, String> i18n;

    public static InteresDTO mapFromInterests(Interests interests){
        HashMap<String, String> map = new HashMap<>();
        map.put("ro",interests.getInterestRO());
        map.put("ru",interests.getInterestRU());
        map.put("en",interests.getInterestEN());
        return new InteresDTO(
                interests.getInterestId(),
                interests.getInterestRO(),
                map
        );
    }
}
