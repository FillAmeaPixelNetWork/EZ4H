package me.liuli.ez4h.translators.bedrockTranslators;

import com.nukkitx.protocol.bedrock.BedrockPacket;
import com.nukkitx.protocol.bedrock.packet.SetEntityDataPacket;
import me.liuli.ez4h.EZ4H;
import me.liuli.ez4h.minecraft.bedrock.Client;
import me.liuli.ez4h.translators.BedrockTranslator;
import me.liuli.ez4h.translators.converters.MetadataConverter;

public class SetEntityDataPacketTranslator implements BedrockTranslator {
    @Override
    public void translate(BedrockPacket inPacket, Client client) {
        SetEntityDataPacket packet=(SetEntityDataPacket)inPacket;
        EZ4H.getConverterManager().getMetadataConverter().convert(packet.getMetadata(),client, (int) packet.getRuntimeEntityId());
    }

    @Override
    public Class<? extends BedrockPacket> getPacketClass() {
        return SetEntityDataPacket.class;
    }
}
