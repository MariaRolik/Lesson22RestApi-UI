package configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/user.properties"
})
public interface UserConfig extends Config {

    String userName();

    String password();




}