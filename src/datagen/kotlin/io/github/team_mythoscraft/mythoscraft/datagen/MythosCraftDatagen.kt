package io.github.team_mythoscraft.mythoscraft.datagen

import me.shedaniel.cloth.api.datagen.v1.DataGeneratorHandler
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint
import org.apache.logging.log4j.LogManager
import java.nio.file.Paths
import kotlin.system.exitProcess

object MythosCraftDatagen : PreLaunchEntrypoint {
    private val LOGGER = LogManager.getLogger()

    /**
     * Runs the entrypoint.
     */
    override fun onPreLaunch() {
        try {
            val handler = DataGeneratorHandler.create(Paths.get("../src/generated/resources"))

            TODO("dont run this yet")

            handler.run()
        } catch (throwable: Throwable) {
            LOGGER.fatal("Error happened during datagen!", throwable)
            exitProcess(1)
        }

        exitProcess(0)
    }
}