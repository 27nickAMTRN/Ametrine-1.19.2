package net.nick.ametrine.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nick.ametrine.Ametrine;


public class ModSounds {
    public static final SoundEvent REAP = registerSoundEvent("reap");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Ametrine.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }


    public static void registerSounds() {
        Ametrine.LOGGER.info("Registering Mod Sounds" + Ametrine.MOD_ID);
    }
}
