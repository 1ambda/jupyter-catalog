package jupyter.common.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Time {

    // TODO: based on configuration
    public static final ZoneId LocalZoneId = ZoneId.of("Asia/Seoul");

    public static LocalDateTime getCurrentLocalDateTimeFromEpochMillis(long epochMillis) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMillis), LocalZoneId);
    }

    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.ofInstant(Instant.now(), LocalZoneId);
    }

    public static Long convertToEpochMillis(LocalDateTime localDateTime) {
        return localDateTime.atZone(LocalZoneId).toInstant().toEpochMilli();
    }

}
