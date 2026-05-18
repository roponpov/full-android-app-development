import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option
import java.io.File

abstract class CreateFeatureTask : DefaultTask() {

    @get:Internal
    @set:Option(
        option = "feature",
        description = "Feature name"
    )
    var featureName: String = ""

    @TaskAction
    fun create() {

        if (featureName.isBlank()) {
            error("Feature name is required")
        }

        val basePath =
            "app/src/main/java/kh/roponpov/fullandroidappdevelopment/features"

        val featureDir = File(project.rootDir, "$basePath/$featureName")

        val folders = listOf(
            "models",
            "views",
            "viewmodel",
            "navigation",
            "sections",
            "components"
        )

        folders.forEach {
            File(featureDir, it).mkdirs()
        }

        println("✅ Feature created: $featureName")
        println("📁 ${featureDir.absolutePath}")
    }
}