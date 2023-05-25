import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidModuleConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            pluginManager.apply("org.jetbrains.kotlin.android")

            extensions.configure<LibraryExtension> {
                compileSdk = 33

                defaultConfig {
                    minSdk = 24
                }

                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = "1.4.5"
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
            }

            tasks.withType<KotlinCompile>().configureEach {
                kotlinOptions {
                    jvmTarget = JavaVersion.VERSION_17.toString()
                }
            }

            dependencies {
                add("implementation", "androidx.core:core-ktx:1.6.0")
                add("implementation", "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
                add("implementation", "androidx.activity:activity-compose:1.7.1")
                add("implementation", "androidx.compose:compose-bom:2022.10.00")
                add("implementation", "androidx.compose.ui:ui")
                add("implementation", "androidx.compose.ui:ui")
                add("implementation", "androidx.compose.ui:ui-graphics")
                add("implementation", "androidx.compose.ui:ui-tooling-preview")
                add("implementation", "androidx.compose.material3:material3")
                add("implementation", "io.insert-koin:koin-core:3.4.0")
                add("implementation", "io.insert-koin:koin-android:3.4.0")
                add("implementation", "io.insert-koin:koin-androidx-compose:3.4.4")


                add("implementation", "project(':core:infrastructure')")
                add("implementation", "project(':core:design-system')")
                add("implementation", "project(':core:router')")

                add("testImplementation", "junit:junit:4.13.2")
                add("testImplementation", "io.mockk:mockk:1.13.5")
                add("testImplementation", "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
                add("testImplementation", "io.insert-koin:koin-test:3.4.0")
                add("testImplementation", "io.insert-koin:koin-test-junit4:3.4.0")

                add("androidTestImplementation", "androidx.test.ext:junit:1.1.5")
                add("androidTestImplementation", "androidx.test.espresso:espresso-core:3.5.1")
                add("androidTestImplementation", "androidx.compose.ui:ui-test-junit4")
                add("androidTestImplementation", "io.mockk:mockk-android:1.13.5")

                add("debugImplementation", "androidx.compose.ui:ui-tooling")
                add("debugImplementation", "androidx.compose.ui:ui-test-manifest")
            }
        }
    }
}