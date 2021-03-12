package commons.util;

import java.util.UUID;

public class IdHelper {
    private static final Snowflake SNOWFLAKE = new Snowflake(0);

    public static Long id() {
        return Long.valueOf(SNOWFLAKE.next());
    }

    public static String uuid() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }
}

