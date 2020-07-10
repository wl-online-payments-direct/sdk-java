# Ingenico Direct Java SDK

## Introduction

The Java SDK helps you to communicate with the [Ingenico Direct](https://support.direct.ingenico.com/) Server API. Its primary features are:

* convenient Java wrapper around the API calls and responses
    * marshalls Java request objects to HTTP requests
    * unmarshalls HTTP responses to Java response objects or Java exceptions
* handling of all the details concerning authentication
* handling of required meta data

Its use is demonstrated by an example for each possible call. The examples execute a call using the provided API keys. 

See the [Ingenico Direct Developer Hub](https://support.direct.ingenico.com/documentation/sdk/server/java/) for more information on how to use the SDK.

## Structure of this repository

This repository consists out of four main components:

1. The source code of the SDK itself: `/src/main/java/` and `/src/main/generated/` 
2. The source code of the SDK unit tests: `/src/test/java/`
3. The source code of the example integration tests: `/src/it/java/`

## Installation

Assuming you have [Maven](http://maven.apache.org/) installed, simply include the SDK as a Maven dependency:

    <dependency>
      <groupId>com.ingenico.direct</groupId>
      <artifactId>direct-sdk-java</artifactId>
      <version>x.y.z</version>
    </dependency>

Alternatively, download the latest version of the SDK from GitHub. Choose the `direct-sdk-java-x.y.z-bin.zip` file from the [releases](https://github.com/Ingenico/direct-sdk-java/releases) page, where `x.y.z` is the version number. Add all JAR files inside the `lib` folder of this file to your project, except for `direct-sdk-java-x.y.z-javadoc.jar` and `direct-sdk-java-x.y.z-sources.jar`

## Building the repository

This repository uses [Maven](http://maven.apache.org/) to build. To build the SDK, execute the following command from its root directory (which contains the `pom.xml` file):

    mvn -clean package

The build will generate the following files in the `target` directory, where `x.y.z` is the version number:
* `direct-sdk-java-x.y.z.jar`, containing the compiled class files
* `direct-sdk-java-x.y.z-javadoc.jar`, containing the generated Javadoc
* `direct-sdk-java-x.y.z-sources.jar`, containing the source code
* `direct-sdk-java-x.y.z-src.zip`, containing the contents of this folder
* `direct-sdk-java-x.y.z-bin.zip`, containing the necessary JAR files for standalone deployments and examples

To use it add all JAR files inside the `lib` folder of the `direct-sdk-java-x.y.z-bin.zip` file to your project, except for `direct-sdk-java-x.y.z-javadoc.jar` and `direct-sdk-java-x.y.z-sources.jar`.
