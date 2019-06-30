package jupyter.core.jdbc.config;

import lombok.Data;

@Data
public class DataSourceHubProps {
    private String hibernateDialect;
    private String hibernatePhysicalNamingStrategy;
    private String hibernateHbm2ddlAuto;
    private String hibernateIdNewGeneratorMappings;

    private String hibernateConnectionProviderDisablesAutocommit;
    private String hibernateCacheUseSecondLevelCache;
    private String hibernateCacheUseQueryCache;

    private String hibernateFormatSql;
    private String hibernateGenerateStatistics;
    private String hibernateType;

}
