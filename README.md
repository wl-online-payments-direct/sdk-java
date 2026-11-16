# Online Payments Java SDK

## Introduction

The Java SDK helps you to communicate with the Online Payments Server API. Its primary features are:

* convenient Java wrapper around the API calls and responses
    * marshalls Java request objects to HTTP requests
    * unmarshalls HTTP responses to Java response objects or Java exceptions
* handling of all the details concerning authentication
* handling of required metadata

See the [Online Payments Developer Hub](https://docs.direct.worldline-solutions.com/documentation/sdk/server/java/) for more information on how to use the SDK.

## Structure of this repository

This repository consists out of four main components:

1. The source code of the SDK itself: `/src/main/java/` and `/src/main/generated/` 
2. The source code of the SDK unit tests: `/src/test/java/`
3. The source code of the integration tests: `/src/it/java/`

## Installation

Assuming you have [Maven](http://maven.apache.org/) installed, simply include the SDK as a Maven dependency:

    <dependency>
      <groupId>com.worldline-solutions</groupId>
      <artifactId>onlinepayments-sdk-java</artifactId>
      <version>x.y.z</version>
    </dependency>

Alternatively, download the latest version of the SDK from GitHub. Choose the `onlinepayments-sdk-java-x.y.z-bin.zip` file from the [releases](https://github.com/Online-Payments/sdk-java/releases) page, where `x.y.z` is the version number. Add all JAR files inside the `lib` folder of this file to your project, except for `onlinepayments-sdk-java-x.y.z-javadoc.jar` and `onlinepayments-sdk-java-x.y.z-sources.jar`.

## Working with AI agents

The SDK comes with an agent skill for AI coding agents such as Claude Code, Codex, GitHub Copilot and Cursor. It tells the agent how to choose an integration method, which steps each flow needs, which rules every integration must follow, and gives code examples that are compiled against this SDK version.

The skill for this version is available:

* online, as plain Markdown for agents: https://raw.githubusercontent.com/wl-online-payments-direct/sdk-java/11.1.0/skills/worldline-direct/SKILL.md
* online, on GitHub: https://github.com/wl-online-payments-direct/sdk-java/blob/11.1.0/skills/worldline-direct/SKILL.md
* in the JAR and the sources JAR: `META-INF/skills/worldline-direct/`, for example in `~/.m2/repository/com/worldline-solutions/onlinepayments-sdk-java/<version>/onlinepayments-sdk-java-<version>.jar`
* in this repository: `skills/worldline-direct/`

To make your agent use it, add this to the `AGENTS.md` or `CLAUDE.md` file of your project:

```
For the Worldline Direct integration (com.worldline-solutions:onlinepayments-sdk-java), read and follow the agent skill
https://raw.githubusercontent.com/wl-online-payments-direct/sdk-java/11.1.0/skills/worldline-direct/SKILL.md
Use the code shown in the skill; do not write SDK calls from memory.
```

Use the link from the README of the SDK version you have installed. Agents that support the Agent Skills format can also load the folder directly, for example by copying `skills/worldline-direct/` to `.claude/skills/worldline-direct/` in your project for Claude Code.

## Building the repository

This repository uses [Maven](http://maven.apache.org/) to build. To build the SDK, execute the following command from its root directory (which contains the `pom.xml` file):

    mvn clean package

The build will generate the following files in the `target` directory, where `x.y.z` is the version number:
* `onlinepayments-sdk-java-x.y.z.jar`, containing the compiled class files
* `onlinepayments-sdk-java-x.y.z-javadoc.jar`, containing the generated Javadoc
* `onlinepayments-sdk-java-x.y.z-sources.jar`, containing the source code
* `onlinepayments-sdk-java-x.y.z-src.zip`, containing the contents of this folder
* `onlinepayments-sdk-java-x.y.z-bin.zip`, containing the necessary JAR files for standalone deployments

To use it add all JAR files inside the `lib` folder of the `onlinepayments-sdk-java-x.y.z-bin.zip` file to your project, except for `onlinepayments-sdk-java-x.y.z-javadoc.jar` and `onlinepayments-sdk-java-x.y.z-sources.jar`.
