# Large Scale Android App

Proof of concept architecture for a (very) large android application. Designed to handle 100+ modules
in a single project, while providing reasonably build speed, and as much isolation between modules
as possible.

## Main features:
- modules with contracts: big feature modules can reference each other, while still being compiled
  in parallel.
- plug & play architecture: no kotlin/java required to add or configure a feature module. Just
  a single line in gradle build script.
- app module without any code: the less code you have in root module, the faster the compilation is.
- shared logic in gradle build files: update configuration for multiple modules at once, add complex
  features with just one line of code
- heavy use of cache: for the fastest compilation possible

## Other nice features:
- UI in Jetpack Compose
- gradle version catalog & typesafe project accessors
- easy versioning, thanks to Axion plugin
- generate project module graph, thanks to ModuleGraphAssert plugin
- check if project is up to date, thanks to GradleVersionsFilter plugin

## Nice to know Gradle tasks:
- `./gradlew wrapper --gradle-version X.Y.Z` - update Gradle to version X.Y.Z
- `./gradlew generateModulesGraphvizText` - view module graph for project
- `./gradlew dependencyUpdates` - check if new library versions are available
