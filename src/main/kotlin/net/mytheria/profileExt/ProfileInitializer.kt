package net.mytheria.profileExt

import com.typewritermc.core.books.pages.Colors
import com.typewritermc.core.entries.Query
import com.typewritermc.core.entries.Ref
import com.typewritermc.core.extension.annotations.Entry
import com.typewritermc.core.extension.annotations.EntryListener
import com.typewritermc.core.interaction.context
import com.typewritermc.engine.paper.entry.TriggerableEntry
import com.typewritermc.engine.paper.entry.entries.EventEntry
import com.typewritermc.engine.paper.entry.triggerAllFor
import net.Indyuce.mmocore.api.event.PlayerChangeClassEvent

@Entry("class_selection_event", "MMOCore class selection event.", Colors.YELLOW, "material-symbols:bigtop-updates")
class ClassSelectionEvent (override val id: String = "", override val name: String = "", override val triggers: List<Ref<TriggerableEntry>> = emptyList(), ) : EventEntry {
}

@EntryListener(ClassSelectionEvent::class)
fun onEvent(event: PlayerChangeClassEvent, query: Query<ClassSelectionEvent>){
    val player = event.player
    player.teleport(player.location.world.spawnLocation)
    query.find().triggerAllFor(player, context())
}