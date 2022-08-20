
package llax.stream.station;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Planet {
    long id;
    String name;
    double mass;
    HabitatStatus habitatStatus;
}
