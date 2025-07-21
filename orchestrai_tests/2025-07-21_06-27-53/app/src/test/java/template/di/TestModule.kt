package template.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = []  // Add any modules you want to replace for testing
)
object TestModule {
    // Add test-specific dependencies here if needed
    // For now, this is a placeholder for future test dependencies
}