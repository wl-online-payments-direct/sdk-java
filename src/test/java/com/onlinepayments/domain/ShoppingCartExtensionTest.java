package com.onlinepayments.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ShoppingCartExtensionTest {

    @Nested
    class WhenCreatedWithInvalidCreator {

        @Test
        void shouldThrowWhenCreatorIsNull() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new ShoppingCartExtension(null, "name", "1.0")
            );
        }

        @Test
        void shouldThrowWhenCreatorIsBlank() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new ShoppingCartExtension(" ", "name", "1.0")
            );
        }
    }

    @Nested
    class WhenCreatedWithInvalidName {

        @Test
        void shouldThrowWhenNameIsNull() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new ShoppingCartExtension("creator", null, "1.0")
            );
        }

        @Test
        void shouldThrowWhenNameIsBlank() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new ShoppingCartExtension("creator", " ", "1.0")
            );
        }
    }

    @Nested
    class WhenCreatedWithInvalidVersion {

        @Test
        void shouldThrowWhenVersionIsNull() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new ShoppingCartExtension("creator", "name", null)
            );
        }

        @Test
        void shouldThrowWhenVersionIsBlank() {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> new ShoppingCartExtension("creator", "name", " ")
            );
        }
    }

    @Nested
    class WhenCreatedWithValidArguments {

        @Test
        void shouldCreateInstanceWithExpectedValues() {
            ShoppingCartExtension extension = new ShoppingCartExtension("creator", "name", "1.0");

            assertEquals("creator", extension.getCreator());
            assertEquals("name", extension.getName());
            assertEquals("1.0", extension.getVersion());
            assertNull(extension.getExtensionId());
        }
    }

    @Nested
    class WhenCreatedWithOptionalId {

        @Test
        void shouldCreateInstanceWithExpectedValues() {
            ShoppingCartExtension extension =
                    new ShoppingCartExtension("creator", "name", "1.0", "extension-id");

            assertEquals("creator", extension.getCreator());
            assertEquals("name", extension.getName());
            assertEquals("1.0", extension.getVersion());
            assertEquals("extension-id", extension.getExtensionId());
        }
    }
}
