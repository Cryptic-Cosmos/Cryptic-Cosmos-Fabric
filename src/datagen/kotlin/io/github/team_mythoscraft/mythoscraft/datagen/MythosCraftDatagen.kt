/*
 * Copyright (c) 2020 Team MythosCraft.
 *
 * This file is part of MythosCraft.
 *
 * MythosCraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MythosCraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MythosCraft.  If not, see <https://www.gnu.org/licenses/>.
 */

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