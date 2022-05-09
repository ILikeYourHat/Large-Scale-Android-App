package pl.softwarealchemy.lsaa.core.engine

@Suppress("unused")
public class Initializer : ModuleInitializer(
    {
        single { TopActivityProvider() }
    }
)
