# AGENTS.md

## Using this SDK in your project

If you are writing code that integrates Worldline Direct with this SDK, read the agent skill
for this SDK version first and use the code it shows. Do not write SDK calls from memory.

- Online: https://raw.githubusercontent.com/wl-online-payments-direct/sdk-java/11.1.0/skills/worldline-direct/SKILL.md

The skill is in this repository at `skills/worldline-direct/`.
The skill matches SDK version 11.1.0. If your installed version is different, use the skill
from the tag of your installed version.

## Working on this SDK

- SDK source: `src/main/java/` and `src/main/generated/`; unit tests: `src/test/java/`;
  integration tests: `src/it/java/`.
- Build with Maven from the repository root: `mvn clean package`. The JAR files are written to `target/`.
- See `README.md` for details.
